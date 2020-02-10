package com.chirag.whatsapp_clone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.StatFs;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    TextView chats,status,calls;
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    String mydata[]={"chirag","harsh","anil","tanisha","anshul","archit","devesh","jahanvi","chanchal","chirag","harsh","anil","tanisha","anshul","archit","devesh","jahanvi","chanchal"};
    View v1,v2,v3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chats=findViewById(R.id.chats);
        calls=findViewById(R.id.calls);
        status=findViewById(R.id.status);
        adapter=new MyAdaptor(mydata);
        recyclerView=findViewById(R.id.recycle);
        layoutManager= new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        v1=findViewById(R.id.v1);
        v2=findViewById(R.id.v2);
        v3=findViewById(R.id.v3);
        chats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chats.setTypeface(null, Typeface.BOLD);

                calls.setTypeface(null, Typeface.NORMAL);

                status.setTypeface(null, Typeface.NORMAL);
                chats.setTextColor(Color.parseColor("#ffffff"));
                calls.setTextColor(Color.parseColor("#E0DDDD"));
                status.setTextColor(Color.parseColor("#E0DDDD"));
                v1.setVisibility(View.VISIBLE);
                v2.setVisibility(View.INVISIBLE);
                v3.setVisibility(View.INVISIBLE);
            }
        });
        calls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                calls.setTypeface(null, Typeface.BOLD);

                chats.setTypeface(null, Typeface.NORMAL);

                status.setTypeface(null, Typeface.NORMAL);
                calls.setTextColor(Color.parseColor("#ffffff"));
                chats.setTextColor(Color.parseColor("#E0DDDD"));
                status.setTextColor(Color.parseColor("#E0DDDD"));
                v3.setVisibility(View.VISIBLE);
                v2.setVisibility(View.INVISIBLE);
                v1.setVisibility(View.INVISIBLE);
            }
        });
        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                status.setTypeface(null, Typeface.BOLD);

                calls.setTypeface(null, Typeface.NORMAL);

                chats.setTypeface(null, Typeface.NORMAL);
                status.setTextColor(Color.parseColor("#ffffff"));
                calls.setTextColor(Color.parseColor("#E0DDDD"));
                chats.setTextColor(Color.parseColor("#E0DDDD"));
                v2.setVisibility(View.VISIBLE);
                v3.setVisibility(View.INVISIBLE);
                v1.setVisibility(View.INVISIBLE);
            }
        });

    }
}
