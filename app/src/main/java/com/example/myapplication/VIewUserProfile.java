package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VIewUserProfile extends AppCompatActivity {

    private TextView FirstName, LastName, Email, Address, Zipcode, PhNum;
    private FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user_profile);

        FirstName = (TextView) findViewById(R.id.V_Companyname);
        LastName = (TextView) findViewById(R.id.P_lastname);
        Email = (TextView) findViewById(R.id.V_email);
        Address = (TextView) findViewById(R.id.V_address);
        Zipcode = (TextView) findViewById(R.id.V_zip);
        PhNum = (TextView) findViewById(R.id.V_phnum);

        //Email.setText(FirebaseAuth.getInstance().getCurrentUser().getUid());

        String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
        FirebaseDatabase.getInstance().getReference("Customer").child(userid).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                User_Record user_record = dataSnapshot.getValue(User_Record.class);
                if(user_record!=null) {
                    FirstName.setText("First Name: "+user_record.getFirstName());
                    LastName.setText("Last Name: "+user_record.getLastName());
                    Email.setText("Email: "+user_record.getEmail());
                    PhNum.setText("Ph. Number: "+user_record.getPhNum());
                    Address.setText("St. Address: "+user_record.getStAddress());
                    Zipcode.setText("Zip Code: "+user_record.getZipcode());

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"Failed",Toast.LENGTH_SHORT).show();

            }
        });

    }
}
