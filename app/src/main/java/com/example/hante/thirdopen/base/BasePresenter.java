package com.example.hante.thirdopen.base;

/**
 * Created By HanTe
 * MVP 基础Presenter 逻辑类
 */

public interface BasePresenter<T> {

    void onSuccess(T data);
    void onFail(String msg);

}
