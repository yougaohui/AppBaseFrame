package com.ygh.appframe.network.photo;


import com.ygh.appframe.mvp.photo.model.PhotoModel;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by gaohui.you on 2/28/18
 * Email:839939978@qq.com
 */
public interface TngouService {

    @GET("/tnfs/api/list")
    Observable<PhotoModel> getPhotoList(@Query("id") int id, @Query("page") int page, @Query("rows") int rows);


//    @GET("api/data/福利/10/{page}")
//    Observable<PhotoModel> getPhotoList(@Path("page") int page);

}
