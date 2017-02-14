package com.example.hante.thirdopen.util;

/**
 * Created By HanTe
 */

public class Utils {

    private static long lastClickTime = 0; // 记录点击时间

    /**
     * 防止 快速点击从而产生多个点击事件
     * TRUE 正常点击
     * FALSE 快速点击
     * @return b
     */
    public static boolean isNotFastClick(){
        long currentTime = System.currentTimeMillis();
        int spaceTime = 1000; // 时间间隔
        boolean b = currentTime - lastClickTime > spaceTime;
        lastClickTime = currentTime;
        return b;
    }

}
