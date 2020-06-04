package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

public class VerifyierPopup extends AppCompatActivity {

    private CheckBox agreebox,finalizebox,termsbox;
    private Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verifyier_popup);
        Intent intent=getIntent();
        final String text= intent.getStringExtra(Vendor_Service_History.EXTRA_TEXT);

        agreebox = (CheckBox) findViewById(R.id.agree_checkBox);
        finalizebox = (CheckBox) findViewById(R.id.agree_checkBox2);
        termsbox = (CheckBox) findViewById(R.id.comp_checkBox);
        submit = (Button) findViewById(R.id.finalize);

        finalizebox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!agreebox.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"Please check on the agreement",Toast.LENGTH_SHORT).show();
                    agreebox.requestFocus();
                    return;
                }
                else if(!finalizebox.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"Please check on the agreement",Toast.LENGTH_SHORT).show();
                    finalizebox.requestFocus();
                    return;
                }
                else if(!termsbox.isChecked())
                {
                    Toast.makeText(getApplicationContext(),"Please check on the agreement",Toast.LENGTH_SHORT).show();
                    termsbox.requestFocus();
                    return;
                }
                else {
                    FirebaseDatabase.getInstance().getReference("Transaction").child(text).child("status").setValue("Completed");
                    Toast.makeText(getApplicationContext(), "Transaction Successfully Completed", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(getApplicationContext(), VendorHomePage.class));
                    finish();
                }
            }
        });

    }
}
