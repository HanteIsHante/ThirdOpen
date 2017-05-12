package com.example.hante.thirdopen.mvp.freebook.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hante.thirdopen.R;
import com.example.hante.thirdopen.base.BaseActivity;
import com.example.hante.thirdopen.mvp.freebook.bean.FreeBookInfo;
import com.example.hante.thirdopen.mvp.freebook.model.FreeBookModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created By HanTe
 */

public class BookInfoActivity extends BaseActivity implements PageInterface {


    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.book_image)
    ImageView mBookImage;
    @BindView(R.id.book_name)
    TextView mBookName;
    @BindView(R.id.book_auth)
    TextView mBookAuth;
    @BindView(R.id.booktype)
    TextView mBookType;
    @BindView(R.id.book_progress)
    TextView mBookProgress;
    @BindView(R.id.download)
    TextView mDownLoad;
    @BindView(R.id.book_desc)
    TextView mBookDesc;
    @BindView(R.id.book_length)
    TextView mBookLength;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_info);
        ButterKnife.bind(this);
        initUI();
        int id = getIntent().getIntExtra("id", 0);
        if(id != 0) {
            FreeBookModel.getFreeBookInfo(id, this);
        }
    }

    private void initUI () {
        setSupportActionBar(mToolbar);
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        }
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                finish();
            }
        });
    }

    public static void setId (Activity activity, int id) {
        Intent intent = new Intent(activity, BookInfoActivity.class);
        intent.putExtra("id", id);
        activity.startActivity(intent);
    }

    @Override
    public void SendData (Object o) {
        FreeBookInfo freeBookInfo = (FreeBookInfo) o;
        FreeBookInfo.DataBean data = freeBookInfo.getData();
        String bookImageUrl = data.getBookImageUrl();
        String bookAuthor = data.getBookAuthor();
        String bookIntroduction = data.getBookIntroduction();
        String bookProgress = data.getBookProgress();
        String bookName = data.getBookName();
        String bookUpdateTime = data.getBookUpdateTime();
        String bookLength = data.getBookLength();
        String bookDownload = data.getBookDownload();
        String bookType = data.getBookType();
        Glide.with(this).load(bookImageUrl)
                .error(getResources().getDrawable(R.mipmap.nocover))// 加载失败时显示图片
                .placeholder(getResources().getDrawable(R.mipmap.nocover))// 加载过长中显示的图片
                .into(mBookImage);
        mBookName.setText(bookName);
        mBookAuth.setText(bookAuthor);
        mBookType.setText(bookType);
        mBookProgress.setText(bookProgress);
        mBookDesc.setText(Html.fromHtml(bookIntroduction));
        mDownLoad.setText(bookUpdateTime);
        mBookLength.setText(bookLength);
    }
}
