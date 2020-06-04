package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
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

public class VendorRegistration extends AppCompatActivity {

    private TextView info,service,service1;
    private EditText Cname, phnum, Email, id, passwords,Caddress,retailerid,Zip;
    private Button subm;
    private DatabaseReference dataRef;
    private FirebaseAuth mAuth;
    private ProgressDialog pD;
    private ProgressBar pB;
    private int ProgressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_registration);
        Intent intent=getIntent();
        String text= intent.getStringExtra(VendorServiceSelect.EXTRA_TEXT);

        Cname = (EditText)findViewById(R.id.comp_name);
        phnum = (EditText)findViewById(R.id.comp_phnum);
        Caddress = (EditText)findViewById(R.id.comp_address);
        Zip = (EditText)findViewById(R.id.comp_zipcode);
        service = (TextView)findViewById(R.id.servicetype);
        service1=(TextView)findViewById(R.id.servicetype1);
        retailerid = (EditText)findViewById(R.id.retailerid);
        Email = (EditText)findViewById(R.id.comp_email);
        id = (EditText)findViewById(R.id.comp_username);
        passwords = (EditText)findViewById(R.id.comp_pass);
        subm = (Button)findViewById(R.id.button2);
        info = (TextView)findViewById(R.id.info);
        pD = new ProgressDialog(this);
        pB = (ProgressBar) findViewById(R.id.progressBar2);

        service1.setText(text);
        pB.setMax(100);
        mAuth = FirebaseAuth.getInstance();
        dataRef = FirebaseDatabase.getInstance().getReference("Vendors");

        subm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String C_name = Cname.getText().toString();
                final String pnumber = phnum.getText().toString();
                final String add = Caddress.getText().toString();
                final String zip = Zip.getText().toString();
                final String serv = service1.getText().toString();
                final String ret_id = retailerid.getText().toString();
                final String email = Email.getText().toString();

                final String username = id.getText().toString();
                final String password = passwords.getText().toString();

                pD.setMessage("Signing up, Please Wait...");
                pD.show();
                if(C_name.isEmpty())
                {
                    Cname.setError(("Company Name is required!!"));
                    Cname.requestFocus();
                }
                else if(ret_id.isEmpty())
                {
                    retailerid.setError(("A valid retailer is required!!"));
                    retailerid.requestFocus();
                }
                else if(email.isEmpty())
                {
                    Email.setError("Plesae enter a valid Email Address");
                    Email.requestFocus();

                }
                else if(username.isEmpty())
                {
                    id.setError(("This field cannot be empty!!"));
                    id.requestFocus();
                }
                else if (password.isEmpty())
                {
                    passwords.setError(("Please enter a valid password"));
                    passwords.requestFocus();

                }
                else if (!email.equals(username))
                {
                    id.setError("Email doesn't match");
                    id.requestFocus();
                }
                else if(!(email.isEmpty() && password.isEmpty()))
                {
                    mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(VendorRegistration.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(!task.isSuccessful())
                            {
                                Toast.makeText(getApplicationContext(),"Registration Failure, please check your inputs",Toast.LENGTH_SHORT).show();
                            }
                            else
                            {
                                Vendor_Record user = new Vendor_Record(C_name,add,zip,pnumber,serv,ret_id,email,username,password);
                                FirebaseDatabase.getInstance().getReference("Vendors")
                                        .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                        .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task)
                                    {
                                        Toast.makeText(VendorRegistration.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(VendorRegistration.this,MainActivity.class));
                                        finish();
                                    }
                                });
                            }

                        }
                    });
                }
                else
                {
                    Toast.makeText(VendorRegistration.this,"Error occured ",Toast.LENGTH_SHORT).show();
                }
                pD.dismiss();
            }
        });

    }
}
