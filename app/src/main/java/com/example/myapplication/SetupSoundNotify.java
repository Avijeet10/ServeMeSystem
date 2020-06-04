package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SetupSoundNotify extends AppCompatActivity {

   private Button SignOff;
    //@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup_sound_notify);

        SignOff=(Button)findViewById(R.id.Exit3);

        SignOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(SetupSoundNotify.this,MainActivity.class);
                finish();
                startActivity(intent);
                finish();
            }
        });

    }
}
