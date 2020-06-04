package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.w3c.dom.Text;

public class ViewVendorProfile extends AppCompatActivity {

    private TextView CompanyName, RetailerID, Email, Address, Zipcode, PhNum, Type;
    private FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vendor_profile);

        CompanyName = (TextView) findViewById(R.id.V_Companyname);
        RetailerID = (TextView) findViewById(R.id.V_Retid);
        Email = (TextView) findViewById(R.id.V_email);
        Address = (TextView) findViewById(R.id.V_address);
        Zipcode = (TextView) findViewById(R.id.V_zip);
        PhNum = (TextView) findViewById(R.id.V_phnum);
        Type = (TextView) findViewById(R.id.V_type);

        //Email.setText(FirebaseAuth.getInstance().getCurrentUser().getUid());

        String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase.getInstance().getReference("Vendors").child(userid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                Vendor_Record vendor_record = dataSnapshot.getValue(Vendor_Record.class);
                if(vendor_record!=null) {
                    CompanyName.setText("Company Name: "+vendor_record.getCompanyName());
                    Type.setText("Type: "+vendor_record.getServiceType());
                    Email.setText("Email: "+vendor_record.getEmail());
                    PhNum.setText("Ph. Number: "+vendor_record.getPhnum());
                    RetailerID.setText("Retailer ID: "+vendor_record.getRetailerId());
                    Address.setText("St. Address: "+vendor_record.getCompanyAddress());
                    Zipcode.setText("Zip Code: "+vendor_record.getCompanyZip());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
