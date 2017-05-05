package com.example.hante.thirdopen.mvp.freebook.model;

import com.example.hante.thirdopen.contract.Contract;
import com.example.hante.thirdopen.mvp.BasePresenter;
import com.example.hante.thirdopen.mvp.freebook.activity.PageInterface;
import com.example.hante.thirdopen.mvp.freebook.bean.FreeBook;
import com.example.hante.thirdopen.mvp.freebook.bean.FreeBookInfo;
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

public class FreeBookModel extends Network {
    private static FreeBook mFreeBook;
    private static Disposable mDisposable;
    private static NetInterface INTERFACE = createAPI(NetInterface.class, Contract.FreeBook_Base_Url);
    private static FreeBookInfo mFreeBookInfo;

    public void loadBookData(boolean fresh, final BasePresenter basePresenter) {
        if (fresh) {
            INTERFACE
            .getHomeInfo()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Observer<FreeBook>() {
                @Override
                public void onSubscribe(Disposable d) {
                    mDisposable = d;
                }

                @Override
                public void onNext(FreeBook freeBook) {
                    mFreeBook = freeBook;
                }

                @Override
                public void onError(Throwable e) {
                    basePresenter.onFail(e.toString());
                }

                @Override
                public void onComplete() {
                    LogUtils.json(mFreeBook.toString());
                    basePresenter.onSuccess(mFreeBook);
                }
            });
        }
    }

    public static void getFreeBookInfo(int id, PageInterface pageInterface) {
        final PageInterface mPageInterface = pageInterface;
                INTERFACE
                .getBookInfo(id).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FreeBookInfo>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(FreeBookInfo freeBookInfo) {
                        LogUtils.a(freeBookInfo.toString());
                        mFreeBookInfo = freeBookInfo;

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {
                        mPageInterface.SendData(mFreeBookInfo);
                    }
                });
    }

    /**
     * 取消网络请求
     */
    public void cancel() {
        if (!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }
}
