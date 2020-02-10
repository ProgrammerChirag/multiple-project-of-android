package com.chirag.flashlight;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageButton i;
    boolean ison=false;
    MediaPlayer m;

    @RequiresApi(api=Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=findViewById(R.id.button);
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                m=MediaPlayer.create(getApplicationContext(),R.raw.chirag);
                m.start();
                if(ison){
                    i.setImageResource(R.drawable.torch);
                    offlight();
                    ison=false;
                }
                else
                {

                    i.setImageResource(R.drawable.tf);
                    onlight();
                    ison=true;
                }
                Handler handler=new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        m.stop();
                    }
                },  100);
            }
        });



    }
    @RequiresApi(api = Build.VERSION_CODES.M)
    protected void onlight(){
        CameraManager c= (CameraManager) getSystemService(CAMERA_SERVICE);
        try{
            String  cid =c.getCameraIdList()[0];
            c.setTorchMode(cid,true);

        }catch(Exception e){}
    }
    protected void offlight(){
        CameraManager c= (CameraManager) getSystemService(CAMERA_SERVICE);
        try{
            String  cid =c.getCameraIdList()[0];
            c.setTorchMode(cid,false);

        }catch(Exception e){}

    }
}
