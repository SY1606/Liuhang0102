package com.example.liuhang0102.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.liuhang0102.R;
import com.example.liuhang0102.data.User;
import com.example.liuhang0102.ui.activity.MainActivity;
import com.example.liuhang0102.ui.activity.TwoActivity;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

   List<User.DataBean> list;
    Context context;

    onItemClickListener onItemClickListener;
     OnItemLongClickListener onItemLongClickListener;
    public void setData(Context context,List<User.DataBean> list){
        this.context = context;
        this.list = list;
    }

    //点击事件
    public void setOnItemclickListener(onItemClickListener onItemclickListener){
        this.onItemClickListener = onItemclickListener;
    }

    public interface onItemClickListener{
        void onItemClick(User user);
    }

    //长按删除

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener){
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public interface OnItemLongClickListener{
        void onItemLongClick(User user);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = View.inflate(context,R.layout.list_layout,null);

        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, final int i) {
        MyHolder myHolder  = (MyHolder) viewHolder;
        myHolder.textView.setText(list.get(i).getTitle());
        myHolder.textView1.setText(list.get(i).getPrice()+"");
        String images = list.get(i).getImages();
        String[] split = images.split("\\|");
        Glide.with(context).load(split[0]).into(myHolder.imageView);

        //点击跳转
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,TwoActivity.class);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

         ImageView imageView;
         TextView textView1;
         TextView textView;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text);
            textView1 = itemView.findViewById(R.id.text1);
            imageView = itemView.findViewById(R.id.image);
        }
    }
}
