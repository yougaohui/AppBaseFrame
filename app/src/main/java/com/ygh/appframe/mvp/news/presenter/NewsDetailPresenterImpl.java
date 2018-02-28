package com.ygh.appframe.mvp.news.presenter;


import com.ygh.appframe.base.BasePresenterImpl;
import com.ygh.appframe.mvp.news.view.NewsDetailView;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class NewsDetailPresenterImpl extends BasePresenterImpl<NewsDetailView> {


    public NewsDetailPresenterImpl(NewsDetailView view){
        attachView(view);
    }
}
