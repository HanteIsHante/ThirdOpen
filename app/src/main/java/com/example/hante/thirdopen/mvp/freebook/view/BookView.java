package com.example.hante.thirdopen.mvp.freebook.view;

import com.example.hante.thirdopen.mvp.BaseView;
import com.example.hante.thirdopen.mvp.freebook.bean.FreeBook;

import java.util.List;


/**
 * Created By HanTe
 */

public interface BookView extends BaseView {

    void newFreeBooks(List<FreeBook.DataBean.HotBookBean> book);

    void showFailMsg(String msg);

    void setBanner(List<FreeBook.DataBean.BannerBean> beanList);
}
