package com.ygh.appframe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.ygh.appframe.mvp.main.ui.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends Activity {

    @BindView(R.id.splashview)
    ImageView splashview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        startAnim();
    }

    public void startAnim() {
        splashview.postDelayed(new Runnable() {
            @Override
            public void run() {
                StartApp();
            }

        }, 3000);
    }

    private void StartApp() {
        startActivity(new Intent(SplashActivity.this, MainActivity.class));
        overridePendingTransition(R.anim.abc_grow_fade_in_from_bottom, R.anim.abc_shrink_fade_out_from_bottom);
        finish();
    }

}
