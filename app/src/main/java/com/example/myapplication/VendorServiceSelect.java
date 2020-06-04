package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.RadioGroup;
public class VendorServiceSelect extends AppCompatActivity {
    public static final String EXTRA_TEXT="com.example.myapplication.EXTRA_TEXT";

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
    Button buttonApply;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_service_select);

        radioGroup = findViewById(R.id.radioGroup);
        textView = findViewById(R.id.text_view_selected);

        buttonApply =(Button) findViewById(R.id.button_apply);

        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int radioId = radioGroup.getCheckedRadioButtonId();

                //radioButton = findViewById(radioId);

                // textView.setText("Your choice: " + radioButton.getText());
                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);
                String text=radioButton.getText().toString();

                Intent intent=new Intent(VendorServiceSelect.this,VendorRegistration.class);
                intent.putExtra(EXTRA_TEXT,text);
                startActivity(intent  );
            }
        });
    }

    public void checkButton(View v) {
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(VendorServiceSelect.this, "Selected Service: " + radioButton.getText(),
                Toast.LENGTH_SHORT).show();

    }
}