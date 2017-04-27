package com.example.hante.thirdopen.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 *  网络检查
 */

public class NetCheck {

    /**
     * 检查是否有网络
     */
    public static boolean isNetAvailable (Context context ){
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo.isAvailable();
    }

    private static NetworkInfo getNetworkInfo(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }
}
