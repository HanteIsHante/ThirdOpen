package com.example.hante.thirdopen.useractivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hante.greendao.UserDao;
import com.example.hante.thirdopen.R;
import com.example.hante.thirdopen.application.MyApplication;
import com.example.hante.thirdopen.db.bean.User;
import com.example.hante.thirdopen.util.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

//Execute task initFreeline and download freeline dependencies...

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.toolbar_register)
    Toolbar toolbarRegister;
    @BindView(R.id.Email)
    EditText Email;
    @BindView(R.id.Phone)
    EditText Phone;
    @BindView(R.id.Password)
    EditText Password;
    @BindView(R.id.button_register)
    Button buttonRegister;
    private UserDao mUserDao;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initUI();
        mUserDao = MyApplication.getInstance().getDaoSession().getUserDao();
    }

    private void initUI () {
        setSupportActionBar(toolbarRegister);
        if(getSupportActionBar() == null) {
            return;
        }
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        toolbarRegister.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View view) {
                finish();
            }
        });
    }

    @OnClick(R.id.button_register)
    public void onClick () {
        if(Utils.isNotFastClick()) {
            if(!"".equalsIgnoreCase(Email.getText().toString()) &&
                    !"".equalsIgnoreCase(Phone.getText().toString()) &&
                    !"".equalsIgnoreCase(Password.getText().toString())) {
                User mUser = new User(null, Phone.getText().toString(),
                        Password.getText().toString(),
                        Email.getText().toString());
                try {
                    mUserDao.insert(mUser);
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                    finish();
                } catch(Exception e) {
                    Toast.makeText(this, "注册失败, 请重试!", Toast.LENGTH_SHORT).show();
                }
            }
        } else {
            Toast.makeText(this, "点击太频繁", Toast.LENGTH_SHORT).show();
        }
    }
}
