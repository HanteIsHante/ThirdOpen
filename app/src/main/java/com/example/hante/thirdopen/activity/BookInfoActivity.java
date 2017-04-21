package com.example.hante.thirdopen.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hante.thirdopen.R;
import com.example.hante.thirdopen.base.BaseActivity;
import com.example.hante.thirdopen.mvp.model.FreeBookModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created By HanTe
 */

public class BookInfoActivity extends BaseActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.book_image)
    ImageView bookImage;
    @BindView(R.id.book_name)
    TextView bookName;
    @BindView(R.id.book_auth)
    TextView bookAuth;
    @BindView(R.id.booktype)
    TextView booktype;
    @BindView(R.id.book_progress)
    TextView bookProgress;
    @BindView(R.id.download)
    TextView download;
    @BindView(R.id.book_desc)
    TextView bookDesc;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_info);
        ButterKnife.bind(this);
        int id = getIntent().getIntExtra("id", 0);
        if (id != 0){
            FreeBookModel.getFreeBookInfo(id);
        }
    }

    public static void setId (Activity activity, int id) {
        Intent intent = new Intent(activity, BookInfoActivity.class);
        intent.putExtra("id", id);
        activity.startActivity(intent);
    }
}
