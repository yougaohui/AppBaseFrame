package com.ygh.appframe.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * 守护进程服务
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class DaemonService extends Service {
    public DaemonService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
