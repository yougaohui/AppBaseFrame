package com.ygh.appframe.mvp.video.presenter;

import com.ygh.appframe.base.BasePresenterImpl;
import com.ygh.appframe.mvp.video.view.VideoPlayView;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class VideoPlayPresenterImpl extends BasePresenterImpl<VideoPlayView> {

    public VideoPlayPresenterImpl(VideoPlayView mVideoPlayView) {
        attachView(mVideoPlayView);
    }

    public void PlayVideo(String playUrl) {
        View.showProgress();
        View.playVideo(playUrl);
    }

    public void getVideoSuccess() {
        View.hideProgress();
    }


    public void getVideoFailer(String msg) {
        View.hideProgress();
        View.loadFailer(msg);
    }
}
