package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RatingBar.OnRatingBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import android.os.Bundle;

public class ReviewAndRating extends AppCompatActivity {

    private Button Submitreview;
    private EditText Review;
    private RatingBar Rating;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review_and_rating);

        Review = (EditText) findViewById(R.id.review);
        Rating = (RatingBar) findViewById(R.id.ratingBar);
        Submitreview = (Button) findViewById(R.id.submitreview);
        final String star = "";
        Rating.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                String stars = ""+ Rating.getNumStars();
                Toast.makeText(getApplicationContext(),stars,Toast.LENGTH_SHORT).show();
            }
        });

        Submitreview.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });


    }


}
