package com.ygh.appframe.base;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;
import android.view.View;

import com.umeng.analytics.MobclickAgent;
import com.ygh.appframe.R;
import com.ygh.appframe.utils.EventBusUtils;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public abstract class BaseActivity<P extends BasePresenterImpl> extends SwipeBackActivity implements SlidingPaneLayout.PanelSlideListener {
    private CompositeSubscription mCompositeSubscription;
    protected P Presente;
    protected Context mContext;
    public final static String TAG = BaseActivity.class.getCanonicalName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Presente = createPresenter();
        mContext = this;
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        EventBusUtils.register(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onPageStart(TAG);
        MobclickAgent.onResume(mContext);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPageEnd(TAG);
        MobclickAgent.onPause(mContext);
    }


    @Override
    public void onPanelClosed(View view) {

    }

    @Override
    public void onPanelOpened(View view) {
        finish();
        this.overridePendingTransition(0, R.anim.slide_out_right);
    }

    @Override
    public void onPanelSlide(View view, float v) {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        onUnsubscribe();
        if (Presente != null) {
            Presente.detachView();
        }
        EventBusUtils.unregister(this);
    }


    public void onUnsubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }

    }

    public void addSubscription(Subscription subscription) {
        mCompositeSubscription = new CompositeSubscription();
        mCompositeSubscription.add(subscription);
    }


    protected abstract P createPresenter();

    protected abstract int getLayoutId();


    /**
     * 数据接收
     *
     * @author gaohui.you  839939978@qq.com
     * Create at 3/1/18 11:01 AM
     * @params
     **/
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(Object event) {

    }
}
