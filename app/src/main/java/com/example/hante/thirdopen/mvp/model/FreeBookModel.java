package com.example.hante.thirdopen.mvp.model;

import com.example.hante.thirdopen.contract.Contract;
import com.example.hante.thirdopen.mvp.BasePresenter;
import com.example.hante.thirdopen.mvp.entry.freebook.FreeBook;
import com.example.hante.thirdopen.mvp.entry.freebook.FreeBookInfo;
import com.example.hante.thirdopen.net.NetInterface;
import com.example.hante.thirdopen.net.Network;
import com.example.hante.thirdopen.util.LogUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created By HanTe
 * 获取数据
 */

public class FreeBookModel extends Network{
    private FreeBook mFreeBook;
    private static final NetInterface netInterface =
            getRetrofit(Contract.FreeBook_Base_Url).create(NetInterface.class);
    private Disposable mDisposable;

    public void loadBookData (boolean fresh, final BasePresenter basePresenter){
        if (fresh){
            netInterface.getHomeInfo()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<FreeBook>() {
                        @Override
                        public void onSubscribe (Disposable d) {
                            mDisposable = d;
                        }
                        @Override
                        public void onNext (FreeBook freeBook) {
                            mFreeBook = freeBook;
                        }
                        @Override
                        public void onError (Throwable e) {
                            basePresenter.onFail(e.toString());
                        }

                        @Override
                        public void onComplete () {
                            LogUtils.json(mFreeBook.toString());
                            basePresenter.onSuccess(mFreeBook);
                        }
                    });
        }
    }

    public static void getFreeBookInfo (int id) {
        netInterface.getBookInfo(id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FreeBookInfo>() {
                    @Override
                    public void onSubscribe (Disposable d) {

                    }

                    @Override
                    public void onNext (FreeBookInfo freeBookInfo) {
                        LogUtils.a(freeBookInfo.toString());

                    }

                    @Override
                    public void onError (Throwable e) {

                    }

                    @Override
                    public void onComplete () {
                    }
                });
    }
    /**
     * 取消网络请求
     */
    public void cancel () {
        if(!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }
}
