package com.xcs.news.baseo.activity;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


import com.xcs.news.baseo.R;
import com.xcs.news.baseo.widget.ProgressWebView;
import com.yw.game.floatmenu.FloatItem;
import com.yw.game.floatmenu.FloatLogoMenu;
import com.yw.game.floatmenu.FloatMenuView;


import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {
    private static String  TAG=MainActivity3.class.getName();
    private String url;
    private String HOME = "首页";
    private String GO = "前进";
    private String BACK = "后退";
    private String REFRESH = "刷新";
     private ArrayList<FloatItem> itemList = new ArrayList<>();
     private String[] MENU_ITEMS;
    private int[] menuIcons;
     private FloatLogoMenu mFloatMenu;
    private ProgressWebView mWebView;
    private long exitTime = 0;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"-onCreate-");
        //  PushAgent.getInstance(this).onAppStart();
        Window window = getWindow();
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色
        window.setStatusBarColor(getResources().getColor(R.color.red));
        setContentView(R.layout.activity_main3);
         menuIcons = new int[]{R.mipmap.a, R.mipmap.b, R.mipmap.cgo, R.mipmap.d};
         MENU_ITEMS = new String[]{REFRESH, GO, BACK, HOME};
        setSuspension();
        mWebView = findViewById(R.id.web_content1);
        url = getIntent().getStringExtra("url");
        mWebView.loadUrl(url);
        checkVersion();
        initView();
    }

    private void setSuspension() {
        for (int i = 0; i < menuIcons.length; i++) {
            itemList.add(new FloatItem(MENU_ITEMS[i], 0x99000000, 0x99000000, BitmapFactory.decodeResource(this.getResources(), menuIcons[i]), String.valueOf(0)));
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"-onResume-");
        if (mFloatMenu == null) {
            mFloatMenu = new FloatLogoMenu.Builder()
                    .withActivity(MainActivity3.this)
//                    .withContext(mActivity.getApplication())//这个在7.0（包括7.0）以上以及大部分7.0以下的国产手机上需要用户授权，需要搭配<uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW"/>
                    .logo(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_facai))
                    .drawCicleMenuBg(true)
//                    .backMenuColor(0xffe4e3e1)
                    .setBgDrawable(this.getResources().getDrawable(R.drawable.yw_game_float_menu_bg))
                    //这个背景色需要和logo的背景色一致
                    .setFloatItems(itemList)
                    .drawRedPointNum(false)
                    .defaultLocation(FloatLogoMenu.RIGHT)
                    .showWithListener(new FloatMenuView.OnMenuClickListener() {
                        @Override
                        public void onItemClick(int position, String title) {
                            switch (position) {
                                case 0:
                                    mWebView.reload();
                                    break;
                                case 1:
                                    if (mWebView.canGoForward()) {
                                        mWebView.goForward();
                                    }
                                    break;
                                case 2:
                                    if (mWebView.canGoBack()) {
                                        mWebView.goBack();
                                    }
                                    break;
                                case 3:
                                    mWebView.loadUrl(url);
                                    break;
                            }
                        }

                        @Override
                        public void dismiss() {

                        }
                    });

        }

    }

    @SuppressLint({"SetJavaScriptEnabled", "JavascriptInterface"})
    private void initView() {
        mWebView.requestFocus();
        mWebView.setHorizontalScrollBarEnabled(false);
        mWebView.setVerticalScrollBarEnabled(false);
        WebSettings web = mWebView.getSettings();
        web.setJavaScriptEnabled(true);
        web.setBuiltInZoomControls(true);
        web.setSupportZoom(true);
        web.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NARROW_COLUMNS);
        web.setUseWideViewPort(true);
        web.setLoadWithOverviewMode(true);
        web.setSavePassword(true);
        web.setSaveFormData(true);
        mWebView.loadUrl(url);
        mWebView.setWebViewClient(new MyWebViewClient());
//        mWebView.setWebChromeClient(new ());
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"-onPause-");
        // hideFloat();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG,"-onDestroy-");
        destroyFloat();
        super.onDestroy();

    }


    public void destroyFloat() {
        if (mFloatMenu != null) {
            mFloatMenu.destoryFloat();
        }
        mFloatMenu = null;

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mWebView.canGoBack()) {
            mWebView.goBack();
            return true;
        } else {
            if ((System.currentTimeMillis() - exitTime) > 2000)  //System.currentTimeMillis()无论何时调用，肯定大于2000
            {
                Toast.makeText(getApplicationContext(), "再按一次退出应用", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        //return super.onKeyDown(keyCode, event);
    }

    private class MyWebViewClient extends WebViewClient {
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }

    }

    private void checkVersion() {
//        RequestParams params = new RequestParams(MyApplication.getAppContext().sharePreferenceUtil.getIp() + "checkVersion");
//        params.addQueryStringParameter("clientName", this.getPackageName());
//        params.addQueryStringParameter("platform", "0");
//        x.http().post(params, new Callback.CommonCallback<String>() {
//            @Override
//            public void onSuccess(String result) {
//                VersionResutl versionResutl = JSON.parseObject(result, VersionResutl.class);
//                if (versionResutl.getCode() == 0) {
//                    if (versionResutl.getData() != null && versionResutl.getData().getUrl() != null) {
//                        UpdateUtils.getVersion(MainActivity.this, versionResutl.getData().getUrl(), versionResutl.getData().isHasnew());
//                    }
//                }
//
//
//            }
//
//            //请求异常后的回调方法
//            @Override
//            public void onError(Throwable ex, boolean isOnCallback) {
//                if (MyApplication.getAppContext().sharePreferenceUtil.getIp().equals("http://www.bx7zc.cc/api/")) {
//                    MyApplication.getAppContext().sharePreferenceUtil.setIp("http://www.e9a6s.cc/api/");
//                } else if (MyApplication.getAppContext().sharePreferenceUtil.getIp().equals("http://www.e9a6s.cc/api/")) {
//                    MyApplication.getAppContext().sharePreferenceUtil.setIp("http://www.ytpaf.cc/api/");
//                } else if (MyApplication.getAppContext().sharePreferenceUtil.getIp().equals("http://www.ytpaf.cc/api/")) {
//                    MyApplication.getAppContext().sharePreferenceUtil.setIp("http://www.zokp0.cx/api/");
//                }
//
//            }
//
//            //主动调用取消请求的回调方法
//            @Override
//            public void onCancelled(CancelledException cex) {
//
//            }
//
//            @Override
//            public void onFinished() {
//            }
//        });
    }


}
