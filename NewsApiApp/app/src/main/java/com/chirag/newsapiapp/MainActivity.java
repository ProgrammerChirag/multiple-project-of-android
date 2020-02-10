package com.chirag.newsapiapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;

    RequestQueue requestQueue;


    String url="https://newsapi.org/v2/everything?q=bitcoin&from=2020-01-06&sortBy=publishedAt&apiKey=bd30a69980e9442c8b0c3dec9549dc4e";
    NewsAdapter newsAdapter;
    List<Article> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        list=new ArrayList<>();

        requestQueue= Volley.newRequestQueue(this);

        loaddatafromurl();



    }

    private void loaddatafromurl() {
        JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                getarticlefromresponse(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(jsonObjectRequest);
    }

    private void getarticlefromresponse(JSONObject response) {

        try {
            JSONArray jsonArray=response.getJSONArray("articles");
            for(int i=1;i<=jsonArray.length();i++) {
                Article article= new Article();
                JSONObject newjsonobject = jsonArray.getJSONObject(i);
                Log.d("data",newjsonobject.getString("title"));
                article.setAuthor(newjsonobject.getString("author"));
                article.setTitle(newjsonobject.getString("title"));
                article.setPublishedAt(newjsonobject.getString("publishedAt"));
                article.setUrlToImage(newjsonobject.getString("urlToImage"));
                article.setDescription(newjsonobject.getString("description"));
                article.setContent(newjsonobject.getString("content"));


                list.add(article);

                
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        newsAdapter=new NewsAdapter(list,this);
        recyclerView.setAdapter(newsAdapter);
        newsAdapter.notifyDataSetChanged();
    }
}
