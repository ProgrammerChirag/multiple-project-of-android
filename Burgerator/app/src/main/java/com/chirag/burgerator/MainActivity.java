package com.chirag.burgerator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public ImageView ii;
    public RatingBar r ;
    public Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ii=findViewById(R.id.burger);
        r=findViewById(R.id.rating_bar);
        btn=findViewById(R.id.submit);
        r.setRating(5);
        r.setBackgroundColor(Color.argb(255,255,255,255));
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rate=r.getRating();
                if(rate==0){}
                else
                Toast.makeText(MainActivity.this,String.valueOf(rate),Toast.LENGTH_LONG).show();
            }
        });
        r.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this,String.valueOf(rating),Toast.LENGTH_LONG).show();
            }
        });
    }
}
