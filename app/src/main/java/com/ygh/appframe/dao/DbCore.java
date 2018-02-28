package com.ygh.appframe.dao;

import android.content.Context;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */

public class DbCore {
    private static final String DB_NAME = "ygh.db";
    private static DaoMaster daoMaster;
    private static DaoSession daoSession;
    private static Context mContext;
    private static String DB;
    private static DbCore instance;

    public static void init(Context context) {
        init(context, DB_NAME);
    }

    public static void init(Context context, String name) {
        if (context == null) {
            throw new IllegalArgumentException("context can't be null");
        }
        mContext = context.getApplicationContext();
        DB = name;
    }

    /**
     * 单例模式
     *
     * @return
     */
    public static synchronized DbCore getInstance() {
        if (instance == null) {
            synchronized (DbCore.class) {
                if (instance == null) {
                    instance = new DbCore();
                }
            }
        }
        return instance;
    }

    public static DaoMaster getDaoMaster() {
        DaoMaster.OpenHelper helper = new OpenHelper(mContext, DB);
        daoMaster = new DaoMaster(helper.getReadableDb());
        return daoMaster;
    }

    public static DaoSession getDaoSession() {
        if (daoSession == null) {
            if (daoMaster == null) {
                daoMaster = getDaoMaster();
            }
            daoSession = daoMaster.newSession();
        }
        return daoSession;
    }
}
