package com.example.liuhang0102.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.liuhang0102.R;
import com.example.liuhang0102.data.Constant;
import com.example.liuhang0102.data.User;
import com.example.liuhang0102.di.contract.GoodsContract;
import com.example.liuhang0102.ui.adapter.MyAdapter;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    ArrayList<User.DataBean> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        OkGo.<String>get(Constant.SHOP_list+"?keywords=手机&page=").execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                String responseData = response.body().toString();
                Gson gson = new Gson();
                User user = gson.fromJson(responseData,User.class);
                final List<User.DataBean> list = user.getData();
                GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,2,GridLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(gridLayoutManager);
                final MyAdapter myAdapter = new MyAdapter();
                myAdapter.setData(MainActivity.this,list);
                recyclerView.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();

                myAdapter.setOnItemclickListener(new MyAdapter.onItemClickListener() {
                    @Override
                    public void onItemClick(User user) {

                    }
                });
            }
        });

    }

}
