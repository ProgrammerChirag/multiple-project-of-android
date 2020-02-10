package com.chirag.whatsapp_clone;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyAdaptor extends RecyclerView.Adapter<MyAdaptor.MyViewHolder> {
    String mydata[];
    public MyAdaptor(String[] mydata) {
        this.mydata=mydata;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(parent.getContext());
        View view=inflater.inflate(R.layout.item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        String title =mydata[position];
        switch (position){
            case 0:
                holder.textView.setImageResource(R.drawable.p1);break;
            case 1:
                holder.textView.setImageResource(R.drawable.p2);break;
            case 2:
                holder.textView.setImageResource(R.drawable.p3);break;
            case 3:
                holder.textView.setImageResource(R.drawable.p4);break;
            case 4:
                holder.textView.setImageResource(R.drawable.p5);break;
            case 5:
                holder.textView.setImageResource(R.drawable.p6);break;
            case 6:
                holder.textView.setImageResource(R.drawable.p8);break;
            case 7:
                holder.textView.setImageResource(R.drawable.p9);break;
            case 8:
                holder.textView.setImageResource(R.drawable.p1);break;
            case 9:
                holder.textView.setImageResource(R.drawable.p2);break;
            case 10:
                holder.textView.setImageResource(R.drawable.p3);break;
            case 11:
                holder.textView.setImageResource(R.drawable.p4);break;
            case 12:
                holder.textView.setImageResource(R.drawable.p5);break;
            case 13:
                holder.textView.setImageResource(R.drawable.p6);break;
            case 14:
                holder.textView.setImageResource(R.drawable.p8);break;
            case 15:
                holder.textView.setImageResource(R.drawable.p9);break;
            case 16:
                holder.textView.setImageResource(R.drawable.p2);break;
        }
        holder.name.setText(title);
    }



    @Override
    public int getItemCount() {
        return mydata.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        com.mikhaellopez.circularimageview.CircularImageView textView;
        TextView name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.textview);
            name=itemView.findViewById(R.id.name);
        }
    }
}
