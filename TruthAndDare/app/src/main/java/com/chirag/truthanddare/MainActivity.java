package com.chirag.truthanddare;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ImageView bottle ;
    Button btn ;
    int initial , Final;
    MediaPlayer p ;
    AlertDialog.Builder b ;
    TextView spin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottle= findViewById(R.id.bottle);
        spin=findViewById(R.id.spin);
        btn=findViewById(R.id.btn);
        spin.setVisibility(View.INVISIBLE);
        b=new AlertDialog.Builder(this);
        b.setTitle("         You Are Welcome");
        b.setMessage("press OK to Continue");
        b.setCancelable(false);
        b.setIcon(R.drawable.round1);
        b.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                rotateBottle();
            }
        });
        b.show();
        p=MediaPlayer.create(MainActivity.this,R.raw.eighth);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                spin.setVisibility(View.VISIBLE);
                rotateBottle();


            }


        });
    }
    private void rotateBottle() {
        p=MediaPlayer.create(MainActivity.this,R.raw.chirag);
        p.start();
        Random r = new Random();
        Final=r.nextInt(3600000)+3600;
        float x ,y;
        x=bottle.getWidth()/2;
        y=bottle.getHeight()/2;
        Animation rotate =  new RotateAnimation(initial,Final,x,y);
        rotate.setDuration(4000);
        rotate.setFillAfter(true);
        rotate.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                btn.setClickable(false);

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                btn.setClickable(true);
                spin.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        bottle.startAnimation(rotate);
        initial=Final;
    }
}
