package com.ygh.appframe.mvp.main.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ygh.appframe.R;
import com.ygh.appframe.base.BasePresenterImpl;
import com.ygh.appframe.base.extend.MvpFragment;


/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class BallFragment extends MvpFragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ball, null);
        return view;
    }

    @Override
    protected BasePresenterImpl createPresenter() {
        return null;
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initViews() {

    }
}
