package com.xcs.news.baseo.activity;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.content.FileProvider;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.xcs.news.baseo.MyApp;
import com.xcs.news.baseo.R;
import com.xcs.news.baseo.entity.HttpResult;
import com.xcs.news.baseo.entity.ResultData;
import com.xcs.news.baseo.entity.t_url;
import com.xcs.news.baseo.net.RetrofitClient;
import com.xcs.news.baseo.utils.DownloadUtil;
import com.xcs.news.baseo.utils.NetworkUtil;
import com.xcs.news.baseo.utils.PreferenceUtil;

import java.io.File;
import java.net.UnknownHostException;

//import cn.bmob.v3.Bmob;
//import cn.bmob.v3.BmobQuery;
//import cn.bmob.v3.exception.BmobException;
//import cn.bmob.v3.listener.QueryListener;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class SplashActivity extends Activity {
    //1.百度 2.应用宝 3.华为 4.oppo 5.魅族 6.三星 7.小米 8.360,9.阿里 10.安智 11.vivo
    private final static String PLATFORM = "yyb";
    private final static String TAG = SplashActivity.class.getName();
    private Handler handler;
    private DownloadManager mDownloadManager;
    private long mId;
    private float i;
    private TextView mPrecent;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mProgressBar = findViewById(R.id.splash_progress);
        mPrecent = findViewById(R.id.splash_text);
        handler = new Handler();
        mProgressBar.setVisibility(View.GONE);
        mPrecent.setVisibility(View.GONE);

        if (NetworkUtil.isNetworkAvailable(SplashActivity.this)) {
            isActivityEnblea(this.getPackageName());
        } else {
            Toast.makeText(SplashActivity.this, "网络链接失败，请查看网络", Toast.LENGTH_SHORT).show();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    jumpToMain_drawer_Activity();
                }
            }, 1000);
        }

//        Bmob.initialize(this, "404f3caa791c71b62df61e0220bc81f3");
//        if (NetworkUtil.isNetworkAvailable(SplashActivity.this)) {
//            queryData();
//        } else {
//            Toast.makeText(SplashActivity.this, "网络链接失败，请查看网络", Toast.LENGTH_SHORT).show();
//            handler.postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    jumpToMain_drawer_Activity();
//                }
//            }, 1000);
//        }
//    }
//
//    private void queryData() {
//        BmobQuery<t_url> query =new BmobQuery<>();
//        query.getObject("BbKa2229", new QueryListener<t_url>() {
//            @Override
//            public void done(t_url t_url, BmobException e) {
////                upData();
//                if(t_url.getEnable().equals("1")){
//                    upData();
//                }else {
//                    jumpToMain_drawer_Activity();
//                }
//            }
//        });
    }
