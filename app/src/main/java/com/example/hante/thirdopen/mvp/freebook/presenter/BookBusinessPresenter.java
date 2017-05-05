package com.example.hante.thirdopen.mvp.freebook.presenter;


import com.example.hante.thirdopen.mvp.BasePresenter;
import com.example.hante.thirdopen.mvp.freebook.bean.FreeBook;
import com.example.hante.thirdopen.mvp.freebook.model.FreeBookModel;
import com.example.hante.thirdopen.mvp.freebook.view.BookView;

import java.util.List;

/**
 * Created By HanTe
 */

public class BookBusinessPresenter implements BasePresenter<FreeBook> {
    private BookView mBookView;
    private FreeBookModel mFreeBookModel;
    public BookBusinessPresenter(BookView view) {
        this.mBookView = view;
        this.mFreeBookModel = new FreeBookModel();
    }

    public void loadData (boolean fresh){
        mFreeBookModel.loadBookData(fresh, this);
    }
    public void stopRequest() {
        mFreeBookModel.cancel();
    }
    @Override
    public void onSuccess (FreeBook data) {
        List<FreeBook.DataBean.HotBookBean> hotBook = data.getData().getHotBook();
        List<FreeBook.DataBean.NewBookBean> newBook = data.getData().getNewBook();
        List<FreeBook.DataBean.BannerBean> banner = data.getData().getBanner();
        FreeBook.DataBean.HotBookBean mHotBook;
        for(FreeBook.DataBean.NewBookBean newBookBean : newBook) {
            mHotBook = new FreeBook.DataBean.HotBookBean();
            if(newBookBean.getImageUrl() != null) {
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
    public void onFail (String msg) {
        mBookView.showFailMsg(msg);
    }


}