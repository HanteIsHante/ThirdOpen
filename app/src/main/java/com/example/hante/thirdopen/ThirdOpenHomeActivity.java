package com.example.hante.thirdopen;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.hante.thirdopen.base.BaseActivity;

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
        mFragmentList.add(new BookFragment());
        mFragmentList.add(new DouBanFragment());
        mFragmentList.add(new DouBanFragment());
        mFragmentList.add(new DouBanFragment());
        mFragmentList.add(new DouBanFragment());
        mFragmentList.add(new DouBanFragment());
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


    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        /*
          搜索按钮的相关逻辑
          */
        MenuItem menuItem = menu.findItem(R.id.action_search);//
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(menuItem);//加载searchview
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit (String query) {
                Toast.makeText(ThirdOpenHomeActivity.this, query, Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange (String newText) {
                if(TextUtils.isEmpty((newText))) {
                    Toast.makeText(ThirdOpenHomeActivity.this, "isEmpty", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(ThirdOpenHomeActivity.this, newText, Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });//为搜索框设置监听事件
        searchView.setSubmitButtonEnabled(true);//设置是否显示搜索按钮
        searchView.setQueryHint("查找");//设置提示信息
        searchView.setIconifiedByDefault(true);//设置搜索默认为图标
        return true;
    }
}
