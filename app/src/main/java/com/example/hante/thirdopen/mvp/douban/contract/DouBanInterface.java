package com.example.hante.thirdopen.mvp.douban.contract;

import android.support.annotation.NonNull;

import com.example.hante.thirdopen.mvp.BaseModel;
import com.example.hante.thirdopen.mvp.BasePresenter;
import com.example.hante.thirdopen.mvp.BaseView;
import com.example.hante.thirdopen.mvp.douban.bean.DouBanInTheaters;

import java.util.List;

/**
 * 豆瓣 API interface
 */

public interface DouBanInterface {

    interface View extends BaseView<Presenter> {
        /**
         * 请求到的数据
         *
         * @param title            标题
         * @param subjectsBeanList Theaters List
         */
        void upDate(@NonNull String title, List<DouBanInTheaters.SubjectsBean> subjectsBeanList);

        /**
         * 返回错误
         *
         * @param errorMsg 错误信息
         */
        void onError(@NonNull String errorMsg);
    }

    interface DouBanModel extends BaseModel {

        void getTheaters(@NonNull getTheatersCallBack callBack);

        interface getTheatersCallBack {
            /**
             * 成功获取到数据
             *
             * @param theaters 获得的数据
             */
            void onSuccess(DouBanInTheaters theaters);

            /**
             * 获取数据失败
             *
             * @param msg 失败信息
             */
            void onError(@NonNull String msg);
        }
    }

    interface Presenter extends BasePresenter {
        /**
         * 获取远程数据
         */
        void getRemoteDate();
    }
}
