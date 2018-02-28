package com.ygh.appframe.utils;

import android.content.Intent;
import android.content.pm.PackageManager;


import java.util.List;

import com.ygh.appframe.app.MyApplication;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class IntentUtil {


    public static boolean isIntentSafe(Intent intent) {
        PackageManager packageManager = MyApplication.context.getPackageManager();
        List activities = packageManager.queryIntentActivities(intent,
                PackageManager.MATCH_DEFAULT_ONLY);
        return activities.size() > 0;
    }
}
