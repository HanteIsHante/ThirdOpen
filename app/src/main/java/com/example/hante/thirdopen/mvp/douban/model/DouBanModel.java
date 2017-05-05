package com.example.hante.thirdopen.mvp.douban.model;


import com.example.hante.thirdopen.contract.Contract;
import com.example.hante.thirdopen.mvp.douban.bean.DouBanInTheaters;
import com.example.hante.thirdopen.net.NetInterface;
import com.example.hante.thirdopen.net.Network;
import com.example.hante.thirdopen.util.LogUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * 豆瓣 网络相关请求
 */

public class DouBanModel extends Network {

    private static NetInterface INTERFACE = getRetrofit(Contract.DouBan_Base_Url).create(NetInterface.class);
    /**
     * 获取 Theaters movies
     */
    public static void getDouBanTheaters() {
        if (INTERFACE == null) {
            LogUtils.d("豆瓣 interface is null ");
            return;
        }
        INTERFACE
                .getDouBanMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DouBanInTheaters>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(DouBanInTheaters douBanInTheaters) {
                        LogUtils.a("豆瓣Theaters " + douBanInTheaters);
                    }

                    @Override
                    public void onError(Throwable e) {
                        LogUtils.e("豆瓣 " + e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
