package com.example.hante.thirdopen.useractivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hante.greendao.UserDao;
import com.example.hante.thirdopen.R;
import com.example.hante.thirdopen.ThirdOpenHomeActivity;
import com.example.hante.thirdopen.application.MyApplication;
import com.example.hante.thirdopen.db.bean.User;
import com.example.hante.thirdopen.util.Utils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.username)
    EditText mUsername;
    @BindView(R.id.password)
    EditText mPassword;
    @BindView(R.id.to_register)
    TextView toRegister;
    @BindView(R.id.button_login)
    Button mButtonLogin;
    private UserDao mUserDao;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        mUserDao = MyApplication.getInstance().getDaoSession().getUserDao();
    }

    @OnClick({R.id.button_login, R.id.to_register})
    public void onClick (View view) {
        switch(view.getId()) {
            case R.id.button_login:
                String userName = mUsername.getText().toString();
                String passWord = mPassword.getText().toString();
                if("".equalsIgnoreCase(userName)) {
                    Toast.makeText(this, "用户名为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if("".equalsIgnoreCase(passWord)) {
                    Toast.makeText(this, "密码为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(Utils.isNotFastClick()) {
                    List<User> users = mUserDao.loadAll();
                    for(User user : users) {
                        if((userName.equalsIgnoreCase(user.getUserName()) || userName
                                .equalsIgnoreCase(user.getEmail())) && passWord.equalsIgnoreCase
                                (user.getPassWord())) {
                            Toast.makeText(this, "成功登录", Toast.LENGTH_SHORT).show();
                            Intent home = new Intent(getApplicationContext(), ThirdOpenHomeActivity.class);
                            startActivity(home);
                            finish();
                        }
                    }
                } else {
                    Toast.makeText(this, "点击太频繁, 稍后再试!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.to_register:
                if(Utils.isNotFastClick()) {
                    Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                    startActivity(i);
                }
                break;
        }
    }
}
