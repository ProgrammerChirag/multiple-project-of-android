package com.chirag.project_authentication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText mail , password;
    Button login, signup , forgot;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onStart() {
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mail=findViewById(R.id.email);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        forgot=findViewById(R.id.forgot);

        firebaseAuth=FirebaseAuth.getInstance();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                firebaseAuth.signInWithEmailAndPassword(mail.getText().toString(),password.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){

                            FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
                            profile(firebaseUser);
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"login failed",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });


    }

    private void profile(FirebaseUser firebaseUser) {
        Toast.makeText(getApplicationContext(),"user logged in",Toast.LENGTH_LONG).show();
    }
}
