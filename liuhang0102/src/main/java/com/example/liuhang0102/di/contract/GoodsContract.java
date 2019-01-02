package com.example.liuhang0102.di.contract;

public interface GoodsContract {

    public interface GoodsView{

        public void showData(String responseData);
    }

    public interface GoodsPresenter<GoodsView>{

        public void attachView(GoodsView goodsView) ;

        public void detachView(GoodsView goodsView);

        public void requestGoodsData();
    }

    public interface GoodsModel{
        public void containGoodsResponseData(CallBack callBack);

        public interface CallBack{
            public void responseData(String responseData);
        }
    }
}
