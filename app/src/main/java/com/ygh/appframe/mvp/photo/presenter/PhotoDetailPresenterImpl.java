package com.ygh.appframe.mvp.photo.presenter;

import com.ygh.appframe.base.BasePresenterImpl;
import com.ygh.appframe.mvp.photo.view.PhotoDetailView;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class PhotoDetailPresenterImpl extends BasePresenterImpl<PhotoDetailView> {


    public PhotoDetailPresenterImpl(PhotoDetailView mPhotoDetailView) {
        attachView(mPhotoDetailView);
    }

    public void LoadImg(String url) {
        View.showImg(url);

    }

    public void Failer(String msg, Exception e) {
        View.Failer(msg);
    }
}
