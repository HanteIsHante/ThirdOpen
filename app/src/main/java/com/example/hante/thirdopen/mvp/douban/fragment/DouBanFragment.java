package com.example.hante.thirdopen.mvp.douban.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hante.thirdopen.R;
import com.example.hante.thirdopen.mvp.douban.model.DouBanModel;
import com.example.hante.thirdopen.util.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 豆瓣院线movies
 */

public class DouBanFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.recyclerView_douBan)
    RecyclerView mRecyclerViewDouBan;
    @BindView(R.id.root_fresh)
    SwipeRefreshLayout mRootFresh;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.douban_frag, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        mRootFresh.setOnRefreshListener(this);
        return inflate;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {
        LogUtils.d("豆瓣 刷新 ");
        DouBanModel.getDouBanTheaters();
    }
}
