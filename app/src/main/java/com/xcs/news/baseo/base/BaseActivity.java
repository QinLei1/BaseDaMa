package com.xcs.news.baseo.base;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import com.xcs.news.baseo.activity.Main_drawer_Activity;

import butterknife.ButterKnife;
import cn.jpush.android.api.JPushInterface;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideContentViewId());
        ButterKnife.bind(this);

        initView();
        initData();
        initListener();
    }
    public void initView() {
    }

    public void initData() {
    }

    public void initListener() {
    }
    //得到当前界面的布局文件id(由子类实现)
    protected abstract int provideContentViewId();
    private long exitTime = 0;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {

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
        return super.onKeyDown(keyCode, event);
    }
    private AlertDialog.Builder builder;
    private AlertDialog alertDialog;
    public void showDiolog(Context context, String content) {
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        if (TextUtils.isEmpty(content)) {
            return;
        }
        builder.setTitle("提示");
        builder.setMessage(content);
        builder.setNegativeButton("忽略", null);
        //利用构造器创建AlertDialog的对象,实现实例化
        alertDialog = builder.create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.show();
    }
}
