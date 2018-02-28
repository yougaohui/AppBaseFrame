package com.ygh.appframe.base;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public interface BasePresenter<V> {

    void attachView(V view);

    void detachView();


}
