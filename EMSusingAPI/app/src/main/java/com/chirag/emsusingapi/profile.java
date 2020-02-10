package com.chirag.emsusingapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class profile extends AppCompatActivity {
    ImageButton imageButton;
    String getname , getdob , getgender , getemail, getid , getimageurl,getmobile;
    CircleImageView circleImageView;
    TextView name , id, dob , gender,email,mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        imageButton=findViewById(R.id.back);
        name=findViewById(R.id.name_user);
        id=findViewById(R.id.id);
        dob=findViewById(R.id.dob);
        gender=findViewById(R.id.gender);
        email=findViewById(R.id.email_user);
        mobile=findViewById(R.id.mobile);
        circleImageView=findViewById(R.id.profile_image);
        getdob=getIntent().getStringExtra("getbirthday");
        getemail=getIntent().getStringExtra("getemail");
        getgender=getIntent().getStringExtra("getgender");
        getid=getIntent().getStringExtra("getid");
        getname=getIntent().getStringExtra("getname");
        getmobile=getIntent().getStringExtra("getmobile");
        getimageurl=getIntent().getStringExtra("getimageurl");
        name.setText(getname);
        dob.setText(getdob);
        mobile.setText(getmobile);
        email.setText(getemail);
        gender.setText(getgender);
        id.setText(getid);
        Picasso.get().load(getimageurl).into(circleImageView);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
}
