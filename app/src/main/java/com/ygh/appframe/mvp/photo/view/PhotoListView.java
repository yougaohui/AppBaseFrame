package com.ygh.appframe.mvp.photo.view;


import com.ygh.appframe.mvp.photo.model.PhotoModel;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public interface PhotoListView {

    void showProgress();
    void hideProgress();
    void addData(PhotoModel model);
    void loadFailer(String msg);
}
