package com.example.hante.thirdopen.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created By HanTe
 */

public class SharePreUtils {

    public static final String  SHARE_NAME = "config";

    /**
     * 存储字符串
     * @param context 上下文
     * @param key  键
     * @param value 值
     */
    public static void putString (Context context, String key, String value){
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        sp.edit().putString(key, value).apply();
    }

    /**
     * 取出字符串
     * @param context 上下文
     * @param key 键
     * @param value 值为null
     * @return 返回键值
     */
    public static String getString (Context context, String key, String value){
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        return sp.getString(key, value);
    }

    /**
     * 存布尔值
     *
     * @param context 上下文
     * @param key 键
     * @param values 值
     */
    public static void putBoolean(Context context, String key, boolean values) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        sp.edit().putBoolean(key, values).apply();
    }

    /**
     * 取布尔值
     *
     * @param context 上下文
     * @param key 键
     * @param values   默认值
     * @return true/false
     */
    public static boolean getBoolean(Context context, String key, boolean values) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        return sp.getBoolean(key, values);
    }

    /**
     * ；删除一条字段
     *
     * @param context 上下文
     * @param key 键
     */
    public static void deleShare(Context context, String key) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        //单个清理
        sp.edit().remove(key).apply();
    }

    /**
     * 删除全部数据
     *
     * @param context
     */
    public static void deleShareAll(Context context) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        //全部清理
        sp.edit().clear().apply();
    }

    /**
     * 存int值
     *
     * @param context 上下文
     * @param key 键
     * @param values   值
     */
    public static void putInt(Context context, String key, int values) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        sp.edit().putInt(key, values).apply();
    }

    /**
     * 取int值
     *
     * @param context 上下文
     * @param key 键
     * @param values   默认值
     * @return 返回键值
     */
    public static int getInt(Context context, String key, int values) {
        SharedPreferences sp = context.getSharedPreferences(SHARE_NAME, Context.MODE_PRIVATE);
        return sp.getInt(key, values);
    }

}
