package com.chirag.todowithfirebase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    EditText name , pass , mail, age , mobile;
    Button submit;
    String getname , getpass, getage , getmail,getnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();


        final DatabaseReference databaseReference = database.getReference("User");
        name=findViewById(R.id.name);
        pass=findViewById(R.id.password);
        mail=findViewById(R.id.email);
        age=findViewById(R.id.age);
        mobile=findViewById(R.id.mobile);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getname=name.getText().toString();

                getmail=mail.getText().toString();

                getage=age.getText().toString();

                getnumber=mobile.getText().toString();

                getpass=pass.getText().toString();
                if(getnumber.isEmpty()||getname.isEmpty()||getmail.isEmpty()||getage.isEmpty()||getpass.isEmpty()){
                    Toast.makeText(getApplicationContext(),"please enter all details first",Toast.LENGTH_LONG).show();

                }
                else{
                    databaseReference.child(getname).child("name").setValue(getname).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"Data Sent",Toast.LENGTH_LONG).show();
                        }
                    });

                    databaseReference.child(getname).child("email").setValue(getmail);

                    databaseReference.child(getname).child("password").setValue(getpass);

                    databaseReference.child(getname).child("age").setValue(getage);

                    databaseReference.child(getname).child("number").setValue(getnumber);
                }

            }
        });

    }
}