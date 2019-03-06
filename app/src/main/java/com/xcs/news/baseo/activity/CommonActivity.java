package com.xcs.news.baseo.activity;


import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.fragment.AboutFragment;
import com.xcs.news.baseo.fragment.FeedbackFragment;
import com.xcs.news.baseo.fragment.FragmentKefu;
import com.xcs.news.baseo.fragment.LotteryHistoryFragment;
import com.xcs.news.baseo.fragment.NewsDetailsFragment;
import com.xcs.news.baseo.fragment.PlayFragment;
import com.xcs.news.baseo.fragment.PublicMoenyDetailsFragment;
import com.xcs.news.baseo.fragment.WebFragment;
import com.xcs.news.baseo.fragment.WebFragment3;
import com.xcs.news.baseo.fragment.WebFragment4;


/**
 * Created by Administrator on 2017/12/24.
 * 可以作为容器activity
 */

public class CommonActivity extends AppCompatActivity {
    private int type;
    private Fragment fragment;
    private TextView tv_title;
    private String title;

    public static void launch(Context context, Bundle bundle, String title) {
        Intent intent = new Intent(context, CommonActivity.class);
        intent.putExtra("bunble", bundle);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色
       // window.setStatusBarColor(getResources().getColor(R.color.red));
        setContentView(R.layout.activity_container);
        tv_title = findViewById(R.id.tv_title);
        Bundle bundle = getIntent().getBundleExtra("bunble");
        type = bundle.getInt("type");
        title = getIntent().getStringExtra("title");
        tv_title.setText(title);
        if (title.equals("-1")) {
            tv_title.setVisibility(View.GONE);
        }
        tv_title.setOnClickListener(v -> finish());
        switch (type) {
            case 1:
                //开奖历史界面
                 String url=bundle.getString("url");
                 String czname=bundle.getString("czname");
                  fragment=LotteryHistoryFragment.newInstance(url,czname);
                //fragment = new RegisteredFragment();
                break;
            case 2:
                fragment = WebFragment4.newInstance(bundle.getString("url"));
                break;
            case 3:
                fragment = PlayFragment.newInstance(bundle.getInt("position"));
                break;
            case 4:
                fragment = WebFragment3.newInstance(bundle.getString("url"));
                break;
            case 5:
                fragment = WebFragment.newInstance(bundle.getString("url"));
                break;
            case 6:
                fragment = new FragmentKefu();
                break;
            case 7:
              //  fragment = new LotteryDetailsFragment();
                break;
            case 8:
                fragment = new FeedbackFragment();
                break;
            case 9:
               // fragment = new NoticeFragment();
                break;
            case 10:
               //// fragment = new AboutFragment();
                break;
            case 11:
               // fragment = new FreeFragment();
                break;
            case 13:
                fragment = NewsDetailsFragment.newInstance(bundle.getInt("position"),
                        bundle.getInt("type1"));
                break;
            case 14:
//                fragment = new PublicMoenyFragment();
                break;
            case 15:
//                fragment = new PublicMoenyDetailsFragment();
                fragment = new AboutFragment();
                break;
            case 16:
//                fragment=new FictionFragment();
                break;
            case 18:
//                fragment=new FinctionTwoFragment();
                break;
            case 19:
//                fragment=new MacthFragment();
                break;
            case 20:
//                fragment= WebFragment.newInstance(bundle.getInt("type1"));
                break;


        }
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();

        }
    }
}
