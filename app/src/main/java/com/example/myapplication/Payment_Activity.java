package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Payment_Activity extends AppCompatActivity {
    private TextView payment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_);
        //Intent intent=getIntent();
/*
        String text= intent.getStringExtra(Display_Appliances.EXTRA_TEXT);
        payment=(TextView)findViewById(R.id.pay);
        payment.setText(text);
        */

}
}
