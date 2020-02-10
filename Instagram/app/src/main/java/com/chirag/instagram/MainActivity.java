package com.chirag.instagram;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    LoginButton loginButton;
    Button signup1,Signup2;
    CallbackManager callbackManager;
    EditText email , pass;
    Button login;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signup1=findViewById(R.id.signup1);
        Signup2=findViewById(R.id.signup2);

        callbackManager = CallbackManager.Factory.create();
        firebaseDatabase = FirebaseDatabase.getInstance();
        final DatabaseReference dataref=firebaseDatabase.getReference("user_loign_module");
        email=findViewById(R.id.email);
        pass=findViewById(R.id.pass);
        login=findViewById(R.id.login);
        signup1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(MainActivity.this,signup.class));
            }
        });

        Signup2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(MainActivity.this,signup.class));
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String getemail;
                String getpass;
                getemail=email.getText().toString();
                getpass=pass.getText().toString();
                if(getemail.isEmpty()){
                    email.setError("please Enter email");
                    email.requestFocus();
                    if(getpass.isEmpty()){
                        pass.setError("please enter password");
                    }
                }
                else{
                   dataref.child(getemail).child("email").setValue(getemail).addOnSuccessListener(new OnSuccessListener<Void>() {
                       @Override
                       public void onSuccess(Void aVoid) {
                           Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
                           finish();
                           startActivity(new Intent(MainActivity.this,signup.class));
                       }
                   });
                   dataref.child(getemail).child("pass").setValue(getpass);
                }
            }
        });


    }
}
