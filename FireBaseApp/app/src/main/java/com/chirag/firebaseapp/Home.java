package com.chirag.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home extends AppCompatActivity {
    FirebaseAuth f;
    FirebaseUser user;
    TextView t;
    Button log_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        t=findViewById(R.id.textid);
        f=FirebaseAuth.getInstance();
        log_out=findViewById(R.id.log_out);
        user=f.getCurrentUser();
        try {
            String email = user.getEmail();
            t.setText(email);
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"exception",Toast.LENGTH_LONG).show();

        }

        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                LoginManager.getInstance().logOut();}catch (FacebookException e){

                    Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_LONG).show();
                }
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        });


    }
}
