package com.chirag.selflearnloginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class create_Account extends AppCompatActivity {
    protected Button btn;
    public EditText name1,name2,dob,username,email,number,password,c_name,about;
    RadioButton r1,r2;
    String name,DOB,user,mail,num,pass,country,About;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create__account);
        btn=findViewById(R.id.submit);

        //radio button
        r1=findViewById(R.id.radio1);
        r2=findViewById(R.id.radio2);


        //edit text
        name1=findViewById(R.id.name);
        name2=findViewById(R.id.name2);
        dob=findViewById(R.id.dob);
        username=findViewById(R.id.username);
        email=findViewById(R.id.mail);
        number=findViewById(R.id.number);
        password=findViewById(R.id.pass);
        c_name=findViewById(R.id.country);
        about=findViewById(R.id.bio);



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name1.getText().toString().equals("")||dob.getText().toString().equals("")||username.getText().toString().equals("")||email.getText().toString().equals("")||number.getText().toString().equals("")||password.getText().toString().equals("")||c_name.getText().toString().equals("")){

                    Toast.makeText(getApplicationContext(),"please enter all the details first",Toast.LENGTH_LONG).show();
                }
                else{
                    name=name1.getText().toString()+" " +name2.getText().toString();
                    DOB=dob.getText().toString();
                    Intent i = new Intent(getApplicationContext(),profile.class);
                    i.putExtra("bio",about.getText().toString());
                    i.putExtra("user_name",name);
                    startActivity(i);
                }
            }
        });
    }
}
