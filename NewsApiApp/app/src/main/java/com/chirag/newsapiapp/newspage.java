package com.chirag.newsapiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class newspage extends AppCompatActivity {
    String date , author , titile , description, content,imageurl;
    ImageView imageView;
    TextView news_name,news_desc,news_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newspage);


        imageView=findViewById(R.id.image_data);
        news_name=findViewById(R.id.news_name);
        news_desc=findViewById(R.id.news_desc);
        news_content=findViewById(R.id.news_content);


        date=getIntent().getStringExtra("date");
        author=getIntent().getStringExtra("author");
        titile=getIntent().getStringExtra("title");
        description=getIntent().getStringExtra("desc");
        content=getIntent().getStringExtra("content");
        imageurl=getIntent().getStringExtra("image");

        Picasso.get().load(imageurl).into(imageView);
        news_name.setText(titile);
        news_desc.setText(description);
        news_content.setText(content);


    }
}
