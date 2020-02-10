package com.chirag.selflearnloginpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class spining extends AppCompatActivity {
    protected ImageView i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spining);
        i=findViewById(R.id.spin);
        int initial , Final;
        initial=0;
        Final=36000;
        int  x=i.getWidth();
        int  y=i.getHeight();
        x=x/2;
        y=y/2;
        Animation rotate = new RotateAnimation(initial,Final,x,y);
rotate.setDuration(5000);
rotate.setFillAfter(true);
rotate.setAnimationListener(new Animation.AnimationListener() {
    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }
});
i.startAnimation(rotate);
    }
}
