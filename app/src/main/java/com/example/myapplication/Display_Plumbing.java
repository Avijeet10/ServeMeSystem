package com.example.myapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.util.Log;


import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class Display_Plumbing extends AppCompatActivity {
    public static final String EXTRA_TEXT="com.example.myapplication.EXTRA_TEXT";
    private static final String TAG = "Display-Plumbing";
    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    //ArrayList<String> list;
    //ArrayAdapter<String> adapter;
    RecyclerViewAdapter user;
    private  int count= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor__list);
        Log.d(TAG, "onCreate: Started");
        final ListView mListView = (ListView) findViewById(R.id.ListView);
        user = new RecyclerViewAdapter();
        // listView=(ListView)findViewById(R.id.ListView);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Vendors");
        // list = new ArrayList<>();
        final ArrayList<RecyclerViewAdapter> vendorList = new ArrayList<>();
        //adapter=new ArrayAdapter<String>(this,R.layout.vendor_choosen_list,R.id.vendorinfo,list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    user = ds.getValue(RecyclerViewAdapter.class);
                    String search = user.getServiceType().toString();
                    if (search.equals("Plumbling")) {
                        vendorList.add(user);
                        count++;
                    }
                }
                if (count==0)
                {
                    finish();
                    startActivity(new Intent(Display_Plumbing.this,No_vendors_Available.class));
                }


                VendorListAdapter adapter = new VendorListAdapter(Display_Plumbing.this, R.layout.vendor_choosen_list, vendorList);
                mListView.setAdapter(adapter);
                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String text = vendorList.get(position).getEmail();
                        Intent intent=new Intent(Display_Plumbing.this,ServiceRequestForm_Plumbing.class);
                        intent.putExtra(EXTRA_TEXT,text);
                        startActivity(intent);
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}