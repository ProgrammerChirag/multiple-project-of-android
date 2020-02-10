package com.chirag.diceroller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public  ImageView btn,btn2;
    public TextView score_1,score_2;
    public LinearLayout lay1 , lay2;
    public int score =0,score2=0;
    int attempt1=0,attempt2=0;
    public Button new_game,result;
    public boolean isclick=false;
    public AlertDialog.Builder build;
    public MediaPlayer m ,m2,m3;
    ImageView ii;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.dice);
        btn2=findViewById(R.id.dice2);
        score_1=findViewById(R.id.score_1);
        score_2=findViewById(R.id.score_2);
        lay1=findViewById(R.id.layout_one);
        lay2=findViewById(R.id.layout_two);
        result=findViewById(R.id.result);
        ii=new ImageView(this);
        build = new AlertDialog.Builder(MainActivity.this);
        m=MediaPlayer.create(MainActivity.this,R.raw.two);
        m2=MediaPlayer.create(MainActivity.this,R.raw.two);
        m3=MediaPlayer.create(MainActivity.this,R.raw.win);




        // button when first dice will clicked.


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m.start();

                if(isclick){
                    Toast.makeText(MainActivity.this,"first press new Game ",Toast.LENGTH_LONG).show();
                }
                else{
                btn.setSoundEffectsEnabled(true);
                if(attempt1>5){
                    btn2.setClickable(true);
                    Toast.makeText(MainActivity.this,"all attempt for first person has completed",Toast.LENGTH_LONG).show();
                }
                else {
                    int col=Color.argb(255,255,255,255);
                    lay1.setBackgroundColor(col);
                    col= Color.argb(255,249,221,164);
                    lay2.setBackgroundColor(col);
                    Random r = new Random();
                    int image_number = r.nextInt(6) + 1;
                    setImage(image_number, btn);
                    score = score + image_number;
                    score_1.setText("Score: ");
                    score_1.append(String.valueOf(score));
                    attempt1++;
                        btn2.setClickable(true);
                        btn.setClickable(false);
                }
            }
            }
        });


        // Button when second dice will clicked.


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m2.start();
                Toast.makeText(MainActivity.this,"first press new Game",Toast.LENGTH_LONG).show();
                if (isclick) {
                } else{ if (attempt1 == 0) {
                    Toast.makeText(MainActivity.this, "Its not your turn", Toast.LENGTH_LONG).show();
                } else {
                    if (attempt2 > 5) {
                        btn.setClickable(true);
                        Toast.makeText(MainActivity.this, "all attempt for second person has been completed", Toast.LENGTH_LONG).show();
                    } else {

                        int col = Color.argb(255, 255, 255, 255);
                        lay2.setBackgroundColor(col);
                        col = Color.argb(255, 249, 221, 164);
                        lay1.setBackgroundColor(col);
                        Random r = new Random();
                        int image_number = r.nextInt(6) + 1;
                        setImage(image_number, btn2);
                        score2 = score2 + image_number;
                        score_2.setText("Score: ");
                        score_2.append(String.valueOf(score2));

                        attempt2++;
                        btn.setClickable(true);
                        btn2.setClickable(false);
                    }
                }
            }
            }
        });

        // button when new game button will clicked.


        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (attempt1 < 6 && attempt2 < 6) {
                    Toast.makeText(MainActivity.this, "please coplete  the current game first", Toast.LENGTH_LONG).show();
                } else {
                    if (attempt2 > 5) {
                        m3.start();
                        isclick=true;
                        ii.setImageResource(R.drawable.chirag1);
                        int col=Color.argb(255,255,255,255);
                        build=getobj();
                        build.setView(ii);
                        build.setCancelable(false);

                        if (score2 > score) {

                            build.setMessage("Player 2 has won the game");
                            build.setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    getGame();
                                }
                            });
                            build.setNegativeButton("exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            final AlertDialog a= build.create();
                            if(a.getContext() != null){
                                a.show();
                            }
                        }
                        if (score > score2) {
                            build.setMessage("Player 1 has won the game");
                            ii.setImageResource(R.drawable.chirag1);
                            build.setPositiveButton("New Game", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    getGame();

                                }
                            });
                            build.setNegativeButton("exit", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    finish();
                                }
                            });
                            final AlertDialog a= build.create();

                            if(a.getContext() != null){
                                a.show();
                            }
                        }
                    }

                }
                isclick=false;
            }
        });
    }
    // function for set the image of dice.
    private void setImage(int image_number,ImageView dice) {
        switch (image_number){
            case 1:
                dice.setImageResource(R.drawable.dice1);
                break;
            case 2:
                dice.setImageResource(R.drawable.dice2);
                break;
            case 3:
                dice.setImageResource(R.drawable.dice3);
                break;
            case 4:
                dice.setImageResource(R.drawable.dice4);
                break;
            case 5:
                dice.setImageResource(R.drawable.dice5);
                break;
            case 6:
                dice.setImageResource(R.drawable.dice6);
                break;
        }
    }
    public void getGame(){
        isclick=false;
        attempt1=0;
        attempt2=0;
        score=0;
        score2=0;
        btn.setImageResource(R.drawable.dice1);
        btn2.setImageResource(R.drawable.dice1);
        score_1.setText("Score: ");
        score_2.setText("Score: ");
        int col=Color.argb(255,255,255,255);
        lay2.setBackgroundColor(col);
        col= Color.argb(255,249,221,164);
        lay1.setBackgroundColor(col);
        btn.setVisibility(View.VISIBLE);
        btn2.setVisibility(View.VISIBLE);
        score_2.setVisibility(View.VISIBLE);
        score_1.setVisibility(View.VISIBLE);
    }
    public AlertDialog.Builder getobj(){
        AlertDialog.Builder b = new AlertDialog.Builder(this);
        return b;
    }

}

/*
*
* */
