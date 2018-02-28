package com.ygh.appframe.mvp.video.presenter;

import com.ygh.appframe.base.BasePresenterImpl;
import com.ygh.appframe.callback.NetCallback;
import com.ygh.appframe.callback.SubscriberCallback;
import com.ygh.appframe.common.Api;
import com.ygh.appframe.mvp.video.model.VideoModel;
import com.ygh.appframe.mvp.video.view.VideoListView;
import com.ygh.appframe.network.http.video.LolService;
import com.ygh.appframe.network.http.video.VideoNetwork;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class VideoListPresenterImpl extends BasePresenterImpl<VideoListView> {
    public LolService mLolService = VideoNetwork.getRetrofit(Api.LOL).create(LolService.class);

    public VideoListPresenterImpl(VideoListView mVideoListView) {
        attachView(mVideoListView);
    }

    public void loadData(int catid, int catwordid, int page, String t_, int p_) {
        View.showProgress();
        addSubscription(mLolService.getVideo(catid, catwordid, page, t_, p_), new SubscriberCallback<>(new NetCallback<VideoModel>() {


            @Override
            public void onSuccess(VideoModel model) {
                View.addData(model);
            }

            @Override
            public void onFailer(int code, String msg) {
                View.loadFailer(msg);
            }

            @Override
            public void onCompleted() {
                View.hideProgress();

            }
        }));

    }

}
