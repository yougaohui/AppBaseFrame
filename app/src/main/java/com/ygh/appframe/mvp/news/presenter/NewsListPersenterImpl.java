package com.ygh.appframe.mvp.news.presenter;

import com.ygh.appframe.base.BasePresenterImpl;
import com.ygh.appframe.callback.NetCallback;
import com.ygh.appframe.callback.SubscriberCallback;
import com.ygh.appframe.common.Api;
import com.ygh.appframe.mvp.news.model.NewsModel;
import com.ygh.appframe.mvp.news.view.NewsListView;
import com.ygh.appframe.network.news.BaozouService;
import com.ygh.appframe.network.news.NewsNetwork;


/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class NewsListPersenterImpl extends BasePresenterImpl<NewsListView> {
    public BaozouService mBaozouService = NewsNetwork.getRetrofit(Api.BAOZOU).create(BaozouService.class);

    public NewsListPersenterImpl(NewsListView newsListView) {
        attachView(newsListView);

    }

    /**
     * 默认加载第一页的数据
     */
    public void loadData(int channels) {
        View.showProgress();
        addSubscription(mBaozouService.getNews(channels), new SubscriberCallback<>(new NetCallback<NewsModel>() {
            @Override
            public void onSuccess(NewsModel model) {
                View.addDate(model);
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

    /**
     * 加载下一页的数据
     */
    public void loadNextData(int channels, int timestamp) {
        View.showProgress();
        addSubscription(mBaozouService.getNextNews(channels, timestamp), new SubscriberCallback<>(new NetCallback <NewsModel>() {
            @Override
            public void onSuccess(NewsModel model) {
                View.addDate(model);
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
