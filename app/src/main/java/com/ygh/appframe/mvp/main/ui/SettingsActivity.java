package com.ygh.appframe.mvp.main.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;

import com.ygh.appframe.R;
import com.ygh.appframe.base.BaseActivity;
import com.ygh.appframe.base.BasePresenterImpl;
import butterknife.BindView;


public class SettingsActivity extends BaseActivity {


    @BindView(R.id.fl_preference)
    FrameLayout flPreference;
    @BindView(R.id.setting_toolbar)
    Toolbar toolbar;
    private SettingsFragment settingsFragment = new SettingsFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar.setTitle(R.string.nav_setting);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        getFragmentManager().beginTransaction().replace(R.id.fl_preference, settingsFragment).commit();
    }

    @Override
    protected BasePresenterImpl createPresenter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_settings;
    }
}
