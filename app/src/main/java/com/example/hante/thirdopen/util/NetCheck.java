package com.example.hante.thirdopen.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * 网络检查
 */

public class NetCheck {
    /**
     * 检查是否有网络
     * 网络存在是 cm.getActiveNetworkInfo() 返回网络信息
     * 网络不存在时，返回的是null
     */
    public static boolean isNetAvailable (Context context) {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = cm.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isAvailable();
    }
}
