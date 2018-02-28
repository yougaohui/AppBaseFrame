package com.ygh.appframe.mvp.video.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ygh.appframe.R;
import com.ygh.appframe.base.BaseActivity;
import com.ygh.appframe.mvp.video.presenter.VideoPlayPresenterImpl;
import com.ygh.appframe.mvp.video.view.VideoPlayView;
import com.ygh.appframe.utils.ViewUtil;

import butterknife.BindView;


public class VideoPlayActivity extends BaseActivity<VideoPlayPresenterImpl> implements VideoPlayView, View.OnTouchListener {
    @BindView(R.id.video_progress)
    ProgressBar mProgressBar;
    @BindView(R.id.rl_bg)
    View mBgView;

    private float mDownX;
    private float mDownY;
    String url, title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        ViewUtil.setFullScreen(this);
        mBgView.setOnTouchListener(this);
        Intent i = getIntent();
        url = i.getStringExtra("Url");
        title = i.getStringExtra("Title");
        Presente.PlayVideo(url);
    }

    @Override
    protected VideoPlayPresenterImpl createPresenter() {
        return new VideoPlayPresenterImpl(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_video_play;
    }

    @Override
    public void playVideo(String path) {
    }


    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void loadFailer(String msg) {
        Toast.makeText(VideoPlayActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mDownX = event.getX();
                mDownY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                if (Math.abs(mDownX - event.getX()) > 50 || Math.abs(mDownY - event.getY()) > 50) {
                    // 移动超过一定距离，ACTION_UP取消这次事件
                    mDownX = Integer.MAX_VALUE;
                    mDownY = Integer.MAX_VALUE;
                }
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        return true;

    }

    @Override
    public void onBackPressed() {
        finish();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

}
