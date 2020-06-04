package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class PWReset extends AppCompatActivity
{
    private EditText email;
    private Button submit;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pwreset);
        email = (EditText) findViewById(R.id.forgot_email);
        submit = (Button) findViewById(R.id.Submit);
        mAuth = FirebaseAuth.getInstance();

        submit.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                final String resetemail = email.getText().toString();
                if(TextUtils.isEmpty(resetemail))
                {
                    email.setError("Enter a Valid Email address!!");
                    email.requestFocus();
                    return;
                }
                mAuth.sendPasswordResetEmail(resetemail)
                        .addOnCompleteListener(new OnCompleteListener<Void>()
                        {
                            @Override
                            public void onComplete(@NonNull Task<Void> task)
                            {
                                if (task.isSuccessful())
                                {
                                    Display("An email has been sent to the "+resetemail+". Please Check your email and follow the instructions. Thank You" );
                                    startActivity(new Intent(PWReset.this,MainActivity.class));
                                }
                                else
                                {
                                    Display("Error Occured! Please check your email and try again.");
                                }
                            }
                        });
            }
        });
    }
    protected void Display(String s)
    {
        Toast.makeText(PWReset.this,s,Toast.LENGTH_SHORT).show();
    }
}
