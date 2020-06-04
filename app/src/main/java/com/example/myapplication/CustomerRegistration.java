package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.LoginFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class CustomerRegistration extends AppCompatActivity {
    private TextView info;
    private EditText FirstName,LastName,StAddress,Zipcode,PhNum,Email,UserName,Password;
    private Button submit;
    private DatabaseReference dataRef;
    private FirebaseAuth mAuth;
    private ProgressBar pB;
    private ProgressDialog pD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);

        FirstName = (EditText) findViewById(R.id.FirstName);
        LastName = (EditText) findViewById(R.id.LastName);
        StAddress = (EditText) findViewById(R.id.StreetAddress);
        Zipcode = (EditText) findViewById(R.id.ZipCode);
        PhNum = (EditText) findViewById(R.id.PhNum);
        Email = (EditText) findViewById(R.id.Email);
        UserName = (EditText) findViewById(R.id.UserName);
        Password = (EditText) findViewById(R.id.Password);
        submit = (Button) findViewById(R.id.submit);

        pB = (ProgressBar) findViewById(R.id.progressBar);
        pD = new ProgressDialog(this);

        mAuth = FirebaseAuth.getInstance();
        dataRef = FirebaseDatabase.getInstance().getReference("Customer");

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Firstname = FirstName.getText().toString();
                final String Lastname = LastName.getText().toString();
                final String staddress = StAddress.getText().toString();
                final String zipcode = Zipcode.getText().toString();
                final String phnum = PhNum.getText().toString();
                final String email = Email.getText().toString();
                final String username = UserName.getText().toString();
                final String password = Password.getText().toString();

                if(Firstname.isEmpty())
                {
                    FirstName.setError(("First Name is required!!"));
                    FirstName.requestFocus();
                }
                else if(Lastname.isEmpty())
                {
                    LastName.setError(("Last Name is required!!"));
                    LastName.requestFocus();
                }
                else if(email.isEmpty())
                {
                    Email.setError("Plesae enter a valid Email Address");
                    Email.requestFocus();

                }
                else if(username.isEmpty())
                {
                    UserName.setError(("This field cannot be empty!!"));
                    UserName.requestFocus();
                }
                else if (password.isEmpty())
                {
                    Password.setError(("Please enter a valid password"));
                    Password.requestFocus();

                }
                else if(!email.equals(username))
                {
                    UserName.setError("Email doesn't match");
                    UserName.requestFocus();
                }
                else if(!(email.isEmpty() && password.isEmpty()&& username.isEmpty()))
                {
                    pD.setMessage("Signing up, Please Wait...");
                    pD.show();
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(CustomerRegistration.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {

                            if(!task.isSuccessful())
                            {

                                Toast.makeText(getApplicationContext(),"Registration Unsuccessful::\""+ task.getException().getMessage()+"\"",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                User_Record user = new User_Record(Firstname,Lastname,staddress,zipcode,phnum,email,username,password);

                                FirebaseDatabase.getInstance().getReference("Customer")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task)
                                    {
                                        Toast.makeText(CustomerRegistration.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(CustomerRegistration.this,MainActivity.class));
                                        finish();
                                    }

                                });
                            }
                            pD.dismiss();

                        }
                    });
                }
                else
                {
                    Toast.makeText(CustomerRegistration.this,"Error occured ",Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
