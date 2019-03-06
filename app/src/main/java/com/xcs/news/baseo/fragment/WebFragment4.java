package com.xcs.news.baseo.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.xcs.news.baseo.R;


/**
 * Date：2018/3/25 on 下午5:41
 * Describe:
 * Created by:stefan
 */
public class WebFragment4 extends Fragment {
    public static WebFragment4 newInstance(String url) {
        Bundle args = new Bundle();
        args.putString("url", url);
        WebFragment4 fragment = new WebFragment4();
        fragment.setArguments(args);
        return fragment;
    }

    private static String TAG = WebFragment4.class.getName();
    private View view;
    private WebView webview;
    private String url;
    private ProgressDialog progressDialog;
    private TextView tv_title;
    private boolean fig;
    private String[] adDivsid = new String[]{"tabDiv", "headbar", "uiHead", "ui-head", "icon icon-prev", "tabs-link"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_webb, container, false);
        Log.d(TAG,"-=onCreateView=--");
        webview = view.findViewById(R.id.webview);
        Bundle bundle = getArguments();
        url = bundle.getString("url");
        fig = bundle.getBoolean("fig");
        webview.loadUrl(url);
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("正在加载");
        webview.setWebViewClient(new WebViewClient() {

            @Override
            public void onLoadResource(WebView view, String url) {
                String js = getClearAdDivJs(getActivity());
                Log.v("adJs", js);
                view.loadUrl(js); //加载js方法代码
                view.loadUrl("javascript:hideAd();"); //调用js方法
                excuteJsCode(view);//hyp add
                super.onLoadResource(view, url);

            }

//            private void gotoSkill(String fileName) {
//                Bundle bundle = new Bundle();
//                bundle.putInt("type", 5);
//                bundle.putString("url", fileName);
//                CommonActivity.launch(getActivity(), bundle, "");
//            }

//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                gotoSkill(url);
//                return true;
//            }

            @Override
            public void onPageStarted(final WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                if (progressDialog != null) {
                    progressDialog.show();
                }


            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (progressDialog != null) {
                    progressDialog.dismiss();
                }
                excuteJsCode(view);//hyp add
            }

            public String getClearAdDivJs(Context context) {
                String js = "javascript:function hideAd() {";
                //id
                for (int i = 0; i < adDivsid.length; i++) {
                    js += "var adDivsid" + i + "= document.getElementById('" + adDivsid[i] + "');if(adDivsid" + i + " != null)adDivsid" + i + ".parentNode.removeChild(adDivsid" + i + ");";

                }


                for (int i = 0; i < adDivsid.length; i++)

                {
                    //通过div的id属性删除div元素
                    //通过div的class属性隐藏div元素
                    js += "var adDiv" + i + "= document.getElementsByClassName('" + adDivsid[i] + "');if(adDiv" + i + " != null)" +
                            "{var x; for (x = 0; x < adDiv" + i + ".length; x++) {adDiv" + i + "[x].style.display='none';}}";
                }

                js += "}";


                return js;
            }

        });

        setWebSettings();
        return view;
    }

    //////////////hyp add 5 26//////////////////////
    private void js(WebView view) {

        view.loadUrl("javascript:function hideFooter(){var footer = document.getElementById('footer');footer.style.display='none';" +
                "var notice = document.getElementById('notice_box');notice.style.display='none';" +
                //              "var hea = document.getElementByTag('header')[0];hea.style.display='none';" +
                "var xgwz = document.getElementsByClassName('xgwz')[0];xgwz.style.display='none';" +
                "var dgfff = document.getElementsByClassName('dgfff')[0];dgfff.style.display='none';" +
                "var kj = document.getElementsByClassName('tzds_game')[0];kj.style.display='none';}");
        view.loadUrl("javascript:hideFooter();");
    }

    private void excuteJsCode(WebView view) {
        view.loadUrl("javascript:function hideFooter(){var footer = document.getElementById('footer');footer.style.display='none';}");
        view.loadUrl("javascript:hideFooter()");
        view.loadUrl("javascript:function hideFooter1(){var notice = document.getElementById('notice_box');notice.style.display='none';}");
        view.loadUrl("javascript:hideFooter1()");
        view.loadUrl("javascript:function hideFooter2(){var hea = document.getElementById('header');hea.style.display='none';}");
        view.loadUrl("javascript:hideFooter2()");
        view.loadUrl("javascript:function hideFooter3(){var hea = document.getElementByTag('header')[0];hea.style.display='none';}");
        view.loadUrl("javascript:hideFooter3()");
        view.loadUrl("javascript:function hideFooter4(){var xgwz = document.getElementsByClassName('xgwz')[0];xgwz.style.display='none';}");
        view.loadUrl("javascript:hideFooter4()");
        view.loadUrl("javascript:function hideFooter5(){var dgfff = document.getElementsByClassName('dgfff')[0];dgfff.style.display='none';}");
        view.loadUrl("javascript:hideFooter5()");
        view.loadUrl("javascript:function hideFooter6(){var kj = document.getElementsByClassName('tzds_game')[0];kj.style.display='none';}");
        view.loadUrl("javascript:hideFooter6()");
        view.loadUrl("javascript:function hideFooter7(){var footer = document.getElementById('hd');footer.style.display='none';}");
        view.loadUrl("javascript:hideFooter7()");
        view.loadUrl("javascript:function hideFooter8(){var kj = document.getElementsByClassName('wp hm mtm noprint')[0];kj.style.display='none';}");
        view.loadUrl("javascript:hideFooter8()");
        view.loadUrl("javascript:function hideFooter9(){var footer = document.getElementById('ft');footer.style.display='none';}");
        view.loadUrl("javascript:hideFooter9()");
        view.loadUrl("javascript:function hideFooter10(){var kj = document.getElementsByClassName('wp cl')[0];kj.style.display='none';}");
        view.loadUrl("javascript:hideFooter10()");
        view.loadUrl("javascript:function hideFooter11(){var footer = document.getElementById('link');footer.style.display='none';}");
        view.loadUrl("javascript:hideFooter11()");
        view.loadUrl("javascript:function hideFooter12(){var footer = document.getElementById('copyright');footer.style.display='none';}");
        view.loadUrl("javascript:hideFooter12()");
        view.loadUrl("javascript:function hideFooter13(){var footer = document.getElementById('top');footer.style.display='none';}");
        view.loadUrl("javascript:hideFooter13()");
        view.loadUrl("javascript:function hideFooter14(){var footer = document.getElementById('nav');footer.style.display='none';}");
        view.loadUrl("javascript:hideFooter14()");
        view.loadUrl("javascript:function hideFooter15(){var footer = document.getElementById('topNav');footer.style.display='none';}");
        view.loadUrl("javascript:hideFooter15()");
        view.loadUrl("javascript:function hideFooter16(){var footer = document.getElementById('docHead');footer.style.display='none';}");
        view.loadUrl("javascript:hideFooter16()");
        view.loadUrl("javascript:function hideFooter17(){var kj = document.getElementsByClassName('hot_block seohot_block clearfix')[0];kj.style.display='none';}");
        view.loadUrl("javascript:hideFooter17()");
        view.loadUrl("javascript:function hideFooter18(){var footer = document.getElementById('docFoot');footer.style.display='none';}");
        view.loadUrl("javascript:hideFooter18()");
    }

    ////////////////hyp add 2018 5 26/////////////////
    private void setWebSettings() {
        WebSettings webSettings = webview.getSettings();
        webSettings.setJavaScriptEnabled(true);

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

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"-=onResume=--");
    }
}
