package com.ygh.appframe.mvp.news.view;


import com.ygh.appframe.mvp.news.model.NewsModel;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public interface NewsListView {
    void showProgress();

    void hideProgress();

    void loadFailer(String msg);

    void addDate(NewsModel data);
}
