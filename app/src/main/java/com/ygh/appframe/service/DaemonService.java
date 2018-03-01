package com.ygh.appframe.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ygh.appframe.ProcessService;

/**
 * 守护进程服务
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class DaemonService extends Service {
    private DaemonBinder binder;   //和LocalService的binder相互绑定
    private DaemonConn myConn;
    private final String TAG = "DaemonService";

    private class MessengerHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
            }
        }
    }

    private Messenger messenger = new Messenger(new MessengerHandler());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return messenger.getBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        binder = new DaemonBinder();
        if (myConn == null) {
            myConn = new DaemonConn();
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        bindService(new Intent(this, CoreService.class),
                myConn,
                Context.BIND_IMPORTANT);
        return super.onStartCommand(intent, flags, startId);
    }

    class DaemonBinder extends ProcessService.Stub {
        @Override
        public String getServiceName() throws RemoteException {
            return "DaemonService";
        }
    }


    class DaemonConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e(TAG, "LocalService连接成功--------");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e(TAG, "LocalService killed--------");
            startService(new Intent(DaemonService.this, CoreService.class));
            bindService(new Intent(DaemonService.this, CoreService.class),
                    myConn, Context.BIND_IMPORTANT);
        }
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
