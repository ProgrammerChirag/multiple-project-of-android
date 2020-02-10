package com.chirag.lovecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public LinearLayout l;
    public EditText input1,input2;
    public ImageButton btn;
    public TextView result,fn,sn;
    boolean ispressed=false;
    String first,second;
    int res=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        l=findViewById(R.id.showlove);
        input1=findViewById(R.id.firstname);
        result=findViewById(R.id.result);
        input2=findViewById(R.id.secondname);
        btn=findViewById(R.id.click);
        l.setVisibility(View.INVISIBLE);
        result.setVisibility(View.INVISIBLE);
        fn=findViewById(R.id.fn);
        sn=findViewById(R.id.sn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.setVisibility(View.INVISIBLE);
                l.setVisibility(View.INVISIBLE);
                if(input1.getText().toString().equals("")||input2.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"please enter your name and your partner name",Toast.LENGTH_LONG).show();
                    ispressed=false;

                }else{
                    if(ispressed==true&&input2.getText().toString().equals(second)&&input1.getText().toString().equals(first)){
                        result.setText(String.valueOf(res)+"%");
                        result.setVisibility(View.VISIBLE);
                        fn.setText(input1.getText().toString());
                        sn.setText(input2.getText().toString());
                        l.setVisibility(View.VISIBLE);
                        ispressed=true;
                    }
                    else{
                    Random r = new Random();
                    int i=r.nextInt(30);
                    int min=70;
                    res=i+min;
                    result.setText(String.valueOf(res)+"%");
                    result.setVisibility(View.VISIBLE);
                    first=input1.getText().toString();
                    second=input2.getText().toString();
                    fn.setText(first);
                    sn.setText(second);
                    l.setVisibility(View.VISIBLE);
                    ispressed=true;
                }}
            }
        });
    }
}
