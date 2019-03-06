package com.xcs.news.baseo.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.base.BaseActivity;
import com.xcs.news.baseo.fragment.MeFragment;
import com.xcs.news.baseo.fragment.TabLotteryFragment;
import com.xcs.news.baseo.fragment.mj1.Mj1_HomeFragment;

import butterknife.Bind;
import cn.jpush.android.api.JPushInterface;

public class Main_Mj1_Activity extends BaseActivity {

    private String TAG = Main_Mj1_Activity.class.getName();
    private MenuItem menuItem;

    @Bind(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @Bind(R.id.navigation_view)
    NavigationView navigation;
    String[] channels;
    @Bind(R.id.title_tv)
    TextView title_tv;


    @Override
    protected int provideContentViewId() {
        return R.layout.main_mj1_activity_layout;
    }

    @Override
    public void initView() {
        super.initView();
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,
                new Mj1_HomeFragment()).commit();
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initListener() {
        super.initListener();
        navigation.setNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }

    private NavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new NavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.item_news:
                    title_tv.setText(R.string.home);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,
                            new Mj1_HomeFragment()).commit();
                    break;
               /* case R.id.item_lib:
                    title_tv.setText(R.string.lottery);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,
                            Fragment.instantiate(Main_Mj1_Activity.this, LotteryFragment.class.getName())).commit();
                    break;*/
                case R.id.item_find:
                    title_tv.setText(R.string.news);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,
                            Fragment.instantiate(Main_Mj1_Activity.this, TabLotteryFragment.class.getName())).commit();
                    break;
                case R.id.item_more:
                    title_tv.setText(R.string.more);
                    getSupportFragmentManager().beginTransaction().replace(R.id.frame_content,
                            Fragment.instantiate(Main_Mj1_Activity.this, MeFragment.class.getName())).commit();
                    break;
            }
            if (menuItem != null) {
                menuItem.setChecked(false);
            }
            item.setChecked(true);//点击了把它设为选中状态
            menuItem = item;
            mDrawerLayout.closeDrawers();//关闭抽屉
            return true;
        }
    };

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (null != intent) {
            Bundle bundle = intent.getExtras();
            Log.d(TAG, "--onNewIntent--");
            if (bundle != null) {
                String pushInfo = bundle.getString(JPushInterface.EXTRA_ALERT);
                showDiolog(Main_Mj1_Activity.this, pushInfo);
            }

        }
    }
}
