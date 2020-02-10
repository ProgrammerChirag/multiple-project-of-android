package com.chirag.selflearnloginpage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class profile extends AppCompatActivity {
    protected TextView t,about,one,two,three;
    com.mikhaellopez.circularimageview.CircularImageView ii;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        t=findViewById(R.id.person);
        about=findViewById(R.id.bio);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        ii=findViewById(R.id.image);
        if(getIntent().getStringExtra("user_name")!=null){

            String bio=getIntent().getStringExtra("bio");
            String name = getIntent().getStringExtra("user_name");
            t.setText(name);
            about.setText(bio);
            one.setText("0"); two.setText("0");three.setText("0");
            ii.setImageResource(R.drawable.images);
        }
        ii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder a = new AlertDialog.Builder(profile.this);
                a.setTitle("Do You want to add or change profile pic");
                a.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                       choose();
                    }
                });


                a.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                a.show();
            }
        });
    }
    public void choose(){

    }
}
