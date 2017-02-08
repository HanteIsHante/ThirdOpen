package com.example.hante.thirdopen.net;

import com.example.hante.thirdopen.contract.Contract;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created By HanTe
 * Retrofit
 */

public class Network {

    private static Retrofit mRetrofit;

    public static Retrofit getRetrofit(){
        if (mRetrofit == null){
            Retrofit.Builder builder = new Retrofit.Builder();// 创建构建器
            mRetrofit = builder.baseUrl(Contract.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())// 返回数据通过Gson 解析
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())//RxJava 模式
                    .build();
        }
        return mRetrofit;
    }



}
