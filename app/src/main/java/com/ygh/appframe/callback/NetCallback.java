package com.ygh.appframe.callback;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public interface NetCallback<T>{

    void onSuccess(T model);
    void onFailer(int code, String msg);
    void onCompleted();
}
