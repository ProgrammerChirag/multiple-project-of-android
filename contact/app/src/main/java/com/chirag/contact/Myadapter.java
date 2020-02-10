package com.chirag.contact;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

class Myadapter extends RecyclerView.Adapter<Myadapter.MyViewHolder> {
    List<DataGet> list;
    Context context;

    public Myadapter(List<DataGet> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public Myadapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Myadapter.MyViewHolder holder, final int position) {
        holder.name.setText(list.get(position).getName());
        holder.mobile.setText(list.get(position).getMobile());
        Picasso.get().load(list.get(position).getImageURL()).into(holder.circleImageView);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + list.get(position).getMobile()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name , mobile;
        CircleImageView  circleImageView;
        LinearLayout linearLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView=itemView.findViewById(R.id.image);
            name=itemView.findViewById(R.id.name);
            mobile=itemView.findViewById(R.id.number);
            linearLayout=itemView.findViewById(R.id.contact);
        }
    }
}
