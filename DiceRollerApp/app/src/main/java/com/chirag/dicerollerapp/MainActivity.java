package com.chirag.dicerollerapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView i1,i2;
    Button btn;
    int score_1=0,score_2=0;
    int turn_1 =0, turn_2=0;
    Boolean one_turn=true,second_turn=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        i1=findViewById(R.id.person1);
        i2=findViewById(R.id.person2);
        btn=findViewById(R.id.result);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(false);
                builder.setTitle("winner Announcement");

                builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                   dialog.dismiss();
                    }
                });
                if(score_1>score_2){
                    builder.setMessage("winner is one");
                }
                if(score_2>score_1){
                    builder.setMessage("winner is two");
                }
                else{
                    builder.setMessage("Match Tie");
                }
                builder.show();
            }
        });

        btn.setEnabled(false);
        final int color= Color.argb(255,249,221,164);
        i1.setBackgroundColor(color);
        final Random random=new Random();
        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(one_turn){
                    if(turn_1>5){
                        i1.setEnabled(false);
                        btn.setEnabled(true);
                    }
                    else {
                        i1.setBackgroundColor(Color.argb(255, 255, 255, 255));
                        i2.setBackgroundColor(color);
                        int score = random.nextInt(6) + 1;
                        getimage(score, i1);
                        score_1 = score_1 + score;
                        one_turn = false;
                        second_turn = true;
                        turn_1++;
                    }
                }

            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(second_turn){
                    if(turn_2>5){
                        i2.setEnabled(false);
                        btn.setEnabled(true);
                    }
                    else {
                        i2.setBackgroundColor(Color.argb(255, 255, 255, 255));
                        i1.setBackgroundColor(color);
                        ;
                        int score = random.nextInt(6) + 1;
                        getimage(score, i2);
                        score_2 = score_2 + score;
                        one_turn = true;
                        second_turn = false;
                        turn_2++;
                    }}
            }
        });

    }

    private void getimage(int score,ImageView i) {
        switch (score){
            case 1:
                i.setImageResource(R.drawable.dice1);
                break;
            case 2:
                i.setImageResource(R.drawable.dice2);
                break;
            case 3:
                i.setImageResource(R.drawable.dice3);
                break;
            case 4:
                i.setImageResource(R.drawable.dice4);
                break;
            case 5:
                i.setImageResource(R.drawable.dice5);
                break;
            case 6:
                i.setImageResource(R.drawable.dice6);
                break;
        }
    }
}
