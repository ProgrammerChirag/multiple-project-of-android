package com.chirag.tiktaktoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9;
    MediaPlayer m=new MediaPlayer();
    TextView n1,n2,chance;
    int attempt=0;
    boolean player1=true;


    Intent i = new Intent();
    String name1 , name2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name1=getIntent().getStringExtra("name1");
        name2=getIntent().getStringExtra("name2");
        findidofbutton();
        buttonlistener();
        chance=findViewById(R.id.chance);
        n1=findViewById(R.id.person1_name);
        n2=findViewById(R.id.person2_name);
        n1.setText(name1);
        n2.setText(name2);
        chance.setText("Active User:"+name1);
    }

    private void buttonlistener() {
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonclick(b1);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonclick(b2);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonclick(b3);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonclick(b4);

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonclick(b5);

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonclick(b6);

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonclick(b7);

            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonclick(b8);

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buttonclick(b9);

            }
        });

    }

    private void buttonclick(Button btext) {
        if(btext.getText().toString().equals("")){


                if (player1) {
                    attempt++;
                    player1 = false;
                    String str = "Active User:" + name2;
                    chance.setText(str);
                    btext.setText("x");
                    endGame("x");
                } else {
                    attempt++;
                    String str = "Active User:" + name1;
                    chance.setText(str);
                    player1 = true;
                    btext.setText("0");
                    endGame("0");
                }
            }
        }


    private void endGame(String x) {
        boolean end=false;
        String a,b,c,d,e,f,g,h,i;
        a=b1.getText().toString();
        b=b2.getText().toString();
        c=b3.getText().toString();
        d=b4.getText().toString();
        e=b5.getText().toString();
        f=b6.getText().toString();
        g=b7.getText().toString();
        h=b8.getText().toString();
        i=b9.getText().toString();
        if(a==x&&b==x&&c==x){
            Winx(x);
            end=true;
        }
        if(a==x&&d==x&&g==x){
            Winx(x);
            end=true;
        }
        if(a==x&&e==x&&i==x){
            Winx(x);
            end=true;
        }
        if(b==x&&e==x&&h==x){
            Winx(x);
            end=true;
        }
        if(c==x&&f==x&&i==x){
            Winx(x);
            end=true;
        }
        if(c==x&&e==x&&g==x){
            Winx(x);
            end=true;
        }if(d==x&&e==x&&f==x){
            Winx(x);
            end=true;
        }if(g==x&&h==x&&i==x){
            Winx(x);
            end=true;
        }

        if(end==true){
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
        }
    }
    private void Winx(String x) {
        AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
        build.setCancelable(false);
        build.setTitle("Winner Announcement");
        build.setMessage("Winner is "+x);
        ImageView ii =new ImageView(MainActivity.this);
        ii.setImageResource(R.drawable.win);
        build.setView(ii);
        m=MediaPlayer.create(MainActivity.this,R.raw.win);
        m.start();
        build.setPositiveButton("new Game", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                newGame();

            }
        });
        build.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();

            }
        });
        build.show();
    }

    private void newGame() {
        b1.setText("");
        b1.setEnabled(true);

        b2.setText("");
        b2.setEnabled(true);

        b3.setText("");
        b3.setEnabled(true);

        b4.setText("");
        b4.setEnabled(true);

        b5.setText("");
        b5.setEnabled(true);

        b6.setText("");
        b6.setEnabled(true);

        b7.setText("");
        b7.setEnabled(true);

        b8.setText("");
        b8.setEnabled(true);

        b9.setText("");
        b9.setEnabled(true);


    }


    private void findidofbutton() {
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);
        b4=findViewById(R.id.b4);
        b5=findViewById(R.id.b5);
        b6=findViewById(R.id.b6);
        b7=findViewById(R.id.b7);
        b8=findViewById(R.id.b8);
        b9=findViewById(R.id.b9);


    }

}
