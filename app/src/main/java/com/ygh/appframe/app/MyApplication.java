package com.ygh.appframe.app;

import android.content.Context;
import android.content.Intent;

import com.blankj.utilcode.util.Utils;
import com.squareup.leakcanary.LeakCanary;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.umeng.commonsdk.UMConfigure;
import com.ygh.appframe.service.CoreService;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class MyApplication extends TinkerApplication {

    public static Context context;

    public MyApplication() {
        //热更新相关
        super(ShareConstants.TINKER_ENABLE_ALL, "com.ygh.appframe.app.SampleApplicationLike",
                "com.tencent.tinker.loader.TinkerLoader", false);
    }

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
        //友盟统计初始化
        UMConfigure.init(this, UMConfigure.DEVICE_TYPE_PHONE, "1fe6a20054bcef865eeb0991ee84525b");
        //启动核心服务
        startService(new Intent(this, CoreService.class));
    }
}
