package com.ygh.appframe.mvp.main.presenter;

import com.ygh.appframe.base.BasePresenterImpl;
import com.ygh.appframe.mvp.main.view.MainView;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class MainParsenterImpl extends BasePresenterImpl<MainView> {
    public MainParsenterImpl(MainView mainView) {
        attachView(mainView);

    }

    public void switchNavigation(int id) {
        View.SwitchItem(id);

    }


}
