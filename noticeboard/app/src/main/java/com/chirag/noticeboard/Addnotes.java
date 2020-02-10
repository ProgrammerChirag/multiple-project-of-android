package com.chirag.noticeboard;

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
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Addnotes extends AppCompatActivity {
    EditText Name , Title,Desc;
    DatabaseReference databaseReference= FirebaseDatabase.getInstance().getReference("notes");
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnotes);
        Name=findViewById(R.id.name_add_notes);
        Title=findViewById(R.id.title_add_notes);
        Desc=findViewById(R.id.description_add_notes);
        submit=findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Name.getText().toString().isEmpty()||Title.getText().toString().isEmpty()||Desc.getText().toString().isEmpty()){
                    if(Name.getText().toString().isEmpty())
                        Name.setError("enter name here ");
                        if(Title.getText().toString().isEmpty())
                            Title.setError("Enter Title here");
                            if(Desc.getText().toString().isEmpty())
                                Desc.setError("Enter Description here");
                }
                else{
                    AddNOTES(Name.getText().toString(),Title.getText().toString(),Desc.getText().toString());
                }
            }
        });

    }

    private void AddNOTES(String toString, String toString1, String toString2) {
        String key=databaseReference.push().getKey();
        notes newnotes=new notes(toString,toString1,toString2,java.time.LocalTime.now().toString());
        databaseReference.child(key).setValue(newnotes).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){

                    Toast.makeText(getApplicationContext(),"data stored",Toast.LENGTH_LONG).show();
                    finish();
                    startActivity(new Intent(Addnotes.this,MainActivity.class));
                }
                else{
                    finish();
                    startActivity(new Intent(Addnotes.this,MainActivity.class));
                }
            }
        });

    }
}
