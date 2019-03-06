package com.xcs.news.baseo.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.TextView;

//import com.allenliu.versionchecklib.v2.AllenVersionChecker;
//import com.allenliu.versionchecklib.v2.builder.DownloadBuilder;
//import com.allenliu.versionchecklib.v2.builder.NotificationBuilder;
//import com.allenliu.versionchecklib.v2.builder.UIData;
//import com.allenliu.versionchecklib.v2.callback.CustomVersionDialogListener;
import com.xcs.news.baseo.R;
import com.xcs.news.baseo.base.BaseDialog;


/**
 * Date：2018/2/5 on 下午4:28
 * Describe:
 * Created by:stefan
 */
public class UpdateUtils {
//    public static DownloadBuilder builder;
//    /**
//     * @return
//     * @important 使用请求版本功能，可以在这里设置downloadUrl
//     * 这里可以构造UI需要显示的数据
//     * UIData 内部是一个Bundle
//     */
//    private static UIData crateUIData(Context context, String path) {
//        UIData uiData = UIData.create();
//        uiData.setTitle(context.getResources().getString(R.string.app_name)+"升级");
//        uiData.setDownloadUrl(path);
//        uiData.setContent("检测到有新版本，请升级获得更好的体验！已经有99%到用户选择了升级。");
//        return uiData;
//    }
//    private static CustomVersionDialogListener createCustomDialogTwo(boolean fig) {
//        return (context, versionBundle) -> {
//            BaseDialog baseDialog = new BaseDialog(context, R.style.BaseDialog, R.layout.custom_dialog_two_layout);
//            TextView textView = baseDialog.findViewById(R.id.tv_msg);
//            textView.setText(versionBundle.getContent());
//            baseDialog.setCanceledOnTouchOutside(true);
//            baseDialog.setCancelable(false);
//            if (fig){
//                baseDialog.findViewById(R.id.re).setVisibility(View.GONE);
//            }
//
//            return baseDialog;
//        };
//    }
//    private   static NotificationBuilder createCustomNotification(Context context) {
//        return NotificationBuilder.create()
//                .setRingtone(true)
//                .setIcon(R.mipmap.beijing_logo1)
//                .setTicker(context.getResources().getString(R.string.app_name)+"升级");
//    }
//
//    /**
//     *
//     * @param context
//     * @param path
//     * @param fig
//     */
//    public static void getVersion(Context context, String path, boolean fig) {
//
//            builder = AllenVersionChecker
//                    .getInstance()
//                    .downloadOnly(crateUIData(context,path));
//            builder.setCustomVersionDialogListener(createCustomDialogTwo(fig));
//            builder.setNotificationBuilder(createCustomNotification(context));
//            builder.excuteMission(context);
//            builder.setSilentDownload(false); //静默安装
//
//
//    }
//    /**
//     * 获取本地版本号
//     * @return
//     */
//    private  static int getVersionCode(Context context){
//        PackageManager packageManager = context.getPackageManager();
//        int versionCode = 0;
//        try {
//            PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
//            versionCode = packageInfo.versionCode;
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        return versionCode;
//    }
}
