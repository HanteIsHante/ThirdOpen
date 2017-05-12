package com.example.hante.thirdopen.application;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.hante.greendao.DaoMaster;
import com.example.hante.greendao.DaoSession;

/**
 *  GreenDao  管理类
 */

public class GreenDaoManager {

    private static GreenDaoManager INSTANCE;
    private static DaoSession mDaoSession;

    public static GreenDaoManager getINSTANCE(){
        if(INSTANCE == null) {
            synchronized(GreenDaoManager.class){
                if(INSTANCE == null) {
                    INSTANCE = new GreenDaoManager();
                }
            }
        }
        return INSTANCE;
    }

    static void init(Context context){
        String DB_NAME = "thirdOpen-db";
        // 通过DaoMaster 的内部类 DevOpenHelper，你可以得到一个便利的SQLiteOpenHelper 对象。
        // 可能你已经注意到了，你并不需要去编写「CREATE TABLE」这样的 SQL 语句，因为greenDAO 已经帮你做了。
        // 注意：默认的DaoMaster.DevOpenHelper 会在数据库升级时，删除所有的表，意味着这将导致数据的丢失。
        // 所以，在正式的项目中，你还应该做一层封装，来实现数据库的安全升级。
        DaoMaster.DevOpenHelper mDevOpenHelper = new DaoMaster.DevOpenHelper(context, DB_NAME,
                null);
        SQLiteDatabase mDatabase  = mDevOpenHelper.getWritableDatabase();
        DaoMaster mDaoMaster = new DaoMaster(mDatabase);
        mDaoSession = mDaoMaster.newSession();
    }
    public DaoSession getDaoSession() {
        return mDaoSession;
    }
}
