package com.example.liuhang0102.di.model;

import com.example.liuhang0102.di.contract.GoodsContract;

import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;

public class GoodsModelImpl implements GoodsContract.GoodsModel {

    @Override
    public void containGoodsResponseData(CallBack callBack) {

        requsetGoodsDataEnqeue(callBack);
    }

    private void requsetGoodsDataEnqeue(CallBack callBack) {
        OkHttpClient okHttpClient = new OkHttpClient();

        FormBody formBody = new FormBody.Builder().build();


    }
}
