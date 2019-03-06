package com.xcs.news.baseo;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.xcs.news.baseo.utils.SharePreferenceUtil;

import cn.jpush.android.api.JPushInterface;

public class MyApp extends Application {
    private static Context myAppContext;
    private static boolean canAddQQ = false;
    @Override
    public void onCreate() {
        super.onCreate();
        myAppContext=this;
        JPushInterface.setDebugMode(true); // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this); // 初始化 JPush

    }

    public static int getLocalVersion(Context ctx) {
        int localVersion = 1;
        try {
            PackageInfo packageInfo = ctx.getApplicationContext()
                    .getPackageManager()
                    .getPackageInfo(ctx.getPackageName(), 0);
            localVersion = packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return localVersion;
    }

    public static Context getMyAppContext() {
        return myAppContext;
    }

    public static boolean isCanAddQQ() {
        return canAddQQ;
    }

    public static void setCanAddQQ(boolean canAddQQ) {
        MyApp.canAddQQ = canAddQQ;
    }
}
