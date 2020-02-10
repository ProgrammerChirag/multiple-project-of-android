package com.chirag.keypad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    public Button one,two,three,four,five,six,seven,eight,nine,zero,star,hash;
    public ImageView call,cancel;
    public EditText number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        number=findViewById(R.id.number);

        call=findViewById(R.id.call);
        cancel=findViewById(R.id.cancel);


        setContentView(R.layout.activity_main);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        zero=findViewById(R.id.zero);
        star=findViewById(R.id.star);
        hash=findViewById(R.id.hash);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=findViewById(R.id.number);
                if(number.getText().toString().equals("0")){
                    number.setText("1");
                }
                else
                number.append("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=findViewById(R.id.number);
                if(number.getText().toString().equals("0")){
                    number.setText("2");}else
                    number.append("2");

            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=findViewById(R.id.number);
                if(number.getText().toString().equals("0")){
                    number.setText("3");}else
                    number.append("3");

            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=findViewById(R.id.number);
                if(number.getText().toString().equals("0")){
                    number.setText("4");}else
                    number.append("4");

            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=findViewById(R.id.number);
                if(number.getText().toString().equals("0")){
                    number.setText("5");}else
                    number.append("5");

            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=findViewById(R.id.number);
                if(number.getText().toString().equals("0")){
                    number.setText("6");}else
                    number.append("6");

            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=findViewById(R.id.number);
                if(number.getText().toString().equals("0")){
                    number.setText("7");}else
                    number.append("7");

            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=findViewById(R.id.number);
                if(number.getText().toString().equals("0")){
                    number.setText("8");}else
                    number.append("8");

            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=findViewById(R.id.number);
                if(number.getText().toString().equals("0")){
                    number.setText("9");}else
                    number.append("9");

            }
        });
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=findViewById(R.id.number);
                if(number.getText().toString().equals("0")){
                    number.setText("*");}else
                    number.append("*");

            }
        });
        hash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=findViewById(R.id.number);
                if(number.getText().toString().equals("0")){
                    number.setText("#");}else
                    number.append("#");

            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=findViewById(R.id.number);
                if(number.getText().toString().equals("0")){
                    number.setText("0");}else
                    number.append("0");

            }
        });
        cancel=findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=findViewById(R.id.number);
                if(number.getText().toString().isEmpty()!=true) {
                    String str = number.getText().toString();
                    String str1 = str.substring(0, str.length() - 1);
                    number.setText(str1);
                }
            }
        });
        call=findViewById(R.id.call);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=findViewById(R.id.number);
                String  str=number.getText().toString();
                Intent i = new Intent(Intent.ACTION_DIAL);
                String str1="tel:"+str;
                i.setData(Uri.parse(str1));
                startActivity(i);
            }
        });



    }
}
