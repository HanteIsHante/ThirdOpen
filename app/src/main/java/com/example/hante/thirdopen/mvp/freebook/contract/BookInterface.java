package com.example.hante.thirdopen.mvp.freebook.contract;

import com.example.hante.thirdopen.mvp.BasePresenter;
import com.example.hante.thirdopen.mvp.BaseView;
import com.example.hante.thirdopen.mvp.freebook.bean.FreeBook;

import java.util.List;

/**
 * Created By HanTe
 */

public interface BookInterface {
    /**
     * 视图接口
     */
    interface View extends BaseView<BookInterface.Presenter> {
        void newFreeBooks(List<FreeBook.DataBean.HotBookBean> book);

        void showFailMsg(String msg);

        void setBanner(List<FreeBook.DataBean.BannerBean> beanList);
    }

    /**
     * 逻辑接口
     */
    interface Presenter extends BasePresenter {
        /**
         * 成功 返回数据
         *
         * @param data 数据对象
         */
        void onSuccess(FreeBook data);

        /**
         * 请求失败
         *
         * @param msg 失败描述
         */
        void onFail(String msg);

        /**
         * 停止请求
         */
        void stopRequest();
    }
}
