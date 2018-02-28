package com.ygh.appframe.network.video;


import com.ygh.appframe.mvp.video.model.VideoModel;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public interface LolService {
    @GET("apis/rest/ItemsService/videos")
    Observable<VideoModel> getVideo(
            @Query("catid") int catid,
            @Query("catwordid") int catwordid,
            @Query("page") int page,
            @Query("t_") String t_,
            @Query("p_") int p_);
}
