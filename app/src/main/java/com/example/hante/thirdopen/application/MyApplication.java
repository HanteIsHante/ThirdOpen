package com.example.hante.thirdopen.application;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By HanTe
 * 用来初始化各种数据，服务
 */

public class MyApplication extends Application {

    // 记录栈中打开的activity
    private List<Activity> openActivity = new ArrayList<>();
    // 记录需要一次性关闭的activity
    private List<Activity> tempActivity = new ArrayList<>();
    private static MyApplication instance;
    @Override
    public void onCreate () {
        super.onCreate();
        instance = this;
    }

    /**
     * 获取Application 实例
     * @return instance
     */
    public static MyApplication getInstance(){
        return instance;
    }

    /**
     * 将打开的activity 添加到集合中
     * @param activity  activity
     */
    public void addActivity (Activity activity){
        openActivity.add(activity);
    }

    /**
     * 结束指定activity
     * @param activity 指定activity
     */
    public void finishActivity (Activity activity){
        if (activity != null){
            this.openActivity.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 添加临时 activity
     * @param activity 指定activity
     */
    public void addTempActivity (Activity activity){
        tempActivity.add(activity);
    }

    /**
     * 移除指定临时activity
     * @param activity 指定activity
     */
    public void finishTempActivity (Activity activity){
        if (activity != null){
            this.tempActivity.remove(activity);
            activity.finish();
            activity = null;
        }
    }
    /**
     * 退出指定 的临时activity 集合
     */
    public void exitTempActivitys (){
        for(Activity activity : tempActivity) {
            if (activity != null) {
                    activity.finish();
            }
        }
    }

    /**
     * 应用退出，结束所有activity
     */
    public void exit() {
        for(Activity activity : openActivity) {
            if(activity != null) {
                activity.finish();
            }
        }
        System.exit(0);
    }


}
