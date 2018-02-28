package com.ygh.appframe.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bm.library.PhotoView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public class ImageUitls {


    public static void loadlocal(Context context, ImageView view, Integer resourceId, int animationId) {
        Glide.with(context)
                .load(resourceId)
                .animate(animationId)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(view);

    }


    public  static  void loadLocal(Context context, String url, ImageView view){
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(view);

    }


    public  static  void loadLocal(Context context, String url, PhotoView view){
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .centerCrop()
                .into(view);

    }

    public static void load(Context context, int resourceId, ImageView view) {
        Glide.with(context)
                .load(resourceId)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .crossFade()
                .into(view);
    }





}
