package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;

public class VendorHomePage extends AppCompatActivity {

    private Button Profile,Ratings,ServiceHist,RequestLists,VendorSignOFF,completed;
    private FirebaseAuth mAuth;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_home_page);

        Profile = (Button) findViewById(R.id.VendorProfile);
        Ratings = (Button) findViewById(R.id.VendorRatings);
        ServiceHist = (Button) findViewById(R.id.VendServHist);
        RequestLists = (Button) findViewById(R.id.viewservicereq);
        VendorSignOFF = (Button) findViewById(R.id.VendorSignOut);
        completed=(Button)findViewById(R.id.VendorCompleted);

        Profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ViewVendorProfile.class));

            }
        });
        Ratings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ReviewAndRating.class));

            }
        });
        ServiceHist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Vendor_Service_History.class));

            }
        });
        RequestLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        VendorSignOFF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();

            }
        });
        completed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Completed_Services.class));

            }
        });
        RequestLists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(VendorHomePage.this, RequestLists.class);
                startActivity(intent);

            }
        });

    }
}