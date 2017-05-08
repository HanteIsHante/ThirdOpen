package com.example.hante.thirdopen.mvp.freebook.presenter;


import com.example.hante.thirdopen.mvp.freebook.bean.FreeBook;
import com.example.hante.thirdopen.mvp.freebook.contract.BookInterface;
import com.example.hante.thirdopen.mvp.freebook.model.FreeBookModel;

import java.util.List;

/**
 * Created By HanTe
 */

public class BookBusinessPresenter implements BookInterface.Presenter {
    private BookInterface.View mBookView;
    private FreeBookModel mFreeBookModel;

    public BookBusinessPresenter(BookInterface.View view) {
        this.mBookView = view;
        mBookView.setPresenter(this);
        this.mFreeBookModel = new FreeBookModel();
    }

    /**
     * 停止、销毁请求
     */
    @Override
    public void stopRequest() {
        mFreeBookModel.cancel();
    }

    @Override
    public void onSuccess(FreeBook data) {
        List<FreeBook.DataBean.HotBookBean> hotBook = data.getData().getHotBook();
        List<FreeBook.DataBean.NewBookBean> newBook = data.getData().getNewBook();
        List<FreeBook.DataBean.BannerBean> banner = data.getData().getBanner();
        FreeBook.DataBean.HotBookBean mHotBook;
        for (FreeBook.DataBean.NewBookBean newBookBean : newBook) {
            mHotBook = new FreeBook.DataBean.HotBookBean();
            if (newBookBean.getImageUrl() != null) {
                mHotBook.setImageUrl(newBookBean.getImageUrl());
            }
            mHotBook.setId(newBookBean.getId());
            mHotBook.setAuthor(newBookBean.getAuthor());
            mHotBook.setBookName(newBookBean.getBookName());
            mHotBook.setIntroduction(newBookBean.getIntroduction());
            hotBook.add(mHotBook);
        }
        mBookView.newFreeBooks(hotBook);
        mBookView.setBanner(banner);
    }

    @Override
    public void onFail(String msg) {
        mBookView.showFailMsg(msg);
    }


    @Override
    public void start() {
        mFreeBookModel.loadBookData(true, this);
    }
}
