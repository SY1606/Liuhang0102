package com.example.liuhang0102.di.presenter;

import com.example.liuhang0102.di.contract.GoodsContract;
import com.example.liuhang0102.di.model.GoodsModelImpl;

import java.lang.ref.SoftReference;

public class GoodsPresenterImpl implements GoodsContract.GoodsPresenter {

    GoodsContract.GoodsView goodsView;
    private SoftReference<GoodsContract.GoodsView> softReference;
    private GoodsContract.GoodsModel goodsModel;

    @Override
    public void attachView(Object o) {
        this.goodsView = goodsView;
        softReference = new SoftReference<>(goodsView);
        goodsModel = new GoodsModelImpl();
    }

    @Override
    public void detachView(Object o) {
        softReference.clear();
    }

    @Override
    public void requestGoodsData() {
        goodsModel.containGoodsResponseData(new GoodsContract.GoodsModel.CallBack() {
            @Override
            public void responseData(String responseData) {
                goodsView.showData(responseData);
            }
        });
    }
}
