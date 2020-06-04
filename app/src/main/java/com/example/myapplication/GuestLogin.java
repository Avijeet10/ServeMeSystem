package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class GuestLogin extends AppCompatActivity {

    private EditText Guest_FN, Guest_LN,Guest_Add,Guest_Zip;
    private Button Submit;
    private ProgressBar pB;
    private FirebaseAuth mAuth;
    private DatabaseReference dataRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_login);
        Guest_FN = (EditText) findViewById(R.id.Guest_firstname);
        Guest_LN = (EditText) findViewById(R.id.Guest_lastname);
        Guest_Add = (EditText) findViewById(R.id.Guest_Address);
        Guest_Zip = (EditText) findViewById(R.id.Guest_zipcode);
        Submit = (Button) findViewById(R.id.Submit);
        pB = (ProgressBar) findViewById(R.id.progressBar3);
        mAuth = FirebaseAuth.getInstance();
        dataRef = FirebaseDatabase.getInstance().getReference();

        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String firstname = Guest_FN.getText().toString();
                final String lastname = Guest_LN.getText().toString();
                final String address = Guest_Add.getText().toString();
                final String zipcode = Guest_Zip.getText().toString();
                if(TextUtils.isEmpty(firstname)||TextUtils.isEmpty(lastname))
                {
                    Guest_FN.setError("Name is a Required Field");
                    Guest_LN.setError("Name is a Required Field");
                    Guest_FN.requestFocus();
                    return;
                }

                if(TextUtils.isEmpty(address)||TextUtils.isEmpty(zipcode))
                {
                    Guest_Add.setError("Address is a Required Field");
                    Guest_Zip.setError("Address is a Required Field");
                    Guest_Add.requestFocus();
                    return;
                }
                final Guest_Info guest = new Guest_Info(firstname,lastname,address,zipcode);
                mAuth.signInAnonymously().addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        FirebaseDatabase.getInstance().getReference("Guests")
                                .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                .setValue(guest).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(GuestLogin.this,"Signed in as Guest",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(GuestLogin.this,HomePage.class));
                            }
                        });

                    }
                });
            }
        });
    }
}
