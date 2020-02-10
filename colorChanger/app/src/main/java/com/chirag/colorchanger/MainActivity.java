package com.chirag.colorchanger;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public Button click;
    public LinearLayout l;
    int click_button=0;
    int color[][]={
            {255,204,153},
            {0,102,255},
            {255,102,102},
            {0,0,255},
            {0,204,0},
            {153,102,51},
            {153,0,255},
            {204,51,0},
            {0,153,0},
            {204,0,0}
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click=findViewById(R.id.click);
        l=findViewById(R.id.lay);
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Random rand =new Random();
            int a=rand.nextInt(10);
            int col=Color.argb(255,color[a][0],color[a][1],color[a][2]);
                l.setBackgroundColor(col);
            }
        });
    }
}