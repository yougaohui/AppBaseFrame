package com.ygh.appframe.network.http.news;


import com.ygh.appframe.mvp.news.model.NewsModel;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public interface BaozouService {

    @GET("api/v31/channels/{channels_id}")
    Observable<NewsModel> getNews(@Path("channels_id") int channels_id);

    /**
     * 获取下一页
     *
     * @param timestamp
     * @return
     */
    @GET("api/v31/channels/{channels_id}")
    Observable<NewsModel> getNextNews(@Path("channels_id") int channels_id, @Query("timestamp") int timestamp);


}