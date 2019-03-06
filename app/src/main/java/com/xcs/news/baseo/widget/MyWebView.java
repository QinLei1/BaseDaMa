package com.xcs.news.baseo.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;


/**
 * Date：2018/3/15 on 下午12:38
 * Describe:
 * Created by:stefan
 */
public class MyWebView extends WebView {
    private final Context context;
    private ProgressView progressView;//进度条

    public MyWebView(Context context) {
        this(context, null);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        init();
//        this(context, attrs, 0);
    }

//    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        this.context = context;
//        init();
//    }
public static int dp2px(Context context, float dpValue) {
    return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, context.getResources().getDisplayMetrics());
}
    private void init() {
        //初始化进度条
        progressView = new ProgressView(context);
        progressView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dp2px(context, 4)));
        progressView.setProgress(10);
        //把进度条加到Webview中
        addView(progressView);
        setWebChromeClient(new MyWebCromeClient());
    }

    private class MyWebCromeClient extends WebChromeClient {
        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            if (newProgress == 100) {
                //加载完毕进度条消失
                progressView.setVisibility(View.GONE);
            } else {
                //更新进度
                progressView.setProgress(newProgress);
            }
            super.onProgressChanged(view, newProgress);
        }
    }

    public void setWebSettings(Context context) {
        //声明WebSettings子类
        WebSettings webSettings = this.getSettings();

//如果访问的页面中要与Javascript交互，则webview必须设置支持Javascript
        webSettings.setJavaScriptEnabled(true);
//        webSettings.setAppCachePath();
// 若加载的 html 里有JS 在执行动画等操作，会造成资源浪费（CPU、电量）
// 在 onStop 和 onResume 里分别把 setJavaScriptEnabled() 给设置成 false 和 true 即可


//设置自适应屏幕，两者合用
        webSettings.setUseWideViewPort(true); //将图片调整到适合webview的大小
        webSettings.setLoadWithOverviewMode(true); // 缩放至屏幕的大小

//缩放操作
        webSettings.setSupportZoom(true); //支持缩放，默认为true。是下面那个的前提。
        webSettings.setBuiltInZoomControls(true); //设置内置的缩放控件。若为false，则该WebView不可缩放
        webSettings.setDisplayZoomControls(false);
        //隐藏原生的缩放控件

        webSettings.setDomStorageEnabled(true);    //开启DOM形式存储
        webSettings.setSavePassword(true);
        webSettings.setDatabaseEnabled(true);   //开启数据库形式存储

        String appCacheDir = context.getApplicationContext().getDir("cache", Context.MODE_PRIVATE).getPath();   //缓存数据的存储地址

        webSettings.setAppCachePath(appCacheDir);

        webSettings.setAppCacheEnabled(true);  //开启缓存功能

        webSettings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);      //缓存模式


//其他细节操作
        webSettings.setAllowFileAccess(true); //设置可以访问文件
        webSettings.setJavaScriptCanOpenWindowsAutomatically(true); //支持通过JS打开新窗口
        webSettings.setLoadsImagesAutomatically(true); //支持自动加载图片
        webSettings.setDefaultTextEncodingName("utf-8");//设置编码格式
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        //如果访问的页面中有Javascript，则webview必须设置支持Javascript

//        webSettings.setUserAgentString(MyApplication.getUserAgent());
        webSettings.setSaveFormData(true);
    }


}
