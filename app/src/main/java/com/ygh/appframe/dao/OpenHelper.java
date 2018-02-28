package com.ygh.appframe.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;


/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class OpenHelper extends DaoMaster.OpenHelper {
    public OpenHelper(Context context, String name) {
        super(context, name);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);
    }
}
