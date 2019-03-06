package com.xcs.news.baseo.api;
import android.text.TextUtils;

import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
//import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
//import retrofit2.converter.gson.GsonConverterFactory;
//import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * @author ChayChan
 * @date 2017/6/10  10:54
 */

public class ApiRetrofit {

    private static ApiRetrofit mApiRetrofit;
//    private Retrofit mRetrofit;
    private OkHttpClient mClient;
    private ApiService mApiService;
    public static final String BASE_SERVER_URL = "http://m.zhcw.com/";
    public ApiRetrofit() {
    }
    public static ApiRetrofit getInstance() {
        return ApiRetrofit.getInstance(null);
    }
    public ApiRetrofit(String baseUrl) {
        mClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();

//        mRetrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .addConverterFactory(ScalarsConverterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RxJava
//                .client(mClient)
//                .build();
//
//        mApiService = mRetrofit.create(ApiService.class);
    }

    public static ApiRetrofit getInstance(String baseUrl) {

        if(TextUtils.isEmpty(baseUrl)){
            baseUrl = BASE_SERVER_URL;
        }
        if (mApiRetrofit == null) {
            synchronized (Object.class) {
                if (mApiRetrofit == null) {
                    mApiRetrofit = new ApiRetrofit(baseUrl);
                }
            }
        }
        return mApiRetrofit;
    }

    public ApiService getApiService() {
        return mApiService;
    }
}
