package com.example.myapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.data.bean.User;
import com.example.myapplication.di.contract.LoginContract;
import com.example.myapplication.di.presenter.LoginPresenterImpl;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements LoginContract.LoginView{

    @BindView(R.id.et_userName)
    EditText etUserName;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_zhu)
    Button btnZhu;
    @BindView(R.id.btn_LC)
    Button btnLC;

    LoginContract.LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenterImpl();
        loginPresenter.attachView(this);
    }

    @OnClick({R.id.btn_login, R.id.btn_zhu, R.id.btn_LC})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:

                String name = etUserName.getText().toString();
                String password = etPassword.getText().toString();
                loginPresenter.requsetLoginData(name,password);

                break;
            case R.id.btn_zhu:
                break;
            case R.id.btn_LC:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPresenter.detachView(this);
    }

    @Override
    public void showData(final String responseData) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,responseData,Toast.LENGTH_LONG).show();
                Gson gson = new Gson();
                User user = gson.fromJson(responseData,User.class);

                String status = user.getCode();
                if (status.equals("0")){
                    Intent intent = new Intent(MainActivity.this,TwoActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
