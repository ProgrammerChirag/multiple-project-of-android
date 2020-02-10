package com.chirag.loginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {

    EditText number,city,password,name;
    Button reg;
    int attempt=0;
    boolean complete = false;
    char c=' ';
    int no_digit=0,no_capital=0;
    boolean ld=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        name=findViewById(R.id.name);
        number=findViewById(R.id.number);
        city=findViewById(R.id.city);
        password=findViewById(R.id.password);
        reg=findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no_capital=0;
                no_digit=0;
                complete=false;
                ld=false;
            if(attempt>=5) Toast.makeText(MainActivity.this,"you are restricted for 24 hours",Toast.LENGTH_LONG).show();
            else{
                String getname = name.getText().toString();
                String getnumber = number.getText().toString();
                String getcity = city.getText().toString();
                String getpassword = password.getText().toString();
                if(getname.isEmpty()) Toast.makeText(MainActivity.this,"first enter the name dont leave it blank",Toast.LENGTH_LONG).show();
                else{
                    if(getpassword.isEmpty()) Toast.makeText(MainActivity.this,"please enter password dont leave it black",Toast.LENGTH_LONG).show();
                    else {
                        if (getnumber.isEmpty())
                            Toast.makeText(MainActivity.this, "please enter your number dont leave it blank", Toast.LENGTH_LONG).show();
                        else {
                            if (getcity.isEmpty())
                                Toast.makeText(MainActivity.this, "please enter your city name dont leave it blank", Toast.LENGTH_LONG).show();
                            else{
                                char[] arr=getnumber.toCharArray();
                                if(arr.length>10||arr.length<10) Toast.makeText(MainActivity.this,"you have entered wrong phone number",Toast.LENGTH_LONG).show();
                                else {
                                    char[] pass = getpassword.toCharArray();
                                    if(pass.length<10) Toast.makeText(MainActivity.this,"password should be atleast 10 characters",Toast.LENGTH_LONG).show();
                                    else {
                                        for (int i = 0; i < pass.length; i++) {
                                            if ((pass[i] > 64 && pass[i] < 91) || (pass[i] > 96 && pass[i] < 123) || (pass[i] > 47 && pass[i] < 58)) {
                                                c=pass[i];
                                                continue;
                                            } else {
                                                Toast.makeText(MainActivity.this, "use only letters and digits", Toast.LENGTH_LONG).show();
                                                ld = true;
                                                break;
                                            }
                                        }
                                        if (ld == false) {
                                            for (int i = 0; i < pass.length; i++) {
                                                if (no_digit > 1) break;
                                                if (pass[i] < 58 && pass[i] > 47) {
                                                    no_digit++;
                                                }
                                            }
                                            if (no_digit < 2)
                                                Toast.makeText(MainActivity.this, "password should have two digit at least", Toast.LENGTH_LONG).show();
                                            else {
                                                for (int i = 0; i < pass.length; i++) {
                                                    if (pass[i] < 91 && pass[i] > 64) {
                                                        no_capital++;
                                                        break;
                                                    }
                                                }
                                                if (no_capital > 0) {
                                                    Toast.makeText(MainActivity.this, "Account Successfully created!!", Toast.LENGTH_LONG).show();
                                                    complete=true;
                                                    name.setText("");
                                                    password.setText("");
                                                    city.setText("");
                                                    number.setText("");
                                                }
                                                    else
                                                    Toast.makeText(MainActivity.this, "At least one letter should be capital", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                 if(complete) attempt=attempt+1;
            }
            }
        });
    }
}
