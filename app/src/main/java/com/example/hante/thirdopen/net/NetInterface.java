package com.example.hante.thirdopen.net;

import com.example.hante.thirdopen.mvp.entry.freebook.FreeBook;
import com.example.hante.thirdopen.mvp.entry.freebook.FreeBookInfo;

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
}
