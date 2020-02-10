package com.chirag.contact;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
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
    RecyclerView recyclerView;
    Myadapter myadapter;
    List<DataGet> list = new ArrayList<>();
     String url="http://userapi.tk/";
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycle);
        myadapter=new Myadapter(list,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setHasFixedSize(true);
        requestQueue= Volley.newRequestQueue(this);

        loaddata();


    }

    private void loaddata() {
        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                Log.d("length", String.valueOf(response));
                loadobject(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void loadobject(JSONArray response) {
        for(int i=0;i<response.length();i++){
            try {
                DataGet dataGet=new DataGet();
                JSONObject jsonObject=response.getJSONObject(i);
                Log.d("another", String.valueOf(jsonObject.length()));
                dataGet.setName(jsonObject.getString("Name"));
                Log.d("name",jsonObject.getString("Name"));
                dataGet.setMobile(jsonObject.getString("Mobile"));
                dataGet.setImageURL(jsonObject.getString("ImageURL"));
                list.add(dataGet);

            } catch (JSONException e) {
                e.printStackTrace();
            }
            Myadapter myadapter=new Myadapter(list,this);

            recyclerView.setAdapter(myadapter);


            myadapter.notifyDataSetChanged();
        }
    }
}
