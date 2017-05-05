package com.example.hante.thirdopen.net;

import android.support.annotation.NonNull;

import static com.example.hante.thirdopen.net.Network.getRetrofit;

/**
 * Created By HanTe
 */

public class GetNetInterface {

    /**
     * @param baseUrl 基础base_url
     * @return retrofit
     */
    public static NetInterface getNetInterface(@NonNull String baseUrl) {
        return getRetrofit(baseUrl).create(NetInterface.class);
    }
}
