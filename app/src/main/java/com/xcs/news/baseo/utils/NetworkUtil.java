package com.xcs.news.baseo.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Date：2018/3/10 on 下午2:20
 * Describe:
 * Created by:stefan
 */
public class NetworkUtil {
    public  static  boolean isNetworkAvailable(Context context){
      ConnectivityManager manager = (ConnectivityManager) context
                .getApplicationContext().getSystemService(
                        Context.CONNECTIVITY_SERVICE);
        if (manager==null){
            return  false;
        }
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();
        if (networkInfo==null||!networkInfo.isAvailable()){
            return  false;
        }
        return  true;

    }
}
