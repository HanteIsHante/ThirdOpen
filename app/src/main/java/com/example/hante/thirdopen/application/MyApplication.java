package com.example.hante.thirdopen.application;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.hante.greendao.DaoMaster;
import com.example.hante.greendao.DaoSession;
import com.example.hante.thirdopen.util.LogUtils;
import com.squareup.leakcanary.LeakCanary;

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
    private static Context mContext;

    private DaoMaster.DevOpenHelper mDevOpenHelper;
    private SQLiteDatabase mDatabase;
    private DaoMaster mDaoMaster;
    private DaoSession mDaoSession;


    @Override
    public void onCreate () {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        instance = this;
        mContext = getApplicationContext();
        new LogUtils.Builder();
        setDataBase();
    }

    private void setDataBase () {
        // 通过DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为greenDAO 已经帮你做了。
        // 注意：默认的DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        mDevOpenHelper = new DaoMaster.DevOpenHelper(this, "thirdOpen-db", null);
        mDatabase  = mDevOpenHelper.getWritableDatabase();
        mDaoMaster = new DaoMaster(mDatabase);
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }


    public SQLiteDatabase getDb() {
        return mDatabase;
    }

    /**
     * 获取Application 实例
     *
     * @return instance
     */
    public static MyApplication getInstance () {
        return instance;
    }

    public static Context getContext () {
        return mContext;
    }

    /**
     * 将打开的activity 添加到集合中
     *
     * @param activity activity
     */
    public void addActivity (Activity activity) {
        openActivity.add(activity);
    }

    /**
     * 结束指定activity
     *
     * @param activity 指定activity
     */
    public void finishActivity (Activity activity) {
        if(activity != null) {
            this.openActivity.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 添加临时 activity
     *
     * @param activity 指定activity
     */
    public void addTempActivity (Activity activity) {
        tempActivity.add(activity);
    }

    /**
     * 移除指定临时activity
     *
     * @param activity 指定activity
     */
    public void finishTempActivity (Activity activity) {
        if(activity != null) {
            this.tempActivity.remove(activity);
            activity.finish();
            activity = null;
        }
    }

    /**
     * 退出指定 的临时activity 集合
     */
    public void exitTempActivitys () {
        for(Activity activity : tempActivity) {
            if(activity != null) {
                activity.finish();
            }
        }
    }

    /**
     * 应用退出，结束所有activity
     */
    public void exit () {
        for(Activity activity : openActivity) {
            if(activity != null) {
                activity.finish();
            }
        }
        System.exit(0);
    }
}
