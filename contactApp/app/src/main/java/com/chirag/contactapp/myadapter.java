package com.chirag.contactapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {
    List<contact_class> list=new ArrayList<>();
    Context context;

    public myadapter(List<contact_class> list,Context context) {
        this.context=context;
        this.list=list;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final myviewholder holder, int position) {
        final contact_class contact =list.get(position);
        holder.textView.setText(contact.getName());
        Log.d("name_user ",contact.getName() );
        holder.imageView.setImageResource(R.drawable.ic_person_black_24dp);
        holder.number.setText(contact.getNumber());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,profile_number.class);
                i.putExtra("number",contact.getNumber());
                i.putExtra("name",contact.getName());
                i.putExtra("about",contact.getAbout());
               context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        TextView number;
        ImageView callview;
        public myviewholder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.image);
            number=itemView.findViewById(R.id.number);
            textView=itemView.findViewById(R.id.name);
            callview=imageView.findViewById(R.id.call);
        }
    }
}
