package com.chirag.sound_player;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
public Button b1,b2,b3,b4,b5,b6,b7,b8;
public MediaPlayer m1,m2,m3,m4,m5,m6,m7,m8;
public boolean active[]={false,false,false,false,false,false,false,false,false};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.sound_1);
        b2=findViewById(R.id.sound_2);
        b3=findViewById(R.id.sound_3);
        b4=findViewById(R.id.sound_4);
        b5=findViewById(R.id.sound_5);
        b6=findViewById(R.id.sound_6);
        b7=findViewById(R.id.sound_7);
        b8=findViewById(R.id.sound_8);

        // creating object of media player class
        m1 = MediaPlayer.create(this,R.raw.one);
        m2 = MediaPlayer.create(this,R.raw.two);
        m3 = MediaPlayer.create(this,R.raw.three);
        m4 = MediaPlayer.create(this,R.raw.four);
        m5 = MediaPlayer.create(this,R.raw.fv);
        m6 = MediaPlayer.create(this,R.raw.sixth);
        m7 = MediaPlayer.create(this,R.raw.seventh);
        m8 = MediaPlayer.create(this,R.raw.eighth);




        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               m2.stop();
               m3.stop();
               m4.stop();
               m5.stop();
               m6.stop();
               m7.stop();
               m8.stop();
               m1=create(1);
                Double d = Double.valueOf(m1.getDuration())/1000;
                Toast.makeText(getApplicationContext(),String.valueOf(d),Toast.LENGTH_LONG).show();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m1.stop();
                m3.stop();
                m4.stop();
                m5.stop();
                m6.stop();
                m7.stop();
                m8.stop();
                m2=create(2);
                Double d = Double.valueOf(m2.getDuration())/1000;
                Toast.makeText(getApplicationContext(),String.valueOf(d),Toast.LENGTH_LONG).show();
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m1.stop();
                m2.stop();
                m4.stop();
                m5.stop();
                m6.stop();
                m7.stop();
                m8.stop();
                m3=create(3);
                Double d = Double.valueOf(m3.getDuration())/1000;
                Toast.makeText(getApplicationContext(),String.valueOf(d),Toast.LENGTH_LONG).show();
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m2.stop();
                m3.stop();
                m1.stop();
                m5.stop();
                m6.stop();
                m7.stop();
                m8.stop();
                m4=create(4);
                Double d = Double.valueOf(m4.getDuration())/1000;
                Toast.makeText(getApplicationContext(),String.valueOf(d),Toast.LENGTH_LONG).show();
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m2.stop();
                m3.stop();
                m4.stop();
                m1.stop();
                m6.stop();
                m7.stop();
                m8.stop();
                m5=create(5);
                Double d = Double.valueOf(m5.getDuration())/1000;
                Toast.makeText(getApplicationContext(),String.valueOf(d),Toast.LENGTH_LONG).show();
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                m2.stop();
                m3.stop();
                m4.stop();
                m5.stop();
                m1.stop();
                m7.stop();
                m8.stop();
                m6=create(6);
                Double d = Double.valueOf(m6.getDuration())/1000;
                Toast.makeText(getApplicationContext(),String.valueOf(d),Toast.LENGTH_LONG).show();
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                m2.stop();
                m3.stop();
                m4.stop();
                m5.stop();
                m6.stop();
                m1.stop();
                m8.stop();
                m7=create(7);
                Double d = Double.valueOf(m7.getDuration())/1000;
                Toast.makeText(getApplicationContext(),String.valueOf(d),Toast.LENGTH_LONG).show();
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m2.stop();
                m3.stop();
                m4.stop();
                m5.stop();
                m6.stop();
                m7.stop();
                m1.stop();
                m8=create(8);
                Double d = Double.valueOf(m8.getDuration())/1000;
                Toast.makeText(getApplicationContext(),String.valueOf(d),Toast.LENGTH_LONG).show();
            }
        });
    }
    protected  void pause(int i){
        switch (i){
            case 1:
                m1.stop();
                break;

            case 2:
                m2.stop();
                break;

            case 3:
                m3.stop();
                break;

            case 4:
                m4.stop();
                break;

            case 5:
                m5.stop();
                break;

            case 6:
                m6.stop();
                break;

            case 7:
                m7.stop();
                break;

            case 8:
                m8.stop();
                break;
        }
    }
    public MediaPlayer create(int i){
        MediaPlayer m = null;

        switch (i) {


            case 1: m=MediaPlayer.create(this, R.raw.one); m.start(); break;
            case 2: m=MediaPlayer.create(this,R.raw.two);  m.start(); break;
            case 3: m=MediaPlayer.create(this,R.raw.three);m.start();  break;
            case 4: m=MediaPlayer.create(this,R.raw.four);  m.start();break;
            case 5: m=MediaPlayer.create(this,R.raw.fv);  m.start();break;
            case 6: m=MediaPlayer.create(this,R.raw.sixth);  m.start();break;
            case 7: m=MediaPlayer.create(this,R.raw.seventh);  m.start();break;
            case 8: m=MediaPlayer.create(this,R.raw.eighth);  m.start();break;
        }
        return m;
    }
}
