package com.ygh.appframe.mvp.news.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.ygh.appframe.R;
import com.ygh.appframe.base.BaseActivity;
import com.ygh.appframe.mvp.news.presenter.NewsDetailPresenterImpl;
import com.ygh.appframe.mvp.news.view.NewsDetailView;
import com.ygh.appframe.utils.ImageUitls;
import com.ygh.appframe.utils.ViewUtil;
import butterknife.BindView;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class NewsDetailActivity extends BaseActivity<NewsDetailPresenterImpl> implements NewsDetailView {

    @BindView(R.id.progress)
    ProgressBar mProgressBar;
    @BindView(R.id.Detail_toolbar)
    Toolbar mToolbar;

    @BindView(R.id.web_container)
    FrameLayout web_container;
    //    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    private WebView webView;
    String Share_url, Title, Author_avatar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    private void initView() {
        ViewUtil.setFullScreen(this);
        Intent intent = getIntent();
        Share_url = intent.getStringExtra("Share_url");
        Title = intent.getStringExtra("Title");
        Author_avatar = intent.getStringExtra("Author_avatar");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        initWebView();
    }

    /**
     * 初始化webview
     */
    private void initWebView() {

//        collapsingToolbar.setTitle(Title);
        Log.i("INFO", Share_url);
        ImageUitls.loadLocal(NewsDetailActivity.this, Author_avatar, (ImageView) findViewById(R.id.ivImage));
        webView = new WebView(this);
        web_container.addView(webView);
        webView.setVisibility(View.INVISIBLE);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setAppCacheEnabled(true);
        settings.setDomStorageEnabled(true);
        webView.loadUrl(Share_url);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(final WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
                if (newProgress == 100) {
                    view.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            hideProgress();
                            view.setVisibility(View.VISIBLE);
                        }
                    }, 300);
                }
            }
        });
    }

    @Override
    protected NewsDetailPresenterImpl createPresenter() {
        return new NewsDetailPresenterImpl(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_news_detail;
    }


    @Override
    public void getDataSuccess() {

    }

    @Override
    public void getDataFailer(String msg) {

    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

}
