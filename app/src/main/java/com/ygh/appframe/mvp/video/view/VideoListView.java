package com.ygh.appframe.mvp.video.view;


import com.ygh.appframe.mvp.video.model.VideoModel;

/**
 * 作者：hequnsky on 2016/6/29 19:28
 * 邮箱：hequnsky@gmail.com
 */
public interface VideoListView {
    void showProgress();
    void hideProgress();
    void addData(VideoModel model);
    void loadFailer(String msg);

}
