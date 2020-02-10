package com.chirag.weatherui;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
     CardView call,message , email,whatsapp,gallery,music,video,cal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        message=findViewById(R.id.message);
        email=findViewById(R.id.email);
        whatsapp=findViewById(R.id.whatsapp);
        call=findViewById(R.id.call);
        gallery=findViewById(R.id.galary);
        music=findViewById(R.id.music);
        video=findViewById(R.id.todo);
        cal=findViewById(R.id.calender);
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent callintent=new Intent(Intent.ACTION_DIAL);
                callintent.setData(Uri.parse("tel:9982917736"));
                startActivity(callintent);
            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent messageintent =  new Intent(Intent.ACTION_VIEW);
                messageintent.setData(Uri.parse("sms:9982917736"));
                startActivity(messageintent);
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto","junejachirag020@gmail.com", null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "progress done");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "this is : ");
                startActivity(Intent.createChooser(emailIntent, "Send email"));
            }
        });
        whatsapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT,"hello sir i have completed the whatsapp task");
                i.setPackage("com.whatsapp");
                startActivity(i);

            }
        });
        gallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_OPEN_DOCUMENT);
                intent.setType("image/*");
                startActivity(intent);
            }
        });
        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setAction(Intent.ACTION_VIEW);
                i.setType("audio/*");
                startActivity(i);
            }
        });
        video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent markerIntent=new Intent(Intent.ACTION_VIEW);
                markerIntent.setData(Uri.parse("market://details?id=com.google.android.apps.docs.editors.docs"));
                startActivity(markerIntent);

            }
        });
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_EDIT);
                intent.setType("vnd.android.cursor.item/event");
                startActivity(intent);
            }
        });
    }
}
