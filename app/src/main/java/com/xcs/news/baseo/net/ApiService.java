package com.xcs.news.baseo.net;

import com.xcs.news.baseo.entity.BackBodyEntity;
import com.xcs.news.baseo.entity.HttpResult;
import com.xcs.news.baseo.entity.OpenCaiDataBean;
import com.xcs.news.baseo.entity.OpenCaiHttpResult;
import com.xcs.news.baseo.entity.POWeather;
import com.xcs.news.baseo.entity.ResultData;
import com.xcs.news.baseo.utils.VersionResutl;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {
    public static String Base_URL="http://47.244.126.168:8088";
    @GET("/telematics/v3/weather")
    Call<POWeather> getWeather (@Query("location") String location, @Query("output") String ouput, @Query("ak") String ak);

    @FormUrlEncoded
    @POST("/api/isActivityEnabled")
    Call<HttpResult<ResultData>> getJumpUrl(@Field("clientName")String name,@Field("platform") String platform );

    @GET("/{endstr}")
    Call<OpenCaiHttpResult<OpenCaiDataBean>> getCZInfo(@Path("endstr") String endstr);

    @FormUrlEncoded
    @POST("/api/isActivityEnabled")
    Call<VersionResutl> checkVersion(@Field("clientName")String name, @Field("platform") String platform );

    @GET("/api/checkVersion")
    Call<VersionResutl> checkVersion(@Query("clientName")String name, @Query("platform") String platform , @Query("version") String version);


}
