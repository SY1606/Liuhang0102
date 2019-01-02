package com.example.myapplication.di.contract;

public interface LoginContract {

    public interface LoginView{

        public void showData(String responseData);
    }

    public interface LoginPresenter<LoginView>{

        public void attachView(LoginView loginView);

        public void detachView(LoginView loginView);

        //请求数据
        public void requsetLoginData(String name,String password);
    }

    public interface LoginModel{
        public void containLoginResponseData(String name,String password,CallBack callBack);

        public interface CallBack{
            public void responseData(String responseData);
        }
    }
}
