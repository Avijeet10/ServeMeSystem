package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class UserAppointmentChangeModify extends AppCompatActivity {

    private Button pending;
    private Button request;
    private Button signoff;
    private Button change;
    private ProgressDialog pD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_appointment_change_modify);

        pending = (Button)findViewById(R.id.schedule);
        request=(Button)findViewById(R.id.req);
        signoff=(Button)findViewById(R.id.exitt);
        change=(Button)findViewById(R.id.cancel);

        request.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UserAppointmentChangeModify.this,User_Requested_list.class);
                startActivity(intent);
            }
        });

        pending.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(UserAppointmentChangeModify.this,User_Accpted_by_Vendor.class);
                startActivity(intent);

            }
        });

        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Sorry, this feature is currently unavailable!!\nDevelopers are working on it",Toast.LENGTH_SHORT).show();
            }
        });

        signoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pD = new ProgressDialog(getApplicationContext());
                pD.setMessage("Signing Out!!");
                pD.show();
                FirebaseAuth.getInstance().signOut();
                finish();
                Intent intent4=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent4);
                finish();
            }
        });

    }
}
