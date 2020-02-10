package com.chirag.fb_login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.firebase.auth.FirebaseAuth;

import de.hdodenhof.circleimageview.CircleImageView;


public class profile_page extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    String image_url;
    CircleImageView circleImageView;
    Intent intent;
    EditText t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        firebaseAuth=FirebaseAuth.getInstance();
        image_url=getIntent().getStringExtra("url");
        t=findViewById(R.id.data);
        intent=new Intent();
        circleImageView=findViewById(R.id.image);
        Bitmap bitmap =  intent.getParcelableExtra("BitmapImage");
        circleImageView.setImageBitmap(bitmap);


    }
}
