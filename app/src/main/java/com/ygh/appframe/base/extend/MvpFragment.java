package com.ygh.appframe.base.extend;

import android.os.Bundle;
import android.view.View;

import com.ygh.appframe.base.BaseFragment;
import com.ygh.appframe.base.BasePresenterImpl;


/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public abstract class MvpFragment<P extends BasePresenterImpl> extends BaseFragment {

    protected P mvpPresenter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mvpPresenter = createPresenter();

    }

    protected abstract P createPresenter();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mvpPresenter != null) {
            mvpPresenter.detachView();
        }
    }
}
