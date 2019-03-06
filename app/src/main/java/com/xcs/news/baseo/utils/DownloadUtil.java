package com.xcs.news.baseo.utils;

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
import android.os.Environment;
import android.os.Handler;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.xcs.news.baseo.activity.AndroidOPermissionActivity;

import java.io.File;
import java.lang.ref.WeakReference;

public class DownloadUtil {
    private static final String TAG = "DownloadUtil";
    private WeakReference<Activity> weakReference;
    private final DownloadManager downloadManager;
    private final DownloadChangeObserver downloadChangeObserver;
    private final DownloadReceiver downloadReceiver;
    private OnUpdateListener onUpdateListener;
    private long requestId;

    public DownloadUtil(Activity activity) {
        weakReference = new WeakReference<Activity>(activity);
        downloadManager = (DownloadManager) weakReference.get().getSystemService(Context.DOWNLOAD_SERVICE);
        downloadChangeObserver = new DownloadChangeObserver(new Handler());
        downloadReceiver = new DownloadReceiver();
    }

    public void setUpdateListener(OnUpdateListener onUpdateListener) {
        this.onUpdateListener = onUpdateListener;
        Log.e(TAG, "setUpdateListener: 设置监听 ==== ");
    }

    public void downloadApk(String apkUrl, String title, String desc) {
        Log.e(TAG, "downloadApk: 进入下载 ==== ");
        File apkFile = new File(weakReference.get().
                getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "app_name.apk");

        if (apkFile.exists()) {
            apkFile.delete();
        }

        DownloadManager.Request request = new DownloadManager.Request(Uri.parse(apkUrl));
        //标题
        request.setTitle(title);
        //描述
        request.setDescription(desc);
        //通知
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        request.setDestinationInExternalFilesDir(weakReference.get(),
                Environment.DIRECTORY_DOWNLOADS, "标题.apk");
        //指定下载到SD卡的/download/my/目录下
//         request.setDestinationInExternalPublicDir("/download/","标题.apk");
        request.setMimeType("application/vnd.android.package-archive");
        requestId = downloadManager.enqueue(request);
    }

    /**
     * 取消下载
     */
    public void cancel() {
        downloadManager.remove(requestId);
    }

    /**
     * 对应 {@link Activity }
     */
    public void resume() {
        //设置监听Uri.parse("content://downloads/my_downloads")
        weakReference.get().getContentResolver()
                .registerContentObserver(Uri.parse("content://downloads/my_downloads"),
                        true, downloadChangeObserver);
        // 注册广播，监听APK是否下载完成
        weakReference.get().registerReceiver(downloadReceiver,
                new IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE));
    }

    /**
     * 对应{@link Activity#onPause()} ()}
     */
    public void onPause() {
        weakReference.get().getContentResolver().unregisterContentObserver(downloadChangeObserver);
        weakReference.get().unregisterReceiver(downloadReceiver);
    }

    class DownloadChangeObserver extends ContentObserver {

        /**
         * Creates a content observer.
         *
         * @param handler The handler to run {@link #onChange} on, or null if none.
         */
        public DownloadChangeObserver(Handler handler) {
            super(handler);
        }

        @Override
        public void onChange(boolean selfChange) {
            super.onChange(selfChange);
            updateView();
        }
    }

    private void updateView() {
        int[] bytesAndStatus = new int[]{0, 0, 0};
        DownloadManager.Query query = new DownloadManager.Query().setFilterById(requestId);
        Cursor c = null;
        try {
            c = downloadManager.query(query);
            if (c != null && c.moveToFirst()) {
                //已经下载的字节数
                bytesAndStatus[0] = c.getInt(c.getColumnIndexOrThrow(DownloadManager.COLUMN_BYTES_DOWNLOADED_SO_FAR));
                //总需下载的字节数
                bytesAndStatus[1] = c.getInt(c.getColumnIndexOrThrow(DownloadManager.COLUMN_TOTAL_SIZE_BYTES));
                //状态所在的列索引
                bytesAndStatus[2] = c.getInt(c.getColumnIndex(DownloadManager.COLUMN_STATUS));
            }
        } finally {
            if (c != null) {
                c.close();
            }
        }

        if (onUpdateListener != null) {
            onUpdateListener.update(bytesAndStatus[0], bytesAndStatus[1]);
        }

        Log.e(TAG, "下载进度：" + bytesAndStatus[0] + "/" + bytesAndStatus[1] + "");
    }

    class DownloadReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(final Context context, final Intent intent) {
            boolean haveInstallPermission;
            // 兼容Android 8.0
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                //先获取是否有安装未知来源应用的权限
                haveInstallPermission = context.getPackageManager().canRequestPackageInstalls();
                if (!haveInstallPermission) {//没有权限
                    // 弹窗，并去设置页面授权
                    final AndroidOInstallPermissionListener listener = new AndroidOInstallPermissionListener() {
                        @Override
                        public void permissionSuccess() {
                            installApk(context, intent);
                        }

                        @Override
                        public void permissionFail() {
                            Toast.makeText(context, "授权失败，无法安装应用", Toast.LENGTH_SHORT).show();
                        }
                    };

                    AndroidOPermissionActivity.sListener = listener;
                    Intent intent1 = new Intent(context, AndroidOPermissionActivity.class);
                    context.startActivity(intent1);


                } else {
                    installApk(context, intent);
                }
            } else {
                installApk(context, intent);
            }

        }
    }

    public interface OnUpdateListener {
        void update(int currentByte, int totalByte);
    }

    /**
     * @param context
     * @param intent
     */
    private void installApk(Context context, Intent intent) {
        long completeDownLoadId = intent.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1);
        Log.e(TAG, "installApk: 收到广播");
        Uri uri = null;
        Intent intentInstall = new Intent();
        intentInstall.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intentInstall.setAction(Intent.ACTION_VIEW);

        if (completeDownLoadId == requestId) {
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) { // 6.0以下
                uri = downloadManager.getUriForDownloadedFile(completeDownLoadId);
            } else if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) { // 6.0 - 7.0
                File apkFile = queryDownloadedApk(context, completeDownLoadId);
                uri = Uri.fromFile(apkFile);
            } else { // Android 7.0 以上
                uri = FileProvider.getUriForFile(context,
                        "com.xcs.news.base.fileProvider",
                        new File(context.getExternalFilesDir(Environment.DIRECTORY_DOWNLOADS), "标题.apk"));
                intentInstall.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION | Intent.FLAG_GRANT_WRITE_URI_PERMISSION);
            }

            // 安装应用
            Log.e(TAG, "installApk: 下载完成了");

            intentInstall.setDataAndType(uri, "application/vnd.android.package-archive");
            context.startActivity(intentInstall);
        }
    }

    //通过downLoadId查询下载的apk，解决6.0以后安装的问题
    public static File queryDownloadedApk(Context context, long downloadId) {
        File targetApkFile = null;
        DownloadManager downloader = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);

        if (downloadId != -1) {
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(downloadId);
            query.setFilterByStatus(DownloadManager.STATUS_SUCCESSFUL);
            Cursor cur = downloader.query(query);
            if (cur != null) {
                if (cur.moveToFirst()) {
                    String uriString = cur.getString(cur.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI));
                    if (!TextUtils.isEmpty(uriString)) {
                        targetApkFile = new File(Uri.parse(uriString).getPath());
                    }
                }
                cur.close();
            }
        }
        return targetApkFile;
    }

    public interface AndroidOInstallPermissionListener {
        void permissionSuccess();

        void permissionFail();
    }
}
