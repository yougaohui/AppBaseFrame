package com.ygh.appframe.mvp.photo.presenter;

import com.ygh.appframe.base.BasePresenterImpl;
import com.ygh.appframe.callback.NetCallback;
import com.ygh.appframe.callback.SubscriberCallback;
import com.ygh.appframe.common.Api;
import com.ygh.appframe.mvp.photo.model.PhotoModel;
import com.ygh.appframe.mvp.photo.view.PhotoListView;
import com.ygh.appframe.network.http.photo.TngouNetwork;
import com.ygh.appframe.network.http.photo.TngouService;


/**
 *
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class PhotoListPresenterImpl extends BasePresenterImpl<PhotoListView> {

    public TngouService mTngouService = TngouNetwork.getRetrofit(Api.TNGOU).create(TngouService.class);

    public PhotoListPresenterImpl(PhotoListView mPhotoListView) {
        attachView(mPhotoListView);

    }

    /**
     * 默认加载第一页的数据
     */
    public void loadData(int id, int page, int rows) {
        View.showProgress();
        addSubscription(mTngouService.getPhotoList(id, page, rows), new SubscriberCallback<>(new NetCallback<PhotoModel>() {
            @Override
            public void onSuccess(PhotoModel model) {
                View.addData(model);
            }

            @Override
            public void onFailer(int code, String msg) {
                View.loadFailer(msg);
            }

            @Override
            public void onCompleted() {
                View.hideProgress();
            }
        }));

    }


//    public void loadData(int page) {
//        View.showProgress();
//        addSubscription(mTngouService.getPhotoList( page), new SubscriberCallback<>(new NetCallback<PhotoModel>() {
//            @Override
//            public void onSuccess(PhotoModel model) {
//                View.addData(model);
//            }
//
//            @Override
//            public void onFailer(int code, String msg) {
//                View.loadFailer(msg);
//            }
//
//            @Override
//            public void onCompleted() {
//                View.hideProgress();
//            }
//        }));
//
//    }
}
