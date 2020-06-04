package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class HomePage extends AppCompatActivity {
    private Button Appliances,Packaging,Electrical,CompRepair,Plumbing,HomeRepair,HomeCleaning,PestControl,Tutoring;
    private ProgressDialog pD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Appliances=(Button)findViewById(R.id.ap);
        Packaging=(Button)findViewById(R.id.pa);
        Electrical=(Button)findViewById(R.id.el);
        CompRepair=(Button)findViewById(R.id.co);
        Plumbing=(Button)findViewById(R.id.pl);
        HomeRepair=(Button)findViewById(R.id.rep);
        HomeCleaning=(Button)findViewById(R.id.ho);
        PestControl=(Button)findViewById(R.id.pest);
        Tutoring=(Button)findViewById(R.id.tu);
        pD = new ProgressDialog(HomePage.this);

        Appliances.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pD.setMessage("Loading....");
                pD.show();
                startActivity(new Intent(HomePage.this,Display_Appliances.class));
                pD.dismiss();
            }
        });

        Electrical.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pD.setMessage("Loading....");
                pD.show();
                startActivity(new Intent(HomePage.this, Display_Electrical.class));
                pD.dismiss();
            }
        });
        Packaging.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pD.setMessage("Loading....");
                pD.show();
                startActivity(new Intent(HomePage.this, Display_Packaging.class));
                pD.dismiss();
            }
        });
        CompRepair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pD.setMessage("Loading....");
                pD.show();
                startActivity(new Intent(HomePage.this, Display_CompRepair.class));
                pD.dismiss();
            }
        });
        Plumbing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pD.setMessage("Loading....");
                pD.show();
                startActivity(new Intent(HomePage.this, Display_Plumbing.class));
                pD.dismiss();
            }
        });
        HomeRepair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pD.setMessage("Loading....");
                pD.show();
                startActivity(new Intent(HomePage.this, Display_HomeRepair.class));
                pD.dismiss();
            }
        });
        HomeCleaning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pD.setMessage("Loading....");
                pD.show();
                startActivity(new Intent(HomePage.this, Display_HomeCleaning.class));
                pD.dismiss();
            }
        });
        PestControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pD.setMessage("Loading....");
                pD.show();
                startActivity(new Intent(HomePage.this, Display_PestControl.class));
                pD.dismiss();
            }
        });
        Tutoring.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pD.setMessage("Loading....");
                pD.show();
                startActivity(new Intent(HomePage.this, Display_Tutoring.class));
                pD.dismiss();
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.appointment:
                Intent intent1=new Intent(HomePage.this,UserAppointmentChangeModify.class);
                startActivity(intent1);

        }
        switch (item.getItemId()){
            case R.id.ratevendor:
                Intent intent2=new Intent(HomePage.this, RateVendorServices.class);
                startActivity(intent2);

        }
        switch (item.getItemId()){
            case R.id.orderhistory:
                Intent intent3=new Intent(HomePage.this,User_Order_History.class);
                startActivity(intent3);

        }
        switch (item.getItemId()){
            case R.id.setup:
                Intent intent4=new Intent(HomePage.this,SetupSoundNotify.class);
                startActivity(intent4);

        }
        switch (item.getItemId()){
            case R.id.exit:
                pD = new ProgressDialog(HomePage.this);
                pD.setMessage("Signing Out!!");
                pD.show();
                FirebaseAuth.getInstance().signOut();
                finish();
                Intent intent4=new Intent(HomePage.this,MainActivity.class);
                startActivity(intent4);
                finish();

        }
        switch (item.getItemId()){
            case R.id.profile:
                startActivity(new Intent(HomePage.this,VIewUserProfile.class));
        }

        return super.onOptionsItemSelected(item);
    }
}