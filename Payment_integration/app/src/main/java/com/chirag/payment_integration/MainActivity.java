package com.chirag.payment_integration;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements PaymentResultListener {
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Checkout.preload(getApplicationContext());

        button=findViewById(R.id.buy);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paynow();
            }
        });
    }

    private void paynow()
    {
        Checkout checkout= new Checkout();
        checkout.setImage(R.drawable.rzp_logo);

        final Activity activity = this;

        try {
            JSONObject options = new JSONObject();

            options.put("name", "Android Course");
            options.put("description", "Android Bootcamp");
            //You can omit the image option to fetch the image from dashboard
            options.put("image", "https://raushanjha.in/wp-content/uploads/2019/12/Untitled-1.png");
            options.put("currency", "INR");
            options.put("amount", "12000");

            JSONObject preFill = new JSONObject();
            preFill.put("email", "chirag@123gmail.com");
            preFill.put("contact", "9982917736");

            options.put("prefill", preFill);
            checkout.open(activity, options);
        } catch(Exception e) {
            Log.d("errorpayment",e.getMessage());
        }
    }


    @Override
    public void onPaymentSuccess(String s) {

        Toast.makeText(getApplicationContext(),"payment success",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPaymentError(int i, String s) {

        Toast.makeText(getApplicationContext(),"payment gone wrong somthing went wrong try again!! or wait for some time we are working on it"+s,Toast.LENGTH_SHORT).show();

    }
}
