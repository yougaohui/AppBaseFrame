package com.ygh.appframe.mvp.photo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.bm.library.PhotoView;

import com.ygh.appframe.R;
import com.ygh.appframe.base.BaseActivity;
import com.ygh.appframe.common.Api;
import com.ygh.appframe.mvp.photo.presenter.PhotoDetailPresenterImpl;
import com.ygh.appframe.mvp.photo.view.PhotoDetailView;
import com.ygh.appframe.utils.ImageUitls;
import com.ygh.appframe.utils.ViewUtil;
import butterknife.BindView;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class PhotoDatailActivity extends BaseActivity<PhotoDetailPresenterImpl> implements PhotoDetailView {

    @BindView(R.id.photo_img)
    PhotoView mPhotoView;
    String url;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewUtil.setFullScreen(this);
        Intent intent=getIntent();
        url=intent.getStringExtra("url");
        Presente.LoadImg(url);

    }

    @Override
    protected PhotoDetailPresenterImpl createPresenter() {
        return new PhotoDetailPresenterImpl(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_photo_detail;
    }

    @Override
    public void showImg(String url) {
        ImageUitls.loadLocal(PhotoDatailActivity.this, Api.IMAGER_URL+url,mPhotoView);
    }

    @Override
    public void Failer(String msg) {
        Toast.makeText(PhotoDatailActivity.this,msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }


}
