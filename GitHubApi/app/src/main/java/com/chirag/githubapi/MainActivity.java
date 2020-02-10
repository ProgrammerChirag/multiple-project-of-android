package com.chirag.githubapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    RecyclerView recyclerView;
    profile_Adapter profile_adapter;
    String url="https://api.github.com/users";
    RequestQueue requestQueue;
    List<DataGet> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recycle);

        requestQueue= Volley.newRequestQueue(this);

        list=new ArrayList<>();

        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setHasFixedSize(true);

        loaddatafromurl();
    }

    private void loaddatafromurl() {
        JsonArrayRequest arrayRequest=new JsonArrayRequest(url,

                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("response_data", String.valueOf(response));
                        setdatainviewlist(response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(arrayRequest);

    }

    private void setdatainviewlist(JSONArray response) {
        JSONObject jsonObject=null;
        for(int i=0;i<response.length();i++){
            DataGet dataGet=new DataGet();
            try {
                jsonObject=response.getJSONObject(i);
                dataGet.setId(jsonObject.getString("id"));
                dataGet.setAvatar_url(jsonObject.getString("avatar_url"));
                dataGet.setLogin(jsonObject.getString("login"));
                Log.d("iddata",jsonObject.getString("id"));
                dataGet.setType(jsonObject.getString("type"));
                list.add(dataGet);
            }catch (JSONException e){
                e.getMessage();
            }
            profile_adapter=new profile_Adapter(list,this);
            recyclerView.setAdapter(profile_adapter);
            profile_adapter.notifyDataSetChanged();
        }
    }
}
