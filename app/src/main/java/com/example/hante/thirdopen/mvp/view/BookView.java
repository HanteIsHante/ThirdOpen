package com.example.hante.thirdopen.mvp.view;

import com.example.hante.thirdopen.base.BaseView;
import com.example.hante.thirdopen.mvp.entry.freebook.FreeBook;

import java.util.List;

/**
 * Created By HanTe
 */

public interface BookView  extends BaseView{

    void newFreeBooks (List<FreeBook.DataBean.HotBookBean> book);

    void showFailMsg (String msg);

    void setBanner (List<FreeBook.DataBean.BannerBean> beanList);
}
