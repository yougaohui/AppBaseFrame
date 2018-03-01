package com.ygh.appframe.app;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import com.blankj.utilcode.util.Utils;
import com.squareup.leakcanary.LeakCanary;
import com.ygh.appframe.service.CoreService;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class MyApplication extends Application {

    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        //初始化工具类
        Utils.init(context);
        //初始化内存泄漏检测插件
        if (!LeakCanary.isInAnalyzerProcess(this)) {
            LeakCanary.install(this);
        }
        startService(new Intent(this, CoreService.class));
    }
}
