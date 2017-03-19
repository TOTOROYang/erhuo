package com.htu.erhuo.network.api;

import com.htu.erhuo.entity.EntityResponse;
import com.htu.erhuo.entity.ErhuoOssToken;
import com.htu.erhuo.entity.MovieEntity;
import com.htu.erhuo.entity.UserInfo;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Description
 * Created by yzw on 2017/2/13.
 */

public interface Api {

    @GET("top250")
    Observable<MovieEntity> getTopMovie(@Query("start") int start, @Query("count") int count);

    @POST("user/login")
    Observable<EntityResponse> login(@Body UserInfo userInfo);

    @GET("user/{account}")
    @Headers("token:need")
    Observable<EntityResponse<UserInfo>> getUserInfo(@Path("account") String account);

    @POST("user/{account}")
    @Headers("token:need")
    Observable<EntityResponse> setUserInfo(@Path("account") String account, @Body UserInfo userInfo);

    @GET("sts/img/{key}")
    @Headers("token:need")
    Observable<EntityResponse<ErhuoOssToken>> getOssToken(@Path("key") String key);

}
