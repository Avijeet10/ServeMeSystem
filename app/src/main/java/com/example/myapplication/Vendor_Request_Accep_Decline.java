package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Vendor_Request_Accep_Decline extends AppCompatActivity {
    private Button Accept,Decline;
    EditText Price;
    private FirebaseDatabase firebaseDatabase;
    private String userid,cname,cadd,czip,cphnum,price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor__request__accep__decline);
        Intent intent=getIntent();
        final String text= intent.getStringExtra(RequestLists.EXTRA_TEXT);
        Accept = (Button)findViewById(R.id.Btn_Accept);
        Decline = (Button) findViewById(R.id.Btn_Decline);
        Price = (EditText) findViewById(R.id.service_price);

        userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase.getInstance().getReference("Vendors").child(userid).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Vendor_Record vendor_record = dataSnapshot.getValue(Vendor_Record.class);
                cname = vendor_record.getCompanyName();
                cadd = vendor_record.getCompanyAddress();
                cphnum = vendor_record.getPhnum();
                czip = vendor_record.getCompanyZip();
                FirebaseDatabase.getInstance().getReference("Transaction").child(text).child("vendorCname").setValue(cname);
                FirebaseDatabase.getInstance().getReference("Transaction").child(text).child("vendorAddress").setValue(cadd);
                FirebaseDatabase.getInstance().getReference("Transaction").child(text).child("vendorZip").setValue(czip);
                FirebaseDatabase.getInstance().getReference("Transaction").child(text).child("vendorPh").setValue(cphnum);
                /*FirebaseDatabase.getInstance().getReference("Transaction").child(text)
                        .addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                Transaction_Handler th = dataSnapshot.getValue(Transaction_Handler.class);
                                th.setVendorCname(cname);
                                th.setVendorAddress(cadd);
                                th.setVendorZip(czip);
                                th.setVendorPh(cphnum);
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });*/
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        Accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                price = Price.getText().toString();
                if(TextUtils.isEmpty(price))
                {
                    Price.setError("Enter a service charge to Accept");
                    Price.requestFocus();
                    return;
                }
                Toast.makeText(getApplicationContext(),"Request Successfully Accepted",Toast.LENGTH_SHORT).show();
                FirebaseDatabase.getInstance().getReference("Transaction").child(text).child("status").setValue("VendorAccepted");
                FirebaseDatabase.getInstance().getReference("Transaction").child(text).child("price").setValue(price);
                finish();
                startActivity(new Intent(getApplicationContext(),VendorHomePage.class));
                finish();
            }
        });
        Decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference("Transaction").child(text).child("status").setValue("VendorDeclined");
                Toast.makeText(getApplicationContext(),"Request Successfully Declined",Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(getApplicationContext(),VendorHomePage.class));
                finish();

            }
        });
    }
}
