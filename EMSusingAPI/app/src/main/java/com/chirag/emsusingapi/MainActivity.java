package com.chirag.emsusingapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    String url="https://userapi.tk/";
    RequestQueue requestQueue;
    List<ApiData> list;
    MyAdapter myAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        requestQueue= Volley.newRequestQueue(this);


        recyclerView=findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        list=new ArrayList<>();;
        loaddatafromurl();



    }

    private void loaddatafromurl() {
        JsonArrayRequest arrayRequest=new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("response_data", String.valueOf(response));
                        setdatainrecycleview(response);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"something went wrong",Toast.LENGTH_LONG).show();
            }
        });
        requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(arrayRequest);
    }

    private void setdatainrecycleview(JSONArray response) {
        JSONObject jsonObject=null;
        for(int i=0;i<response.length();i++){
            ApiData apiData=new ApiData();
            try {
                jsonObject=response.getJSONObject(i);
                apiData.setName(jsonObject.getString("Name"));
                apiData.setEmailID(jsonObject.getString("EmailID"));
                apiData.setImageURL(jsonObject.getString("ImageURL"));
                apiData.setMobile(jsonObject.getString("Mobile"));
                apiData.setBirthday(jsonObject.getString("Birthday"));
                apiData.setID(jsonObject.getString("ID"));
                apiData.setGender(jsonObject.getString("Gender"));
                Log.d("user_name",apiData.getName());
                list.add(apiData);
            }catch (JSONException e){
                e.getMessage();
            }
           Log.d("response size", String.valueOf(response.length()));
        }
        myAdapter=new MyAdapter(this,list);
        recyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
    }
}
