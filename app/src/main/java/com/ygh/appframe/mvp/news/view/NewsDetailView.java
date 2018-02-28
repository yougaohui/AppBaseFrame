package com.ygh.appframe.mvp.news.view;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public interface NewsDetailView {
    void   getDataSuccess();
    void   getDataFailer(String msg);
    void   showProgress();
    void   hideProgress();

}
