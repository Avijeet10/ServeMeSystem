package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;


public class MainActivity extends AppCompatActivity {

    private Button LoginVendor,LoginCustomer,DEV;
    private TextView info;

    private FirebaseAuth mAuth;
    int count;

    private DatabaseReference dataRef,reference;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ConstraintLayout constraintLayout=findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();

        LoginVendor = (Button) findViewById(R.id.logvendor);
        LoginCustomer = (Button) findViewById(R.id.logcustomer);
        //DEV = (Button)findViewById(R.id.Dev);
        info = (TextView) findViewById(R.id.appinfo);

        //dataRef = FirebaseDatabase.getInstance().getReference("Customer");
        dataRef = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();
/*
        DEV.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                //String username = "shreroa@gmail.com";
                String username = "reparment@gmail.com";
                //String password = "abc12345";
                String password = "dsadada2131";

                mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful ())
                        {
                            Display("Logged In Successfully!!");
                            Display("Welcome " +mAuth.getCurrentUser().getEmail().toString());
                            //finish();
                            startActivity(new Intent(MainActivity.this, VendorHomePage.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                            count = 5;
                            //finish();
                        }
                        else {
                            count--;
                            if(count==0)
                            {
                                Display("Login Attempt exceeded, Please Reset your password!!");
                            }
                            else {
                                Display(task.getException().getMessage()+": " + count + " attempts left");
                            }
                        }
                    }
                });
                //Display("Here 1");
                //dataRef.child("messages").setValue("Hello");
            }
        });

*/
        LoginCustomer.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(MainActivity.this,CustomerLogin.class));
                //finish();


            }
        });

        LoginVendor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                startActivity(new Intent(MainActivity.this,VendorLogin.class));
                //finish();
            }
        });

        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),appinfo.class));
            }
        });



    }


    protected void Display(String s)
    {
        Toast.makeText(MainActivity.this,s,Toast.LENGTH_SHORT).show();
    }

}

