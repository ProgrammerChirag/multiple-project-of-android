package com.chirag.instagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class name extends AppCompatActivity {
    EditText name,pass;
    Button finish;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        name=findViewById(R.id.name);
        finish=findViewById(R.id.finish);
        pass=findViewById(R.id.pass);
        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(name.this,profile_ui.class);

                if(name.getText().toString().isEmpty()){
                    name.setError("please enter name");
                    name.requestFocus();
                }
                else{
                    if(pass.getText().toString().isEmpty()){
                        pass.setError("please enter passoword");
                        pass.requestFocus();
                    }
                    else{
                        String number,email,user_name,password;
                        String username=getIntent().getStringExtra("username");
                        int key= Integer.parseInt(getIntent().getStringExtra("key"));
                        if(key==0){
                            number=getIntent().getStringExtra("number");
                            i.putExtra("number", number);

                        }
                        else{
                            email=getIntent().getStringExtra("email");
                            i.putExtra("email",email);

                        }
                        user_name=name.getText().toString();
                        password=pass.getText().toString();
                        i.putExtra("username",username);
                        i.putExtra("name",user_name);
                        i.putExtra("password",password);

                    }
                }
            }
        });
    }
}
