package com.ygh.appframe.service;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;

import com.blankj.utilcode.util.LogUtils;
import com.ygh.appframe.ProcessService;

/**
 * 核心服务
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class CoreService extends Service {

    private final String TAG = CoreService.class.getName();
    private CoreBinder binder;
    private CoreConn conn;

    public CoreService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //进程间通信
        binder = new CoreBinder();
        if (conn == null) {
            conn = new CoreConn();
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //绑定远程服务
        bindService(new Intent(CoreService.this, CoreService.class),
                conn,
                Context.BIND_IMPORTANT);
        return super.onStartCommand(intent, flags, startId);
    }

    /***********************双进程守护***********************/
    class CoreBinder extends ProcessService.Stub {
        @Override
        public String getServiceName() throws RemoteException {
            return "CoreService";
        }
    }

    /**
     * 绑定连接需要ServiceConnection
     */
    class CoreConn implements ServiceConnection {

        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            LogUtils.e(TAG, "CoreService连接远程服务成功 --------");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //远程服务被干掉；连接断掉的时候走此回调
            //在连接RemoateService异常断时，会回调；也就是RemoteException
            LogUtils.e(TAG, "DaemonService killed--------");
            startService(new Intent(CoreService.this, DaemonService.class));
            //绑定远程服务
            bindService(new Intent(CoreService.this, DaemonService.class),
                    conn, Context.BIND_IMPORTANT);
        }
    }
}
