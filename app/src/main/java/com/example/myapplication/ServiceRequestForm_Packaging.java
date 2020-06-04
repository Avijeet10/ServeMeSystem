package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ServiceRequestForm_Packaging extends AppCompatActivity {

    private EditText Short_description, Req_date, Req_time;
    private CheckBox agreement;
    private Button SubmitReq;
    private String description, date, time;
    private String userid, vendoremail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_request_form);
        Intent intent=getIntent();
        final String text= intent.getStringExtra(Display_Packaging.EXTRA_TEXT);

        Short_description = (EditText)findViewById(R.id.work_descript);
        Req_date = (EditText) findViewById(R.id.req_date);
        Req_time = (EditText) findViewById(R.id.req_time);
        agreement = (CheckBox) findViewById(R.id.checkBox);
        SubmitReq = (Button)findViewById(R.id.reqsubmitbtn);

        SubmitReq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                description = Short_description.getText().toString();
                date = Req_date.getText().toString();
                time = Req_time.getText().toString();

                if(TextUtils.isEmpty(description))
                {
                    Short_description.setError("Please enter a short description of the work!!");
                    Short_description.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(date))
                {
                    Req_date.setError("Enter a Valid Date");
                    Req_date.requestFocus();
                    return;
                }
                if(TextUtils.isEmpty(time))
                {
                    Req_time.setError("Enter a Valid time");
                    Req_time.requestFocus();
                    return;
                }
                if(!agreement.isChecked())
                {
                    Toast.makeText(ServiceRequestForm_Packaging.this,"Agreement needs to be check for further processing",Toast.LENGTH_LONG).show();
                    agreement.requestFocus();
                    return;
                }
                //useremail = FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();
                userid = FirebaseAuth.getInstance().getCurrentUser().getUid();
                FirebaseDatabase.getInstance().getReference("Customer").child(userid).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        User_Record user_record = dataSnapshot.getValue(User_Record.class);
                        String fn = user_record.getFirstName();
                        String ln = user_record.getLastName();
                        String uemail = user_record.getEmail();
                        String add = user_record.getStAddress();
                        String zip = user_record.getZipcode();

                        String transid = FirebaseDatabase.getInstance().getReference("Transaction").push().getKey();
                        Transaction_Handler transaction_handler = new Transaction_Handler("Requested",userid,fn,ln,add,zip,uemail,description,date,time,text," "," "," "," "," ",transid);

                        FirebaseDatabase.getInstance().getReference("Transaction")
                                .child(transid)
                                .setValue(transaction_handler).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task)
                            {
                                Toast.makeText(getApplicationContext(),"Service Requested to the Vendor",Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(),HomePage.class));
                                finish();
                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
