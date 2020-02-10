package com.chirag.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        String course[]={"java","flutter","html","android","react native","python","machine learning","php","javascript","java","flutter","html","android","react native","python","machine learning","php","javascript"};
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(new CourseAdapter(course));
    }
}
