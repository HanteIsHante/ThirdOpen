package com.example.hante.thirdopen.useractivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//Execute task initFreeline and download freeline dependencies...
import com.example.hante.thirdopen.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

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

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        initUI();
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
    }
}
