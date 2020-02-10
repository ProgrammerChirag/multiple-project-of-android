package com.chirag.myloginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class secondActivity extends AppCompatActivity {
    public ProgressBar bar;
    public Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        bar=findViewById(R.id.bar);
        btn=findViewById(R.id.click);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open(v);
            }
        });
    }
    public void open(View v){
        Intent i =new Intent(v.getContext(),MainActivity.class);
        startActivity(i);
    }
}
