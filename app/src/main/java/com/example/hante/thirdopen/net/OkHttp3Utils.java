package com.example.hante.thirdopen.net;

import com.example.hante.thirdopen.application.MyApplication;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;

public class OkHttp3Utils {

    private static OkHttpClient mOkHttpClient;
    // 添加缓存记录文件
    private static File httpCacheDirectory = new File(MyApplication.getInstance().
            getCacheDir(), "responses");
    /**
     * 获取OkHttpClient对象
     */
    public static OkHttpClient getOkHttpClient() {
        int cacheSize = 10 * 1024 * 1024; // 10 MiB， 缓存值大小
        if (null == mOkHttpClient) {
            Cache cache = new Cache(httpCacheDirectory, cacheSize);
            //同样okhttp3后也使用build设计模式
            mOkHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(30, TimeUnit.SECONDS)
                    .writeTimeout(30, TimeUnit.SECONDS)
                    .readTimeout(30, TimeUnit.SECONDS)
                    .addInterceptor(NetCache.interceptor)
                    .cache(cache)  // 缓存设置
                    .build();

        }
        return mOkHttpClient;
    }
}