package com.example.myapplication;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.util.Log;
import android.widget.Toast;


import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class User_Accpted_by_Vendor extends AppCompatActivity {
    public static final String EXTRA_TEXT="com.example.myapplication.EXTRA_TEXT";
    // public static final String EXTRA_TEXT="com.example.myapplication.EXTRA_TEXT";
    private static final String TAG = "User_Accepted_by_Vendor";
    private Button accept, decline;
    ListView listView;
    FirebaseDatabase database;
    DatabaseReference ref;
    //ArrayList<String> list;
    //ArrayAdapter<String> adapter;
    Transaction_Handler user;
    private  int count= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor__list);
        //accept=(Button)findViewById(R.id.button4);
        //decline=(Button)findViewById(R.id.button3);
        Log.d(TAG, "onCreate: Started");
        final ListView mListView = (ListView) findViewById(R.id.ListView);
        user = new Transaction_Handler();
        // listView=(ListView)findViewById(R.id.ListView);
        database = FirebaseDatabase.getInstance();
        ref = database.getReference("Transaction");
        // list = new ArrayList<>();
        final ArrayList<Transaction_Handler> vendorList = new ArrayList<>();
        final String customeremail = FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();
        //adapter=new ArrayAdapter<String>(this,R.layout.vendor_choosen_list,R.id.vendorinfo,list);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull final DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    user = ds.getValue(Transaction_Handler.class);
                    String search = user.getStatus().toString();
                    String getvendoremail=user.getCustomerEmail().toString();
                    if (search.equals("VendorAccepted") && customeremail.equals(getvendoremail) ) {
                        vendorList.add(user);
                        count++;
                    }
                }
                if (count==0)
                {
                    Toast.makeText(getApplicationContext(),"No Request Found",Toast.LENGTH_SHORT).show();
                }
                User_Accepted_by_vendor_adapter adapter = new  User_Accepted_by_vendor_adapter(User_Accpted_by_Vendor.this, R.layout.activity_user__requested_list, vendorList);
                mListView.setAdapter(adapter);

                mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        String key = vendorList.get(position).getTransID();


                        finish();
                        Intent intent=new Intent(User_Accpted_by_Vendor.this,Price_Accept_By_Costumer.class);
                        intent.putExtra(EXTRA_TEXT,key);
                        startActivity(intent);
                        finish();
                    }
                });

            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}