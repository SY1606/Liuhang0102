package com.example.myapplication.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.myapplication.R;
import com.example.myapplication.ui.frag.Frag01;
import com.example.myapplication.ui.frag.Frag02;

public class TwoActivity extends AppCompatActivity {

    private RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        final FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        final Frag01 frag01 = new Frag01();
        final Frag02 frag02 = new Frag02();

        transaction.add(R.id.frag,frag01).show(frag01);
        transaction.add(R.id.frag,frag02).hide(frag02);

        transaction.commit();

        rg = findViewById(R.id.rg);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentTransaction transaction1 = manager.beginTransaction();
                switch (checkedId){
                    case 1:
                        transaction1.show(frag01).hide(frag02);
                        break;
                    case 2:
                        transaction1.show(frag02).hide(frag01);
                        break;
                }
                transaction1.commit();
            }
        });
    }
}
