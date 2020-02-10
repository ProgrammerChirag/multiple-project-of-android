package com.chirag.todowithfirebase;


import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
public class myadapter extends RecyclerView.Adapter<myadapter.myviewholder> {
    String data[];
    List<notes> list=new ArrayList<>();
    Context context;
    public myadapter(List<notes> list,Context context){
        this.list=list;
        this.context=context;
    }

    @NonNull
    @Override
    public myadapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.layout,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myadapter.myviewholder holder, int position) {
        final notes title =list.get(position);
        holder.desc.setText(title.getDescription());
        holder.textView.setText(title.getTitle());
        Toast.makeText(context,title.getDescription(),Toast.LENGTH_LONG).show();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(context,profile.class);
                i.putExtra("title",title.getTitle());
                i.putExtra("desc",title.getDescription());
                i.putExtra("id",title.getId());
                context.startActivity(i);
            }
        });
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class myviewholder extends RecyclerView.ViewHolder{
        TextView textView,desc;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textview);
            desc=itemView.findViewById(R.id.description1);
        }
    }
}
