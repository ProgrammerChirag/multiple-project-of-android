package com.chirag.selflearnloginpage;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    protected EditText user,pass;
    protected RadioButton r ;
    protected Button login,sign_up;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=findViewById(R.id.username);
        pass=findViewById(R.id.password);
        login=findViewById(R.id.login);
        sign_up=findViewById(R.id.sign_up);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(user.getText()).equals("")||String.valueOf(pass.getText()).equals("")){

                    Toast.makeText(getApplicationContext(),"please Enter uername and password",Toast.LENGTH_LONG).show();
                }
                else{
                    if(String.valueOf(user.getText()).equals("chirag123@gmail.com")&&String.valueOf(pass.getText()).equals("12345678")){
                        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                        b.setCancelable(false);
                        b.setTitle("login Access Successfull");
                        b.setMessage("Are You sure want to login");
                        b.setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Intent i = new Intent(MainActivity.this,profile.class);
                                String name = "chirag juneja";
                                String password="12345678";
                                i.putExtra("name",name);
                                i.putExtra("password",password);
                                startActivity(i);
                            }
                        });


                        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                user.setText("");
                                pass.setText("");
                                Toast.makeText(MainActivity.this,"try again!!",Toast.LENGTH_LONG).show();
                            }
                        });


                        b.show();
                    }
                    else{

                        Toast.makeText(getApplicationContext(),"please enter valid email and password",Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,create_Account.class);
                startActivity(i);
            }
        });

    }
}
