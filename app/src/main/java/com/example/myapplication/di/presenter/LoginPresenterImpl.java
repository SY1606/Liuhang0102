package com.example.myapplication.di.presenter;

import com.example.myapplication.di.contract.LoginContract;
import com.example.myapplication.di.model.LoginModelImpl;

import java.lang.ref.SoftReference;

public class LoginPresenterImpl implements LoginContract.LoginPresenter<LoginContract.LoginView> {

    LoginContract.LoginView loginView;
    private SoftReference<LoginContract.LoginView> loginViewSoftReference;
    private LoginContract.LoginModel loginModel;

    @Override
    public void attachView(LoginContract.LoginView loginView) {
        this.loginView = loginView;

        loginViewSoftReference = new SoftReference<>(loginView);
        loginModel = new LoginModelImpl();
    }

    @Override
    public void detachView(LoginContract.LoginView loginView) {
            loginViewSoftReference.clear();
    }

    @Override
    public void requsetLoginData(String name, String password) {
            loginModel.containLoginResponseData(name, password, new LoginContract.LoginModel.CallBack() {
                @Override
                public void responseData(String responseData) {
                    loginView.showData(responseData);
                }
            });
    }
}
