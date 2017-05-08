package com.example.hante.thirdopen.mvp.douban.presenter;

import android.support.annotation.NonNull;

import com.example.hante.thirdopen.mvp.douban.bean.DouBanInTheaters;
import com.example.hante.thirdopen.mvp.douban.contract.DouBanInterface;

import java.util.List;

/**
 * Created By HanTe
 */

public class DouBanPresenter implements DouBanInterface.Presenter {
    private DouBanInterface.View mView;
    private DouBanInterface.DouBanModel mModel;

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
}
