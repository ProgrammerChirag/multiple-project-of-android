package com.chirag.weatherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    TextView result,max,humadity_data;
    String data;
    RequestQueue requestQueue;
    String url1="https://api.openweathermap.org/data/2.5/weather?q=";
    String appid="&appid=080efe4573d2d3277fcae4101c07c4d8";
    EditText city;
    Button c,f;
    double temp_min,temp_max,humadity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        city=findViewById(R.id.city);
        c=findViewById(R.id.celcius);
        f=findViewById(R.id.farnehight);
        result=findViewById(R.id.result);

        max=findViewById(R.id.MAX_TEMP);
        humadity_data=findViewById(R.id.HUMADITY);

        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettemp(city.getText().toString(),"°C");


            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gettemp(city.getText().toString(),"°F");


            }
        });
    }

    private void gettemp(String city,String format) {
        if (format.equals("°C")) {
            JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url1 + city + appid, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONObject jsonObject = response.getJSONObject("main");
                        Log.d("jsondata", jsonObject.getString("temp_min"));
                        temp_min = jsonObject.getDouble("temp_min");
                        temp_max = jsonObject.getDouble("temp_max");
                        humadity = jsonObject.getDouble("humidity");


                        temp_min =temp_min-273.15;
                        Log.d("temp",String.valueOf(temp_min));
                        data=String.valueOf(temp_min);
                        String str=data.substring(0,4);
                        result.setText(str+" °C");




                        temp_max =temp_max-273.15;
                        Log.d("temp",String.valueOf(temp_max));
                        data=String.valueOf(temp_max);
                        str=data.substring(0,4);
                        max.setText(str+" °C");





                        humadity_data.setText(humadity+" %");

                    } catch (JSONException e) {
                        e.getMessage();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(objectRequest);

        } else {
            JsonObjectRequest objectRequest = new JsonObjectRequest(Request.Method.GET, url1 + city + appid, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        JSONObject jsonObject = response.getJSONObject("main");
                        Log.d("jsondata", jsonObject.getString("temp_min"));
                        temp_min = jsonObject.getDouble("temp_min");
                        temp_max = jsonObject.getDouble("temp_max");
                        humadity = jsonObject.getDouble("humidity");


                        temp_min=temp_min-273.15;
                        temp_min=(temp_min*9/5)+32;
                        Log.d("temp",String.valueOf(temp_min));
                        data=String.valueOf(temp_min);
                        String str=data.substring(0,4);
                        result.setText(str+" °F");


                        temp_max =temp_max-273.15;
                        temp_max=(temp_max*9/5)+32;
                        Log.d("temp",String.valueOf(temp_max));
                        data=String.valueOf(temp_max);
                        str=data.substring(0,4);
                        max.setText(str+" °F");

                        humadity_data.setText(humadity+" %");
                    } catch (JSONException e) {
                        e.getMessage();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                }
            });
            RequestQueue requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(objectRequest);

        }
    }
}
