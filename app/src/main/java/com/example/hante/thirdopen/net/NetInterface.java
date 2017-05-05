package com.example.hante.thirdopen.net;


import com.example.hante.thirdopen.mvp.douban.bean.DouBanInTheaters;
import com.example.hante.thirdopen.mvp.freebook.bean.FreeBook;
import com.example.hante.thirdopen.mvp.freebook.bean.FreeBookInfo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created By HanTe
 */

public interface NetInterface {

    // FreeBook
    // 获取首页详情
    @GET("api/getHomeInfo")
    Observable<FreeBook> getHomeInfo();

    // 获取book detail
    @GET("api/getBookInfo")
    Observable<FreeBookInfo> getBookInfo(@Query("id") int id);

    //  当前正在上映movie
    @GET("movie/in_theaters")
    Observable<DouBanInTheaters> getDouBanMovies();
}
