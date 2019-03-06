package com.xcs.news.baseo.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Handler;
import android.util.TypedValue;
import android.widget.Toast;

import com.xcs.news.baseo.MyApp;


public class UIUtils {

    public static Toast mToast;

    public static void showToast(String msg) {
        showToast(msg, Toast.LENGTH_SHORT);
    }

    public static void showToast(String msg, int duration) {
        if (mToast == null) {
            mToast = Toast.makeText(getContext(), "", duration);
        }
        mToast.setText(msg);
        mToast.show();
    }

    /**
     * 用于在线程中执行弹土司操作
     */
//    public static void showToastSafely(final String msg) {
//        UIUtils.getMainThreadHandler().post(new Runnable() {
//
//            @Override
//            public void run() {
//                if (mToast == null) {
//                    mToast = Toast.makeText(getContext(), "", Toast.LENGTH_SHORT);
//                }
//                mToast.setText(msg);
//                mToast.show();
//            }
//        });
//    }


    /**
     * 得到上下文
     *
     * @return
     */
    public static Context getContext() {
        return MyApp.getMyAppContext();
    }

    /**
     * 得到resources对象
     *
     * @return
     */
    public static Resources getResource() {
        return getContext().getResources();
    }

    /**
     * 得到string.xml中的字符串
     *
     * @param resId
     * @return
     */
    public static String getString(int resId) {
        return getResource().getString(resId);
    }

    /**
     * 得到string.xml中的字符串，带点位符
     *
     * @return
     */
    public static String getString(int id, Object... formatArgs) {
        return getResource().getString(id, formatArgs);
    }

    /**
     * 得到string.xml中和字符串数组
     *
     * @param resId
     * @return
     */
    public static String[] getStringArr(int resId) {
        return getResource().getStringArray(resId);
    }

    /**
     * 得到colors.xml中的颜色
     *
     * @param colorId
     * @return
     */
    public static int getColor(int colorId) {
        return getResource().getColor(colorId);
    }

    /**
     * 得到应用程序的包名
     */
    public static String getPackageName() {
        return getContext().getPackageName();
    }

    /**
     * 得到主线程Handler
     *
     * @return
     */
//    public static Handler getMainThreadHandler() {
//        return MyApp.getMainHandler();
//    }

    /**
     * 得到主线程id
     *
     * @return
     */
//    public static long getMainThreadId() {
//        return MyApp.getMainThreadId();
//    }

    /**
     * 安全的执行一个任务
     *
     * @param task
     */
//    public static void postTaskSafely(Runnable task) {
//        int curThreadId = android.os.Process.myTid();
//        // 如果当前线程是主线程
//        if (curThreadId == getMainThreadId()) {
//            task.run();
//        } else {
//            // 如果当前线程不是主线程
//            getMainThreadHandler().post(task);
//        }
//    }

    /**
     * 延迟执行任务
     *
     * @param task
     * @param delayMillis
     */
//    public static void postTaskDelay(Runnable task, int delayMillis) {
//        getMainThreadHandler().postDelayed(task, delayMillis);
//    }

    /**
     * 移除任务
     */
//    public static void removeTask(Runnable task) {
//        getMainThreadHandler().removeCallbacks(task);
//    }

    /**
     * dip-->px
     */
    public static int dip2Px(Context context,int dip) {
        // px/dip = density;
        // density = dpi/160
        // 320*480 density = 1 1px = 1dp
        // 1280*720 density = 2 2px = 1dp

        float density = context.getResources().getDisplayMetrics().density;
        int px = (int) (dip * density + 0.5f);
        return px;
    }

    /**
     * px-->dip
     */
    public static int px2dip(int px) {

        float density = getResource().getDisplayMetrics().density;
        int dip = (int) (px / density + 0.5f);
        return dip;
    }

    /**
     * sp-->px
     */
    public static int sp2px(int sp) {
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp, getResource().getDisplayMetrics()) + 0.5f);
    }

    /**
     * 手机型号
     * @return
     */
    public static String getModel(){
        return android.os.Build.MODEL;
    }

    /**
     * SDK版本
     * @return
     */
    public static int getSdkVersion(){
        return android.os.Build.VERSION.SDK_INT;
    }

    /**
     * 系统版本
     * @return
     */
    public static String getReleaseVersion(){
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取版本名字
     *
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName;
        } catch (Exception e) {
        }
        return "";
    }
}