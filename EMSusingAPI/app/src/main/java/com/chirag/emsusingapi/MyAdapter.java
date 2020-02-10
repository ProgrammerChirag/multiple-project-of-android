package com.chirag.emsusingapi;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.Date;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<ApiData> list;
    Context context;
    public MyAdapter(Context context,List<ApiData> list){
    this.context=context;
    this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.textView.setText(list.get(position).getEmailID());
        Log.d("imageurl",list.get(position).getImageURL());
        Picasso.get().load(list.get(position).getImageURL()).into(holder.circleImageView);
        holder.description.setText(list.get(position).getMobile());
        holder.name.setText(list.get(position).getName());

        holder.prfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(context,profile.class);
                intent.putExtra("getname",list.get(position).getName());
                intent.putExtra("getemail",list.get(position).getEmailID());
                intent.putExtra("getbirthday",list.get(position).getBirthday());
                intent.putExtra("getid",list.get(position).getID());
                intent.putExtra("getimageurl",list.get(position).getImageURL());
                intent.putExtra("getgender",list.get(position).getGender());
                intent.putExtra("getmobile",list.get(position).getMobile());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textView,name, description;
        CircleImageView circleImageView;
        LinearLayout prfile;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView=itemView.findViewById(R.id.image_user);
            textView=itemView.findViewById(R.id.email);
            name=itemView.findViewById(R.id.user_name);
            description=itemView.findViewById(R.id.description);
            prfile=itemView.findViewById(R.id.profile);
        }
    }
}
