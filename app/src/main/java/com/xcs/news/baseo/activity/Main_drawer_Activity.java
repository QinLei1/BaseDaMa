package com.xcs.news.baseo.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.adapter.ContentAdapter;
import com.xcs.news.baseo.entity.uidata.ContentModel;
import com.xcs.news.baseo.fragment.BaseFragment;
import com.xcs.news.baseo.fragment.HomeFragment;
import com.xcs.news.baseo.fragment.LotteryFragment;
import com.xcs.news.baseo.fragment.MeFragment;
import com.xcs.news.baseo.fragment.TabLotteryFragment;

import cn.jpush.android.api.JPushInterface;


public class Main_drawer_Activity extends FragmentActivity {
    private static final String CURRENT_FRAGMENT = "STATE_FRAGMENT_SHOW";
    private static final String TAG = Main_drawer_Activity.class.getName();
    private DrawerLayout drawerLayout;
    private List<ContentModel> list;
    private ContentAdapter adapter;
    private ImageView leftMenu, rightMenu;
    private ListView listView;
    private TextView title_tv;
    private FragmentManager fm;
    private List<Fragment> fragments = new ArrayList<>();
    private int currentIndex = 0;
    private Fragment currentFragment = new Fragment();
    private String[] title_tvs = new String[]{"首页", "开奖", "资讯", "更多"};
    private AlertDialog alertDialog;
    private AlertDialog.Builder builder;
    private long exitTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "--onCreate--");
        setContentView(R.layout.activity_main_drawer);
        if (getActionBar() != null) {
            getActionBar().hide();
        }

        initView();
        fm = getSupportFragmentManager();
        builder = new AlertDialog.Builder(this);
        /////////////////////
        initFreg(savedInstanceState);
        ////////////////////
        initData();
        adapter = new ContentAdapter(this, list);
        listView.setAdapter(adapter);
        leftMenu.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // FragmentTransaction bt = fm.beginTransaction();
                switch ((int) id) {
                    case 1:
                        //bt.replace(R.id.content, BasePresenterFragment.newInstance("新闻"));
                        Log.d("position:", "点击: " + position);
                        currentIndex = 0;
                        break;
                    case 2:
                        //bt.replace(R.id.content, BasePresenterFragment.newInstance("图片"));
                        Log.d("position:", "点击: " + position);
                        currentIndex = 1;
                        break;
                    case 3:
                        Log.d("position:", "点击: " + position);
                        currentIndex = 2;
                        break;
                    case 4:
                        Log.d("position:", "点击: " + position);
                        currentIndex = 3;
                        break;
                    default:
                        break;
                }
                //	bt.commit();
                title_tv.setText(title_tvs[currentIndex]);
                showFragment();
                drawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
    }

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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "--onDestroy--");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "--onPause--");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "--onResume--");
    }

    private void showDiolog(Context context, String content) {
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

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "--onStart--");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "--onStop--");
    }

    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        leftMenu = (ImageView) findViewById(R.id.leftmenu);
//        rightMenu = (ImageView) findViewById(R.id.rightmenu);
        listView = (ListView) findViewById(R.id.left_listview);
//        rightLayout = (RelativeLayout) findViewById(R.id.right);
        title_tv = (TextView) findViewById(R.id.title_tv);
    }

    private void initFreg(Bundle savedInstanceState) {
        if (savedInstanceState != null) {
            // “内存重启”时调用
            //获取“内存重启”时保存的索引下标
            currentIndex = savedInstanceState.getInt(CURRENT_FRAGMENT, 0);
            //注意，添加顺序要跟下面添加的顺序一样！！！！
            fragments.removeAll(fragments);
            fragments.add(fm.findFragmentByTag(0 + ""));
            fragments.add(fm.findFragmentByTag(1 + ""));
            fragments.add(fm.findFragmentByTag(2 + ""));
            title_tv.setText(title_tvs[currentIndex]);
            //恢复fragment页面
            restoreFragment();
        } else {
            //正常启动时调用
            fragments.add(Fragment.instantiate(this, HomeFragment.class.getName()));
            fragments.add(Fragment.instantiate(this, LotteryFragment.class.getName()));
            fragments.add(Fragment.instantiate(this, TabLotteryFragment.class.getName()));
            fragments.add(Fragment.instantiate(this, MeFragment.class.getName()));
            title_tv.setText(title_tvs[currentIndex]);
            showFragment();
        }
    }

    private void initData() {
        list = new ArrayList<ContentModel>();
        list.add(new ContentModel(R.mipmap.home_2, "首页", 1));
        list.add(new ContentModel(R.mipmap.prize_2, "开奖", 2));
        list.add(new ContentModel(R.mipmap.try_2, "资讯", 3));
        list.add(new ContentModel(R.mipmap.user_2, "更多", 4));
    }

    /**
     * 使用show() hide()切换页面，显示fragment
     */
    private void showFragment() {
        FragmentTransaction transaction = fm.beginTransaction();
        //如果之前没有添加过
        if (!fragments.get(currentIndex).isAdded()) {
            transaction
                    .hide(currentFragment)
                    .add(R.id.content, fragments.get(currentIndex), "" + currentIndex);  //第三个参数为添加当前的fragment时绑定一个tag
        } else {
            transaction
                    .hide(currentFragment)
                    .show(fragments.get(currentIndex));
        }
        currentFragment = fragments.get(currentIndex);
        transaction.commit();
    }

    /**
     * 恢复fragment
     */
    private void restoreFragment() {


        FragmentTransaction mBeginTreansaction = fm.beginTransaction();

        for (int i = 0; i < fragments.size(); i++) {

            if (i == currentIndex) {
                mBeginTreansaction.show(fragments.get(i));
            } else {
                mBeginTreansaction.hide(fragments.get(i));
            }

        }

        mBeginTreansaction.commit();

        //把当前显示的fragment记录下来
        currentFragment = fragments.get(currentIndex);

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (null != intent) {
            Bundle bundle = intent.getExtras();
            Log.d(TAG, "--onNewIntent--");
            if (bundle != null) {
                String pushInfo = bundle.getString(JPushInterface.EXTRA_ALERT);
                showDiolog(Main_drawer_Activity.this, pushInfo);
            }

        }
    }
}
