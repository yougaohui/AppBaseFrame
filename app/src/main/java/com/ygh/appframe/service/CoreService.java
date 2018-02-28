package com.ygh.appframe.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * 核心服务
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class CoreService extends Service {
    public CoreService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
