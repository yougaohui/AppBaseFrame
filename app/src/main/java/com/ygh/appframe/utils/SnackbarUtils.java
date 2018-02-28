package com.ygh.appframe.utils;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.ygh.appframe.app.MyApplication;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class SnackbarUtils {

    private static Context context = MyApplication.context;

    public static void showSnack(View rootView, int textId) {
        if (null != rootView) {
            Snackbar.make(rootView, textId, Snackbar.LENGTH_SHORT).show();
        }
    }

    public static void showSnackLong(View rootView, int textId) {
        if (null != rootView) {
            Snackbar.make(rootView, textId, Snackbar.LENGTH_LONG).show();
        }
    }
}
