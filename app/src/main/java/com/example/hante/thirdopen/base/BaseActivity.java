package com.example.hante.thirdopen.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.hante.thirdopen.application.MyApplication;

/**
 * Created By HanTe
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MyApplication.getInstance().addActivity(this);
    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        MyApplication.getInstance().exit();
    }
}
