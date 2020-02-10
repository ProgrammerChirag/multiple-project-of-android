package com.chirag.newsapiapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {
    List<Article> list;
    Context context;

    public NewsAdapter(List<Article> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(context);
        View view= inflater.inflate(R.layout.newsitems,parent,false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final NewsViewHolder holder, final int position) {
        holder.news_title.setText(list.get(position).getTitle());
        String date_news=list.get(position).getPublishedAt();
        SimpleDateFormat spf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date newDate = null;
        try {
            newDate = spf.parse(date_news);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        spf = new SimpleDateFormat("dd MMM yyyy");
        final String newDateString = spf.format(newDate);
        holder.date.setText(newDateString);
        Picasso.get().load(list.get(position).getUrlToImage()).into(holder.news_image_data);

        holder.news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,newspage.class);
                intent.putExtra("author",list.get(position).getAuthor());
                intent.putExtra("title",list.get(position).getTitle());
                intent.putExtra("desc",list.get(position).getDescription());
                intent.putExtra("image",list.get(position).getUrlToImage());
                intent.putExtra("content",list.get(position).getContent());
                intent.putExtra("date",newDateString);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NewsViewHolder extends RecyclerView.ViewHolder {
        TextView news_title;
        TextView date;
        ImageView news_image_data;
        LinearLayout news;
        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            news_title=itemView.findViewById(R.id.title_news);
            news_image_data=itemView.findViewById(R.id.image_news);
            date=itemView.findViewById(R.id.date_news);
            news=itemView.findViewById(R.id.news);
        }
    }
}
