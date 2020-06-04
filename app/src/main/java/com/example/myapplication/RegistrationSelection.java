package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RegistrationSelection extends AppCompatActivity {

    private Button customerReg, VendorReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_selection);

        customerReg = (Button) findViewById(R.id.CustomerReg);
        VendorReg = (Button) findViewById(R.id.VendorReg);
        customerReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationSelection.this,CustomerRegistration.class));
                finish();
            }
        });
        VendorReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegistrationSelection.this,VendorServiceSelect.class));
                finish();
            }
        });


    }
}
