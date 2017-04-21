package com.example.hante.thirdopen.mvp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.hante.thirdopen.R;
import com.example.hante.thirdopen.custome.GlideImageLoader;
import com.example.hante.thirdopen.mvp.adapter.freebook.FreeBookAdapter;
import com.example.hante.thirdopen.mvp.entry.freebook.FreeBook;
import com.example.hante.thirdopen.mvp.presenter.BookPresenter;
import com.example.hante.thirdopen.mvp.view.BookView;
import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By HanTe
 * 操控presenter 获取数据
 */

public class BookFragment extends Fragment implements BookView, SwipeRefreshLayout.OnRefreshListener,
        FreeBookAdapter.onItemClickListener {
    RecyclerView mRecyclerViewFreeBook;
    SwipeRefreshLayout mFreeBookRefresh;
    Banner mBannerFreeBook;
    private BookPresenter mBookPresenter;

    @Override
    public void onCreate (@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBookPresenter = new BookPresenter(this);
    }

    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.freebook_frg_layout, container, false);
        initUI(inflate);
        return inflate;
    }


    private void initUI (View inflate) {
        mRecyclerViewFreeBook = (RecyclerView)inflate.findViewById(R.id.recyclerView_freeBook);
        mFreeBookRefresh = (SwipeRefreshLayout)inflate.findViewById(R.id.freeBook_refresh);
        mBannerFreeBook = (Banner)inflate.findViewById(R.id.banner_freeBook);
        mFreeBookRefresh.setOnRefreshListener(this);
        mFreeBookRefresh.post(new Runnable() {
            @Override
            public void run () {
                mFreeBookRefresh.setRefreshing(true);
                mBookPresenter.loadData(true);
            }
        });
        mBannerFreeBook.setImageLoader(new GlideImageLoader());
        mRecyclerViewFreeBook.setHasFixedSize(true);
        mRecyclerViewFreeBook.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewFreeBook.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
        mRecyclerViewFreeBook.setNestedScrollingEnabled(false);//ScrollView 嵌套 RecycleView 滑动卡顿
    }


    @Override
    public void onDestroy () {
        super.onDestroy();
        // 销毁
        mBookPresenter.stopRequest();
    }


    @Override
    public void newFreeBooks (List<FreeBook.DataBean.HotBookBean> book) {
        // 更新UI
        if(book != null) {
            FreeBookAdapter mFreeBookAdapter = new FreeBookAdapter(getActivity(), book);
            mRecyclerViewFreeBook.setAdapter(mFreeBookAdapter);
            mFreeBookRefresh.setRefreshing(false);
            mFreeBookAdapter.setOnItemClickListener(this);
        }
    }

    @Override
    public void showFailMsg (String msg) {
        // 显示错误信息
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
        mFreeBookRefresh.setRefreshing(false);
    }

    @Override
    public void setBanner (List<FreeBook.DataBean.BannerBean> beanList) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < beanList.size(); i++) {
            list.add(beanList.get(i).getImageUrl());
        }
        mBannerFreeBook.setImages(list).start();
    }

    @Override
    public void onRefresh () {
        mBookPresenter.loadData(true);
    }

    @Override
    public void onItemClick (View view, int position) {
        Toast.makeText(getActivity(), "click " + position, Toast.LENGTH_SHORT).show();
        // 跳转详情页，传值
    }
}
