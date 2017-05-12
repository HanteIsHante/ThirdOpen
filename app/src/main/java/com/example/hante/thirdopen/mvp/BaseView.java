package com.example.hante.thirdopen.mvp;

/**
 * Created By HanTe
 * <p>
 * MVP 基础View 视图接口类
 */

public interface BaseView<T extends BasePresenter> {
    /**
     * 实例化当前页面(fragment 中)的 Presenter 对象，
     *
     * @param presenter 当前页面的 逻辑操控类
     */
    void setPresenter(T presenter);
}
