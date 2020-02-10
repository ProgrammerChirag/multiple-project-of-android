package com.chirag.tiktaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class start_Screen extends AppCompatActivity {
    protected EditText name1 , name2;
    protected Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start__screen);
        name1=findViewById(R.id.name1);
        name2=findViewById(R.id.name2);
        btn=findViewById(R.id.play);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name1.getText().toString().isEmpty()||name2.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(),"Please enter name first",Toast.LENGTH_LONG).show();
                }
                else{

                    String n1 , n2;
                    n1=name1.getText().toString();
                    n2=name2.getText().toString();
                    Intent i = new Intent(getApplicationContext(),MainActivity.class);
                    i.putExtra("name1",n1);
                    i.putExtra("name2",n2);
                    finish();
                    startActivity(i);
                }
            }
        });
    }
}
