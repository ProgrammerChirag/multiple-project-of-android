package com.chirag.todowithfirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class add_Notes extends AppCompatActivity {
    protected Button submit;
    protected EditText title,description;
    String title_data,description_data;
    private  FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__notes);
        title=findViewById(R.id.title);
        description=findViewById(R.id.description);
        firebaseDatabase=FirebaseDatabase.getInstance();
        databaseReference=firebaseDatabase.getReference("user");

    }
    public void addnotes(View view){

        if(title.getText().toString().isEmpty()){
            title.setError("enter title here");
            title.requestFocus();
        }
        else{
            title_data=title.getText().toString();
            description_data=description.getText().toString();
            AddNotesInDataBase(title_data,description_data);
        }
    }
    private void AddNotesInDataBase(String title_data, final  String description_data) {


        final String  user_id = databaseReference.push().getKey();
        //now we will use pojo class
        notes notes=new notes(user_id,title_data,description_data);
        databaseReference.child(user_id).setValue(notes).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
           if(task.isSuccessful()){

               Toast.makeText(getApplicationContext(),"data stored",Toast.LENGTH_LONG).show();
               finish();
               startActivity(new Intent(add_Notes.this,MainActivity.class));
           }
           else{
               Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_LONG).show();
           }
            }
        });

    }
}
