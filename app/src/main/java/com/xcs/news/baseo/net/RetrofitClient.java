package com.xcs.news.baseo.net;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.xcs.news.baseo.entity.BackBodyEntity;
import com.xcs.news.baseo.entity.HttpResult;
import com.xcs.news.baseo.entity.OpenCaiDataBean;
import com.xcs.news.baseo.entity.OpenCaiHttpResult;
import com.xcs.news.baseo.entity.ResultData;
import com.xcs.news.baseo.utils.VersionResutl;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 2018.05.17
 */
public class RetrofitClient {
//
    private static final int DEFAULT_TIMEOUT = 5;

    private ApiService apiService;

    private OkHttpClient okHttpClient;

    public static String baseUrl = ApiService.Base_URL;

    //private static Context mContext;

    private static RetrofitClient sNewInstance;

    private static class SingletonHolder {
        private static RetrofitClient INSTANCE = new RetrofitClient();
    }

//    public static RetrofitClient getInstance(Context context) {
//        if (context != null) {
//         //   Log.v("RetrofitClient", DevUtil.isDebug() + "");
//            mContext = context;
//        }
//        return SingletonHolder.INSTANCE;
//    }


    public static RetrofitClient getInstance(String url) {
//        if (context != null) {
//            mContext = context;
//        }
        sNewInstance = new RetrofitClient(url);
        return sNewInstance;
    }

    private RetrofitClient() {
    }

    private RetrofitClient(String url) {

        if (TextUtils.isEmpty(url)) {
            url = baseUrl;
        }
        okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
        apiService = retrofit.create(ApiService.class);
    }

    public ApiService getApiService() {
        return apiService;
    }

    public void getJumpUrl(String apkName, String platform, Callback<HttpResult<ResultData>> callback) {
        apiService.getJumpUrl(apkName, platform).enqueue(callback);
    }

    public void getCZInfo(String endstr,Callback<OpenCaiHttpResult<OpenCaiDataBean>> callback) {
        apiService.getCZInfo(endstr).enqueue(callback);
    }

    public void checkVersion(String apkName, String platform,String version, Callback<VersionResutl> callback) {
        apiService.checkVersion(apkName, platform,version).enqueue(callback);
    }

}
