package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class Price_Accept_By_Costumer extends AppCompatActivity {
    private Button acceptpaynow;
    private Button acceptpaylater;
    private Button decline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price__accept__by__costumer);
        acceptpaynow=(Button)findViewById(R.id.YES);
        acceptpaylater=(Button)findViewById(R.id.yeslater);
        decline=(Button)findViewById(R.id.NOdecline);
        Intent intent=getIntent();
        final String userid= intent.getStringExtra(User_Accpted_by_Vendor.EXTRA_TEXT);

        acceptpaynow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference("Transaction").child(userid).child("status").setValue("Paid");
                Toast.makeText(getApplicationContext(),"Payment Successfully Processed",Toast.LENGTH_SHORT).show();
                finish();
                startActivity(new Intent(getApplicationContext(),HomePage.class));
                finish();
            }
        });
        acceptpaylater.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference("Transaction").child(userid).child("status").setValue("Paid");
                Toast.makeText(getApplicationContext(),"Payment Successfully Processed",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),HomePage.class));
                finish();
            }
        });
        decline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseDatabase.getInstance().getReference("Transaction").child(userid).child("status").setValue("CustomerDeclined");
                Toast.makeText(getApplicationContext(),"Service has been declined",Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(),HomePage.class));
                finish();
            }
        });


    }
}
