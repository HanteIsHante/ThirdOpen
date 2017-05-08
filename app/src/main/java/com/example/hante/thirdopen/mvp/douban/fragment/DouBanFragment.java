package com.example.hante.thirdopen.mvp.douban.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hante.thirdopen.R;
import com.example.hante.thirdopen.mvp.douban.adapter.DouBanAdapter;
import com.example.hante.thirdopen.mvp.douban.bean.DouBanInTheaters;
import com.example.hante.thirdopen.mvp.douban.contract.DouBanInterface;
import com.example.hante.thirdopen.mvp.douban.presenter.DouBanPresenter;
import com.example.hante.thirdopen.util.LogUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 豆瓣院线movies
 */

public class DouBanFragment extends Fragment implements
        SwipeRefreshLayout.OnRefreshListener, DouBanInterface.View, DouBanAdapter.onItemClickListener {

    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.recyclerView_douBan)
    RecyclerView mRecyclerViewDouBan;
    @BindView(R.id.root_fresh)
    SwipeRefreshLayout mRootFresh;
    Unbinder unbinder;
    private DouBanInterface.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.douban_frag, container, false);
        unbinder = ButterKnife.bind(this, inflate);
        mRootFresh.setOnRefreshListener(this);
        new DouBanPresenter(this);
        initUI();
        return inflate;
    }

    private void initUI() {
        mRecyclerViewDouBan.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerViewDouBan.setHasFixedSize(true);
        mRecyclerViewDouBan.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.HORIZONTAL));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {
        LogUtils.d("豆瓣 刷新 ");
        mPresenter.getRemoteDate();
    }

    @Override
    public void upDate(@NonNull String title, List<DouBanInTheaters.SubjectsBean> subjectsBeanList) {
        mTitle.setText(title);
        DouBanAdapter adapter = new DouBanAdapter(getActivity(), subjectsBeanList);
        mRecyclerViewDouBan.setAdapter(adapter);
        mRootFresh.setRefreshing(false);
    }

    @Override
    public void onError(@NonNull String errorMsg) {
        Toast.makeText(getActivity(), errorMsg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPresenter(DouBanInterface.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void onItemClick(View view, int position) {

    }
}
