package com.example.hante.thirdopen.net;

import com.example.hante.thirdopen.mvp.entry.freebook.FreeBook;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created By HanTe
 */

public interface NetInterface {

    // FreeBook
    // 获取首页详情
    @GET("api/getHomeInfo")
    Observable<FreeBook> getHomeInfo();

}
