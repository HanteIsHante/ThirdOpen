package com.example.hante.thirdopen.mvp.douban.presenter;

import android.support.annotation.NonNull;

import com.example.hante.thirdopen.mvp.douban.bean.DouBanInTheaters;
import com.example.hante.thirdopen.mvp.douban.contract.DouBanInterface;
import com.example.hante.thirdopen.mvp.douban.model.DouBanModel;

import java.util.List;

/**
 * Created By HanTe
 */

public class DouBanPresenter implements DouBanInterface.Presenter {
    private DouBanInterface.View mView;
    private DouBanInterface.DouBanModel mModel;

    public DouBanPresenter(DouBanInterface.View view) {
        mView = view;
        mView.setPresenter(this);
        mModel = new DouBanModel();
    }

    @Override
    public void getRemoteDate() {
        /*
         * 获取 数据
         */
        mModel.getTheaters(new DouBanInterface.DouBanModel.getTheatersCallBack() {
            @Override
            public void onSuccess(DouBanInTheaters theaters) {
                String title = theaters.getTitle();
                List<DouBanInTheaters.SubjectsBean> subjects = theaters.getSubjects();
                mView.upDate(title, subjects);
            }

            @Override
            public void onError(@NonNull String msg) {
                mView.onError(msg);
            }
        });
    }

    @Override
    public void start() {

    }
}
