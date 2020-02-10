package com.chirag.githubapi;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

import de.hdodenhof.circleimageview.CircleImageView;

public class profile_Adapter extends RecyclerView.Adapter<profile_Adapter.profileViewHolder> {
    List<DataGet> list;
    Context context;

    public profile_Adapter(List<DataGet> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public profileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater= LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item,parent,false);
        return new profileViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull profileViewHolder holder, final int position) {
        final int c=Color.argb(255,255,255,255);
        Picasso.get().load(list.get(position).getAvatar_url()).into(holder.circleImageView);
        holder.name.setText(list.get(position).getLogin());
        Picasso.get().load("https://source.unsplash.com/user/erondu/3200x900").into(holder.coverpic);
        holder.desc.setText(list.get(position).getType());
        holder.imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context,profile.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class profileViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout linearLayout;
        CircleImageView circleImageView;
        TextView name,desc;
        Button imageButton;
        RelativeLayout relativeLayout;
        ImageView coverpic;

        public profileViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayout=itemView.findViewById(R.id.data);
            circleImageView=itemView.findViewById(R.id.image_profile);
            name=itemView.findViewById(R.id.name_profile);
            relativeLayout=itemView.findViewById(R.id.cover);
            coverpic=itemView.findViewById(R.id.coverpic);
            desc=itemView.findViewById(R.id.description);
            imageButton=itemView.findViewById(R.id.visit);
        }
    }
}
