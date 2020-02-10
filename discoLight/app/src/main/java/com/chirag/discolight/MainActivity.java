package com.chirag.discolight;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    ImageView i;
    Button b ,b1;
    boolean istrue=true;
    SeekBar s ;
    boolean ison=false;
    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        i=findViewById(R.id.icon);
        i.setVisibility(View.INVISIBLE);


        b=findViewById(R.id.exit);
        b1=findViewById(R.id.off);
        b1.setVisibility(View.INVISIBLE);


        s = findViewById(R.id.seek);
        s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            CameraManager params = (CameraManager) getSystemService(CAMERA_SERVICE);

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                b.setVisibility(View.INVISIBLE);
                b1.setVisibility(View.INVISIBLE);
                int p = s.getProgress();

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                i=findViewById(R.id.icon);
                long blinkDelay = s.getProgress(); //Delay in ms
                int i=0;
                while (i<40) {
                    if (ison) {
                        try {
                            off();
                            String cid = params.getCameraIdList()[0];
                            params.setTorchMode(cid, true);
                        } catch (Exception e) {
                        }
                        ison = false;
                    } else {
                        try {
                            off();
                            String cid = params.getCameraIdList()[0];
                            params.setTorchMode(cid, false);
                            ison = true;
                        } catch (Exception e) {
                        }
                    }
                    try {
                        Thread.sleep(blinkDelay);
                        on();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;

                }b.setVisibility(View.VISIBLE);
                b1.setVisibility(View.VISIBLE);

            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraManager  c=(CameraManager)getSystemService(CAMERA_SERVICE);
                try{
                    String  str = c.getCameraIdList()[0];
                    c.setTorchMode(str,false);
                }catch (Exception e){


                }
                finish();
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CameraManager c=(CameraManager)getSystemService(CAMERA_SERVICE);
                try {
                    String cid = c.getCameraIdList()[0];
                    c.setTorchMode(cid, false);

                } catch (Exception e) {
                }
            }
        });
    }
    void on(){
        i=findViewById(R.id.icon);
        i.setVisibility(View.VISIBLE);
    }
    void off(){
        i=findViewById(R.id.icon);
        i.setVisibility(View.INVISIBLE);
    }
}
