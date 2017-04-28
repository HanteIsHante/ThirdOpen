package com.example.hante.thirdopen.net;

import com.example.hante.thirdopen.application.MyApplication;
import com.example.hante.thirdopen.util.NetCheck;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;

/**
 * 设置网络拦截器，当有网络时，请求远程
 * 没有网络时，从本地缓存中取出数据
 */

public class NetCache {

    //拦截器：
    static Interceptor interceptor = new Interceptor() {
        @Override
        public okhttp3.Response intercept (Chain chain) throws IOException {
            // 对请求进行拦截：无网络是强制读取缓存
            Request request = chain.request();
            boolean netAvailable = NetCheck.isNetAvailable(MyApplication.getContext());
            if(!netAvailable) {
                request = request.newBuilder().cacheControl(CacheControl.FORCE_CACHE)
                        .build();
            }
            //对响应进行拦截
            //有网络时，移除header，设置缓存超时时间为1小时
            okhttp3.Response response = chain.proceed(request);
            if(NetCheck.isNetAvailable(MyApplication.getContext())) {
                int maxAge = 60 * 60;             //1小时
                response.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public,max-age=" + maxAge)
                        .build();
            } else {
                //无网络时，缓存时间为1周
                int maxScale = 60 * 60 * 24 * 7;  // 1周
                response.newBuilder().removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxScale)
                        .build();
            }
            return response;
        }
    };
}
