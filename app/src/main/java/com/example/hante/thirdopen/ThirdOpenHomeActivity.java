package com.example.hante.thirdopen;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import com.example.hante.thirdopen.base.BaseActivity;
import com.example.hante.thirdopen.mvp.fragment.BookFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ThirdOpenHomeActivity extends BaseActivity {

    @BindView(R.id.toolbar_home)
    Toolbar mToolbarHome;
    @BindView(R.id.home_tab_layout)
    TabLayout mHomeTabLayout;
    @BindView(R.id.tabLayout_viewpager)
    ViewPager mTabLayoutViewpager;
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_open_home);
        ButterKnife.bind(this);

        initUI();
    }

    private void initUI () {
        mToolbarHome.setNavigationIcon(R.drawable.ic_apps_menu);
        setSupportActionBar(mToolbarHome);
        getSupportActionBar();
        if(getSupportActionBar() == null) {
            return;
        }
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        List<Fragment> mFragmentList = new ArrayList<>();
        List<String> mStringList = new ArrayList<>();
        BookFragment mBookFragment = null;
        for(int i = 0; i < 6; i++) {
            mBookFragment = new BookFragment();
            mFragmentList.add(mBookFragment);
        }
        mStringList.add("免费书籍");
        mStringList.add("豆瓣");
        mStringList.add("github");
        mStringList.add("头条");
        mStringList.add("知乎");
        mStringList.add("movies");
        mHomeTabLayout.setTabGravity(TabLayout.GRAVITY_CENTER);
        for(int i = 0; i < mStringList.size(); i++) {
            mHomeTabLayout.addTab(mHomeTabLayout.newTab().setText(mStringList.get(i)));
        }
        ViewPagerAdapter mViewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),
                mFragmentList, mStringList);
        mTabLayoutViewpager.setAdapter(mViewPagerAdapter);
        mHomeTabLayout.setupWithViewPager(mTabLayoutViewpager);
    }
}