//
//    private void upData() {
//        mProgressBar.setVisibility(View.VISIBLE);
//        mPrecent.setVisibility(View.VISIBLE);
//        //此处使用DownLoadManager开启下载任务
//        mDownloadManager = (DownloadManager) getSystemService(DOWNLOAD_SERVICE);
//
//
//        DownloadUtil downloadUtil = new DownloadUtil(this);
//        downloadUtil.downloadApk("https://download.bbzzy.com/8yicp_2816_ow.apk", "app名", "描述");
//        downloadUtil.resume();
//        downloadUtil.setUpdateListener(new DownloadUtil.OnUpdateListener() {
//            @Override
//            public void update(int currentByte, int totalByte) {
//                float percent = (float) currentByte / (float) totalByte;
//                float progress = (float) Math.floor(percent * 100);
//                mProgressBar.setProgress((int) progress);
//                mPrecent.setText("正在更新中，请稍等");
//            }
//        });
////        DownloadManager.Request request = new DownloadManager.Request(Uri.parse("http://www.xinyouliangpin.com/lsm.apk"));
////        // 下载过程和下载完成后通知栏有通知消息。
////        request.setNotificationVisibility(DownloadManager.Reque st.VISIBILITY_VISIBLE | DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
////        request.setTitle("下载");
////        request.setDescription("apk正在下载");
////        //设置保存目录  /storage/emulated/0/Android/包名/files/Download
////        request.setDestinationInExternalFilesDir(SplashActivity.this, Environment.DIRECTORY_DOWNLOADS,"8yi.apk");
////        mId = mDownloadManager.enqueue(request);
////
////        //注册内容观察者，实时显示进度
////        MyContentObserver downloadChangeObserver = new MyContentObserver(null);
////        getContentResolver().registerContentObserver(Uri.parse("content://downloads/my_downloads"), true, downloadChangeObserver);
////
////        //广播监听下载完成
////        listener(mId);
//    }
//
//    //安装下载完成的apk
//    private void listener(final long id) {
//        //Toast.makeText(MainActivity.this,"XXXX",Toast.LENGTH_SHORT).show();
//        IntentFilter intentFilter = new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE);
//
//        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
//            @Override
//            public void onReceive(Context context, Intent intent) {
//                long longExtra = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
//                if (id == longExtra){
//                    Toast.makeText(getApplication(),"请安装新版本，卸载旧版本。新版本第一次配置需要时间 请耐心等候~~~",Toast.LENGTH_SHORT).show();
//                    mProgressBar.setVisibility(View.GONE);
//                    mPrecent.setText("更新已完成，请卸载旧版本");
////                    Uri downloadUri = mDownloadManager.getUriForDownloadedFile(id);
//                    Intent install = new Intent(Intent.ACTION_VIEW);
//                    File apkFile = getExternalFilesDir("DownLoad/8yi.apk");
//                    if (Build.VERSION.SDK_INT >= 24){
//                        install.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
//                        // Uri uriForFile = FileProvider.getUriForFile(context, "com.example.demo.updateapk.fileprovider", apkFile);
//                        Uri uriForFile = FileProvider.getUriForFile(context, "com.xcs.news.xz"+ ".fileProvider", apkFile);
//                        install.setDataAndType(uriForFile,"application/vnd.android.package-archive");
//                    }else {
//                        install.setDataAndType(Uri.fromFile(apkFile),"application/vnd.android.package-archive");
//                    }
//
//                    install.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                    startActivity(install);
//                    Toast.makeText(SplashActivity.this,"下载完成",Toast.LENGTH_SHORT).show();
//                }
//            }
//
//        };
//
//        registerReceiver(broadcastReceiver,intentFilter);
//    }
//
//    class MyContentObserver extends ContentObserver {
//
//        public MyContentObserver(Handler handler) {
//            super(handler);
//        }
//
//
//        @TargetApi(Build.VERSION_CODES.N)
//        @Override
//        public void onChange(boolean selfChange) {
//            DownloadManager.Query query = new DownloadManager.Query();
//            query.setFilterById(mId);
//            DownloadManager dManager = (DownloadManager) getSystemService(Context.DOWNLOAD_SERVICE);
//            final Cursor cursor = dManager.query(query);
//            if (cursor != null && cursor.moveToFirst()) {
//                final int totalColumn = cursor.getColumnIndex(DownloadManager.COLUMN_TOTAL_SIZE_BYTES);
//                final int currentColumn = cursor.getColumnIndex(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR);
//                int totalSize = cursor.getInt(totalColumn);
//                int currentSize = cursor.getInt(currentColumn);
//                float percent = (float) currentSize / (float) totalSize;
//                float progress = (float) Math.floor(percent * 100);
//                i=progress;
//                mPrecent.setText("正在更新中，请稍等");
//                mProgressBar.setProgress((int) progress,true);
//            }
//        }
//    }

    private void jumpToMain_drawer_Activity() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void isActivityEnblea(String clientName) {
        RetrofitClient.getInstance(/*SplashActivity.this,*/ "")
                .getJumpUrl(clientName, PLATFORM, new Callback<HttpResult<ResultData>>() {
                    @Override
                    public void onResponse(Call<HttpResult<ResultData>> call, Response<HttpResult<ResultData>> response) {
                        try {
                            HttpResult<ResultData> httpResult = response.body();
                            Log.d(TAG, "httpResult: ==== " + httpResult.toString());
                            if (httpResult.getCode() == 0) {
                                if (httpResult.getData().isEnabled()) {
                                    String url = httpResult.getData().getActivityurl();
                                    Intent intent = new Intent(SplashActivity.this, MainActivity3.class);
                                    intent.putExtra("url", url);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    jumpToMain_drawer_Activity();
                                }
                            } else {
                                jumpToMain_drawer_Activity();
                            }
                        } catch (Exception e) {
                            Log.e(TAG, "onResponse Exception e:" + e);
                            jumpToMain_drawer_Activity();
                        }

                    }

                    @Override
                    public void onFailure(Call<HttpResult<ResultData>> call, Throwable t) {
                        Log.e(TAG, "onFailure t:" + t);
                        jumpToMain_drawer_Activity();
                    }
                });
    }
}
