package com.chirag.bitcoin_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    EditText inr,bitcoin;
    Button btn;
    String url="https://blockchain.info/tobtc?currency=INR&value=";
    String data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue= Volley.newRequestQueue(this);
        inr=findViewById(R.id.inr);
        bitcoin=findViewById(R.id.bitcoin);
        btn=findViewById(R.id.change);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(inr.getText().toString().isEmpty()){
                    inr.setError("enter data");
                }
                else{
                    data=inr.getText().toString();
                    StringRequest stringRequest=new StringRequest(Request.Method.GET, url + data, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("responselength", String.valueOf(response));
                            getDataFromUrl(response);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Log.d("erroris",error.getMessage());
                        }
                    });
                    requestQueue.add(stringRequest);
                }
            }
        });


    }

    private void getDataFromUrl(String response) {
        if(response.isEmpty()){
            Toast.makeText(getApplicationContext(),"data loading failed",Toast.LENGTH_LONG).show();
        }
        Log.d("mydata",response);
        bitcoin.setText(response);
    }
}
