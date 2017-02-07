package com.example.hante.thirdopen.useractivity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.hante.thirdopen.R;
import com.example.hante.thirdopen.ThirdOpenHomeActivity;

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

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }
    @OnClick({R.id.button_login, R.id.to_register})
    public void onClick (View view) {
        switch(view.getId()) {
            case R.id.button_login:
                Intent home = new Intent(getApplicationContext(), ThirdOpenHomeActivity.class);
                startActivity(home);
                finish();
                break;
            case R.id.to_register:
                Intent i = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(i);
                break;
        }
    }
}
