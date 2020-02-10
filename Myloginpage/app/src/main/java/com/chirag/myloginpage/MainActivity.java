 package com.chirag.myloginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

 public class MainActivity extends AppCompatActivity {
    public Button login,forgot,signup;
    public EditText user , pass;
    public CheckBox c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.login);
        forgot=findViewById(R.id.forgot);
        signup=findViewById(R.id.signup);
        user=findViewById(R.id.username);
        pass=findViewById(R.id.pass);
        c=findViewById(R.id.check);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getText().toString().equals("")||pass.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"please enter id and password first",Toast.LENGTH_LONG).show();
                }
                else{
                    if(user.getText().toString().equals("chirag123@gmail.com")&&pass.getText().toString().equals("12345")){
                        open(v);
                    }
                    else{
                        Toast.makeText(MainActivity.this,"wrong username or password",Toast.LENGTH_LONG).show();
                        user.setText("");
                        pass.setText("");
                    }
                }
            }
        });
    }
    public void open(View v){

        Intent i = new Intent(v.getContext(),secondActivity.class);
        startActivity(i);
    }
}
