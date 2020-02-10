package com.chirag.todowithfirebase;

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

public class profile extends AppCompatActivity {
    DatabaseReference databaseReference;
EditText title , desc;
Button update, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        title=findViewById(R.id.title_update);
        desc=findViewById(R.id.description_update);

        databaseReference= FirebaseDatabase.getInstance().getReference("user");

        update=findViewById(R.id.update_user);
        delete=findViewById(R.id.delete_user);
        final String title_user=getIntent().getStringExtra("title");
        final String desc_user=getIntent().getStringExtra("desc");
        final String id = getIntent().getStringExtra("id");
        title.setText(title_user);
        desc.setText(desc_user);






        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final notes notes=new notes(id,title.getText().toString(),desc.getText().toString());
                databaseReference.child(id).setValue(notes).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"data stored",Toast.LENGTH_LONG).show();
                            finish();
                            startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
delete.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        databaseReference.child(id).removeValue().addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                   Toast.makeText(getApplicationContext(),"data deleted",Toast.LENGTH_LONG).show();
                   finish();
                   startActivity(new Intent(getApplicationContext(),MainActivity.class));
                }
            }
        });
    }
});


    }
}
