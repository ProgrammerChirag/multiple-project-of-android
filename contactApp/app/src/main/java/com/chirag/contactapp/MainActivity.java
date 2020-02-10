package com.chirag.contactapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DatabaseReference databaseReference;
    List<contact_class> list=new ArrayList<>();
    Context context;

    ImageView ii;
    RecyclerView recyclerView;
    String name[]={"chirag","chirag1","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2","chirag2"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ii=findViewById(R.id.addcontact);

        final  myadapter myad=new myadapter(list,this);
        databaseReference= FirebaseDatabase.getInstance().getReference("user");

        recyclerView=findViewById(R.id.scrollerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(myad);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1:dataSnapshot.getChildren()){
                    Log.d("datacount", String.valueOf(dataSnapshot1));
                    contact_class obj=dataSnapshot1.getValue(contact_class.class);
                    list.add(obj);
                }
                myad.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"sorry no data found",Toast.LENGTH_LONG).show();
            }
        });
        ii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,addcontact.class));
            }
        });
    }
}
