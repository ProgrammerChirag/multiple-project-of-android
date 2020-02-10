package com.chirag.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public Button ac,del,extra,devision,seven,eight,nine,four,five,six,one,two,three,zero,percent,dot;
    public Button multiplication,subtraction,plus,equal;
    public TextView input,screen;
    public TextView result;
    Double left , right;
    boolean dot_one=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        equal=findViewById(R.id.equal);
        input=findViewById(R.id.input);
        extra=findViewById(R.id.extra);
        screen=findViewById(R.id.screen);
        result=findViewById(R.id.result);
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




        plus=findViewById(R.id.plu);
        subtraction=findViewById(R.id.subtraction);
        devision=findViewById(R.id.devide);
        multiplication=findViewById(R.id.X);
        percent=findViewById(R.id.percent);
        dot=findViewById(R.id.dot);
        ac=findViewById(R.id.ac);
        del=findViewById(R.id.del);
        extra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = input.getText().toString();
                char sign = str.charAt(0);
                if(sign!='+'&& sign!='-') sign ='-';
                else {
                    if(sign=='+') sign='-';
                    else sign='+';
                }
                input.setText(String.valueOf(sign));
                input.append(str);
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            if(input.getText().toString().equals("0")) input.setText("1");
            else
                input.append("1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().equals("0")) input.setText("2");
                else
                    input.append("2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().equals("0")) input.setText("3");
                else
                    input.append("3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().equals("0")) input.setText("4");
                else
                    input.append("4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().equals("0")) input.setText("5");
                else
                    input.append("5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().equals("0")) input.setText("6");
                else
                    input.append("6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().equals("0")) input.setText("7");
                else
                    input.append("7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().equals("0")) input.setText("8");
                else
                    input.append("8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().equals("0")) input.setText("9");
                else
                    input.append("9");
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(input.getText().toString().equals("0")) input.setText("0");
                else
                    input.append("0");
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("+");
                left=Double.parseDouble(input.getText().toString());
                input.setText("0");
            }
        });
        devision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("/");
                left=Double.parseDouble(input.getText().toString());
                input.setText("0");
            }
        });
        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input.setText("0");
                screen.setText("");
                result.setText("0");
            }
        });
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str;
                str=input.getText().toString();
                if(str.length()==1) input.setText("0");
                else{
                    str = str.substring(0, str.length() - 1);
                    input.setText(str);
                }
            }
        });
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dot_one==false ) {
                    input.append(".");
                }
                else{

                }
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("%");
                left=Double.parseDouble(input.getText().toString());
                input.setText("0");
            }
        });
        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("-");
                left=Double.parseDouble(input.getText().toString());
                input.setText("0");
            }
        });
        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                screen.setText("X");
                left=Double.parseDouble(input.getText().toString());
                input.setText("0");
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                right=Double.parseDouble(input.getText().toString());
                if(screen.getText().toString().equals("X")) run(left,right,"*");
                 else run(left,right,screen.getText().toString());
            }
        });
    }
    public void run(Double a , Double b ,String operator){
    switch(operator){
        case "+":
            result.setText(String.valueOf(a+b));
            input.setText("0"); screen.setText("");
            break;
        case "-":
            result.setText(String.valueOf(a-b));
            input.setText("0"); screen.setText("-");
            break;
        case "*":
            if(b==0) result.setText("0");
            else{
                if(String.valueOf(a*b).length()>8) {result.setTextSize(50); if(String.valueOf(a*b).length()>12) result.setTextSize(40);}
            result.setText(String.valueOf(a*b));
            input.setText("0"); screen.setText("");}
            break;
        case "/":
            if(b==0) result.setText("null");
            else {
                result.setText(String.valueOf(a / b));
                input.setText("0");
                screen.setText("");
            }
            break;
        case "%":
            result.setText(String.valueOf((a * b)/100));
            input.setText("0");
            screen.setText("");
    }
    }
}
