package com.example.hante.thirdopen.net;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created By HanTe
 * Retrofit
 * 封装一个retrofit集成0kHttp3的抽象基类
 */

public abstract class Network {

    private static OkHttpClient mOkHttpClient;

    protected static <T> T createAPI(Class<T> t, String baseUrl){
        if (mOkHttpClient == null){
            mOkHttpClient = OkHttp3Utils.getOkHttpClient();
        }
        Retrofit.Builder builder = new Retrofit.Builder();// 创建构建器
        Retrofit mRetrofit = builder
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())//
                // 返回数据通过 Gson 解析
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//RxJava 模式
                .client(mOkHttpClient)
                .build();
        return mRetrofit.create(t);
    }
}
