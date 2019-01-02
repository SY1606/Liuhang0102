package com.example.myapplication.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.data.bean.Goods;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    List<Goods.DataBean> dataList;
    Context context;

    public void setData(Context context,List<Goods.DataBean> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context,R.layout.frag_01,null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyHolder myHolder = (MyHolder) viewHolder;
        myHolder.textView.setText(dataList.get(i).getTitle());
        myHolder.textView1.setText(dataList.get(i).getPrice()+"");
        String images = dataList.get(i).getImages();
        String[] split = images.split("\\|");
        Glide.with(context).load(split[0]).into(myHolder.image_Two);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        ImageView image_Two;
        TextView textView;
       TextView textView1;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_One);
            textView1 = itemView.findViewById(R.id.text_Two);
            image_Two = itemView.findViewById(R.id.image_Two);

        }
    }
}
