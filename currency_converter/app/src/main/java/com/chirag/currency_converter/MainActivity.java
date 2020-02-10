package com.chirag.currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button doll,aus,can,euro,pound;
    Button yen,arab,russian,bitcoin;
    Button clear;
    TextView t;
    EditText inr;
    String str;
    Double l,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doll = findViewById(R.id.dollor);

        t = findViewById(R.id.text);
        inr = findViewById(R.id.currency);
        aus=findViewById(R.id.ausdollor);
        can=findViewById(R.id.candollor);
        clear=findViewById(R.id.ex);
        euro =findViewById(R.id.euro);
        pound=findViewById(R.id.pound);
        yen =findViewById(R.id.yen);
        arab=findViewById(R.id.arab);
        russian=findViewById(R.id.russian);
        bitcoin=findViewById(R.id.bitcoin);
        doll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inr.getText().toString().equals("")) Toast.makeText(MainActivity.this,"please input the number first",Toast.LENGTH_LONG);
                else{
                 str = inr.getText().toString();
                 l = Double.parseDouble(str);
                 d= (l*0.014);
                String output = String.valueOf(d);
                t.setText(output);
            }}
        });
        aus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inr.getText().toString().equals("")) Toast.makeText(MainActivity.this,"please input the number first",Toast.LENGTH_LONG);
                else{
            str=inr.getText().toString();
            l=Double.parseDouble(str);
            d=l*0.020;
            String  output = String.valueOf(d);
            t.setText(output);
            }}
        });
        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inr.getText().toString().equals("")) Toast.makeText(MainActivity.this,"please input the number first",Toast.LENGTH_LONG);
                else{
                str=inr.getText().toString();
                l=Double.parseDouble(str);
                d=l*0.018;
                String  output = String.valueOf(d);
                t.setText(output);
            }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                t.setText("RESULT");
                inr.setText("");
            }
        });
        euro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inr.getText().toString().equals("")) Toast.makeText(MainActivity.this,"please input the number first",Toast.LENGTH_LONG);
                else{
                str=inr.getText().toString();
                l=Double.parseDouble(str);
                d=l*0.013;
                String  output = String.valueOf(d);
                t.setText(output);
            }}
        });
        pound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inr.getText().toString().equals("")) Toast.makeText(MainActivity.this,"please input the number first",Toast.LENGTH_LONG);
                else{
                str=inr.getText().toString();
                l=Double.parseDouble(str);
                d=l*0.011;
                String  output = String.valueOf(d);
                t.setText(output);
            }}
        });
        yen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inr.getText().toString().equals("")) Toast.makeText(MainActivity.this,"please input the number first",Toast.LENGTH_LONG);
                else{
                str=inr.getText().toString();
                l=Double.parseDouble(str);
                d=l*1.54;
                String  output = String.valueOf(d);
                t.setText(output);
            }}
        });
        arab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inr.getText().toString().equals("")) Toast.makeText(MainActivity.this,"please input the number first",Toast.LENGTH_LONG);
                else{
                str=inr.getText().toString();
                l=Double.parseDouble(str);
                d=l*0.053;
                String  output = String.valueOf(d);
                t.setText(output);
            }}
        });
        russian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inr.getText().toString().equals("")) Toast.makeText(MainActivity.this,"please input the number first",Toast.LENGTH_LONG);
                else{
                str=inr.getText().toString();
                l=Double.parseDouble(str);
                d=l*0.86;
                String  output = String.valueOf(d);
                t.setText(output);
            }}
        });
        bitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inr.getText().toString().equals("")) Toast.makeText(MainActivity.this,"please input the number first",Toast.LENGTH_LONG);
                else{
                str=inr.getText().toString();
                l=Double.parseDouble(str);
                d=l*0.0000018;
                String  output = String.valueOf(d);
                t.setText(output);
            }}
        });
    }
}
