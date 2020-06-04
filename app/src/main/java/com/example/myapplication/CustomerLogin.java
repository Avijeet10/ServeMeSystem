package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerLogin extends AppCompatActivity {
    private Button Login;
    private EditText user,pass;
    private String username,password;
    private int count = 5;
    private TextView forgotpw,guest,Register;
    private FirebaseAuth mAuth;
    private int num;
    private ProgressDialog pD;
    private DatabaseReference dataRef,reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);
        Register = (TextView) findViewById(R.id.logvendor);
        Login = (Button) findViewById(R.id.button_sign_in);
        user = (EditText) findViewById(R.id.comp_username);
        pass = (EditText) findViewById(R.id.customer_pass);
        forgotpw = (TextView) findViewById(R.id.text_view_forget_password);
        guest = (TextView) findViewById(R.id.guest);

        RelativeLayout constraintLayout=findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(2000);
        animationDrawable.setExitFadeDuration(4000);
        animationDrawable.start();
        dataRef = FirebaseDatabase.getInstance().getReference().child("Customer");
        //dataRef = FirebaseDatabase.getInstance().getReference();
        mAuth = FirebaseAuth.getInstance();

        pD = new ProgressDialog(CustomerLogin.this);


        Login.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                username = user.getText().toString();
                password = pass.getText().toString();
                final String email = username;

                if(TextUtils.isEmpty(username))
                {
                    user.setError("Please Enter a valid Email Address");
                    user.requestFocus();
                    //Toast.makeText(MainActivity.this,"Please enter a valid username",Toast.LENGTH_LONG).show();
                    //user.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(password))
                {
                    pass.setError("Please Enter a valid Password");
                    pass.requestFocus();
                    //Toast.makeText(MainActivity.this,"Please enter a valid password",Toast.LENGTH_LONG).show();
                    return;
                }

                pD.setMessage("Logging In, Please Wait...");
                pD.show();
                mAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener(CustomerLogin.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful())
                        {
                            String userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                            //Display(parent);
                            Display("Logged In Successfully!!");
                            //Display("Welcome " +mAuth.getCurrentUser().getEmail().toString());
                            //finish();
                            startActivity(new Intent(CustomerLogin.this, HomePage.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK));
                            count = 5;
                            finish();
                        }
                        else {
                            count--;
                            if(count==0)
                            {
                                Login.setEnabled(false);
                                Display("Login Attempt exceeded, Please Reset your password!!");
                            }
                            else {
                                Display(task.getException().getMessage()+": " + count + " attempts left");
                            }
                        }
                        pD.dismiss();
                    }
                });
                //Display("Here 1");
                //dataRef.child("messages").setValue("Hello");
            }
        });

        Register.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                startActivity(new Intent(CustomerLogin.this,CustomerRegistration.class));
                //finish();
            }
        });

        guest.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                pD.setMessage("Logging In as Guest, Please Wait...");
                pD.show();
                startActivity(new Intent(CustomerLogin.this,GuestLogin.class));
                finish();
                pD.dismiss();

            }
        });
        forgotpw.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(CustomerLogin.this,PWReset.class));
            }
        });
    }


    protected void Display(String s)
    {
        Toast.makeText(CustomerLogin.this,s,Toast.LENGTH_SHORT).show();
    }

}
