package com.chirag.burgerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    public RatingBar r;
    public Button btn;
    public String str ;
    public EditText feedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        r=findViewById(R.id.rating_bar);
        btn=findViewById(R.id.submit);
        feedback=findViewById(R.id.feedback);
        r.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(getApplicationContext(),String.valueOf(rating),Toast.LENGTH_LONG).show();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float stars=0;
                if(String.valueOf(feedback.getText())==""){
                    Toast.makeText(getApplicationContext(),"Thanks For Your Rate And Feedback",Toast.LENGTH_LONG).show();
                }
                else {
                    str = String.valueOf(feedback.getText());
                    stars=r.getRating();
                    Toast.makeText(getApplicationContext(),"Thanks For Your Rate And Feedback",Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
