package com.example.myapplication.ui.frag;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.myapplication.R;
import com.example.myapplication.data.Constant;
import com.example.myapplication.data.bean.Goods;
import com.example.myapplication.data.bean.User;
import com.example.myapplication.ui.adapter.MyAdapter;
import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class Frag01 extends Fragment {
    @BindView(R.id.ImageView)
    android.widget.ImageView ImageView;
    @BindView(R.id.edit_Text)
    EditText editText;
    Unbinder unbinder;
    private RecyclerView recyclerView;
    private MyAdapter myAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag01, container, false);
        unbinder = ButterKnife.bind(this,view);
        recyclerView = view.findViewById(R.id.recyclerview);
        OkGo.<String>get(Constant.LISTVIEW_URL+"?keywords=手机&page=").execute(new StringCallback() {


            @Override
            public void onSuccess(Response<String> response) {
                String responseData = response.body().toString();
                Gson gson = new Gson();
                Goods goods = gson.fromJson(responseData,Goods.class);
                List<Goods.DataBean> dataList = goods.getData();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
                recyclerView.setLayoutManager(linearLayoutManager);

                myAdapter = new MyAdapter();
                myAdapter.setData(getContext(),dataList);
                recyclerView.setAdapter(myAdapter);
                myAdapter.notifyDataSetChanged();
            }
        });

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
