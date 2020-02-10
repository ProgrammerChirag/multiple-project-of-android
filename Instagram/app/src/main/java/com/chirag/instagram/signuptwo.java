package com.chirag.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class signuptwo extends AppCompatActivity {
    EditText phone , email;
    TextView number , address;
    Button next;
    LinearLayout l;
    View v1,v2;
    boolean one=true,two=false;
    int key=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signuptwo);
        phone=findViewById(R.id.phone);
        email=findViewById(R.id.email);
        number=findViewById(R.id.num);
        address=findViewById(R.id.mail_address);
        v1=findViewById(R.id.v1);
        v2=findViewById(R.id.v2);
        next=findViewById(R.id.next);
        l=findViewById(R.id.phone_number);
        number.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                one=true;
                two=false;
                int v1_h=v1.getHeight();
                int v2_h=v2.getHeight();
                l.setVisibility(View.VISIBLE);
                email.setVisibility(View.INVISIBLE);
                number.setTextColor(Color.parseColor("#ffffff"));
                address.setTextColor(Color.parseColor("#99AAAB"));
                v1.setLayoutParams(new LinearLayout.LayoutParams(v1.getWidth(),v2_h));
                v2.setLayoutParams(new LinearLayout.LayoutParams(v2.getWidth(),v1_h));

            }
        });
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                two=true;
                one=false;

                l.setVisibility(View.INVISIBLE);
                email.setVisibility(View.VISIBLE);
                int v1_h=v1.getHeight();
                int v2_h=v2.getHeight();

                address.setTextColor(Color.parseColor("#ffffff"));
                number.setTextColor(Color.parseColor("#99AAAB"));
                v1.setLayoutParams(new LinearLayout.LayoutParams(v1.getWidth(),v2_h));
                v2.setLayoutParams(new LinearLayout.LayoutParams(v2.getWidth(),v1_h));

            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = getIntent().getStringExtra("username");
                if(one==true){
                    if(phone.getText().toString().isEmpty()){
                        phone.setError("please enter number");
                        phone.requestFocus();
                    }
                    else{
                        Intent i = new Intent(signuptwo.this,name.class);
                        i.putExtra("number",phone.getText().toString());
                        i.putExtra("username",username);
                        key=0;
                        i.putExtra("key",key);
                    }
                }
                if(two==true){
                    if(email.getText().toString().isEmpty()){
                        email.setError("please enter email");
                        email.requestFocus();
                    }
                    else{
                        key=1;
                        Intent i = new Intent(signuptwo.this,name.class);
                        i.putExtra("email",email.getText().toString());
                        i.putExtra("username",username);
                        i.putExtra("key",key);
                    }
                }

            }
        });

    }
}
