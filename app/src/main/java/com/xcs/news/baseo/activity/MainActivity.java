package com.xcs.news.baseo.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

//import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
import com.xcs.news.baseo.Constants;
import com.xcs.news.baseo.MyApp;
import com.xcs.news.baseo.R;
import com.xcs.news.baseo.adapter.ViewPagerAdapter;
import com.xcs.news.baseo.entity.BackBodyEntity;
import com.xcs.news.baseo.entity.HttpResult;
import com.xcs.news.baseo.entity.POWeather;
import com.xcs.news.baseo.entity.ResultData;
import com.xcs.news.baseo.fragment.BaseFragment;
import com.xcs.news.baseo.fragment.HomeFragment;
import com.xcs.news.baseo.fragment.LotteryFragment;
import com.xcs.news.baseo.fragment.MeFragment;
import com.xcs.news.baseo.fragment.NewsListFragment;
import com.xcs.news.baseo.fragment.OpenFragment;
import com.xcs.news.baseo.fragment.TabLotteryFragment;
import com.xcs.news.baseo.fragment.TiyanFragment;
import com.xcs.news.baseo.fragment.WebFragment;
import com.xcs.news.baseo.fragment.WebFragment3;
import com.xcs.news.baseo.fragment.YcFragment;
import com.xcs.news.baseo.net.RetrofitClient;
import com.xcs.news.baseo.other.BottomNavigationViewHelper;
import com.xcs.news.baseo.utils.NetworkUtil;
import com.xcs.news.baseo.utils.PreferenceUtil;
import com.xcs.news.baseo.utils.UpdateUtils;
import com.xcs.news.baseo.utils.VersionResutl;

import java.net.UnknownHostException;

import butterknife.Bind;
import butterknife.ButterKnife;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ViewPager viewPager;
    private MenuItem menuItem;
    private BottomNavigationView navigation;
    private ImageView tab1;
    private ImageView tab2;
    private ImageView tab3;
    private ImageView tab4;
    private ImageView lastTab;
//    @Bind(R.id.title_tv)
//    TextView title_tv;
//    @Bind(R.id.title_bar)
//    RelativeLayout relativeLayout;


//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.item_lib:
////                    relativeLayout.setVisibility(View.VISIBLE);
////                    title_tv.setText(R.string.home);
//                    viewPager.setCurrentItem(0);
//                    return true;
//                case R.id.item_open:
////                    relativeLayout.setVisibility(View.VISIBLE);
////                    title_tv.setText(R.string.lottery);
//                    viewPager.setCurrentItem(1);
//                    return true;
//                case R.id.item_find:
////                    relativeLayout.setVisibility(View.VISIBLE);
////                    title_tv.setText(R.string.yuche);
//                    viewPager.setCurrentItem(2);
//                    return true;
//                case R.id.item_more:
////                    relativeLayout.setVisibility(View.VISIBLE);
////                    title_tv.setText(R.string.more);
//                    viewPager.setCurrentItem(3);
//                    return true;
//            }
//            return false;
//        }
//    };
    private ImageView topSliding;
    private TextView topText;
    private RelativeLayout mainTopRela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Window window = getWindow();
        //取消设置透明状态栏,使 ContentView 内容不再覆盖状态栏
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        //需要设置这个 flag 才能调用 setStatusBarColor 来设置状态栏颜色
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        //设置状态栏颜色
        // window.setStatusBarColor(getResources().getColor(R.color.colorAccent));
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
        setListener();
        setupViewPager(viewPager);
    }

    private void initView() {
        mainTopRela = findViewById(R.id.main_top_rela);
//        mainTopRela.setVisibility(View.GONE);
        topText = findViewById(R.id.main_text);
//        topText.setVisibility(View.GONE);

        tab1 = findViewById(R.id.tab_1);
        tab2 = findViewById(R.id.tab_2);
        tab3 = findViewById(R.id.tab_3);
        tab4 = findViewById(R.id.tab_4);
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab3.setOnClickListener(this);
        tab4.setOnClickListener(this);
        lastTab = tab1;

//        topSliding = findViewById(R.id.main_sliding);
//        topSliding.setOnClickListener(this);

//        SlidingMenu slidingMenu = new SlidingMenu(this);
//        slidingMenu.setMode(SlidingMenu.LEFT);
//        slidingMenu.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
//        slidingMenu.setBehindOffset(200);
//        slidingMenu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
//        View view = getLayoutInflater().inflate(R.layout.sliding_layout, null);
//        ImageView imageView1 = view.findViewById(R.id.grzx_nav01);
//        ImageView imageView2 = view.findViewById(R.id.grzx_nav02);
//        ImageView imageView3 = view.findViewById(R.id.grzx_nav03);
//        imageView1.setOnClickListener(this);
//        imageView2.setOnClickListener(this);
//        imageView3.setOnClickListener(this);
//        slidingMenu.setMenu(view);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
//        navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //默认 >3 的选中效果会影响ViewPager的滑动切换时的效果，故利用反射去掉
//        BottomNavigationViewHelper.disableShiftMode(navigation);
    }

    private void setListener() {
//        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
//                if (menuItem != null) {
//                    menuItem.setChecked(false);
//                } else {
//                    navigation.getMenu().getItem(0).setChecked(false);
//                }
//                menuItem = navigation.getMenu().getItem(position);
//                menuItem.setChecked(true);

                switch (position) {
                    case 0:
//                        mainTopRela.setVisibility(View.GONE);

//                        topText.setVisibility(View.GONE);
                        topText.setText("首页");

                        tab1.setImageResource(R.mipmap.tab01);
                        tab2.setImageResource(R.mipmap.tab2);
                        tab3.setImageResource(R.mipmap.tab3);
                        tab4.setImageResource(R.mipmap.tab4);
                        break;
                    case 1:
//                        mainTopRela.setVisibility(View.VISIBLE);

//                        topText.setVisibility(View.VISIBLE);
                        topText.setText("开奖");

                        tab1.setImageResource(R.mipmap.tab1);
                        tab2.setImageResource(R.mipmap.tab02);
                        tab3.setImageResource(R.mipmap.tab3);
                        tab4.setImageResource(R.mipmap.tab4);
                        break;
                    case 2:
//                        mainTopRela.setVisibility(View.VISIBLE);

//                        topText.setVisibility(View.VISIBLE);
                        topText.setText("资讯");

                        tab1.setImageResource(R.mipmap.tab1);
                        tab2.setImageResource(R.mipmap.tab2);
                        tab3.setImageResource(R.mipmap.tab03);
                        tab4.setImageResource(R.mipmap.tab4);
                        break;
                    case 3:
//                        mainTopRela.setVisibility(View.VISIBLE);

//                        topText.setVisibility(View.VISIBLE);
                        topText.setText("我的");

                        tab1.setImageResource(R.mipmap.tab1);
                        tab2.setImageResource(R.mipmap.tab2);
                        tab3.setImageResource(R.mipmap.tab3);
                        tab4.setImageResource(R.mipmap.tab04);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(Fragment.instantiate(this, HomeFragment.class.getName()));
        adapter.addFragment(Fragment.instantiate(this, OpenFragment.class.getName()));
        adapter.addFragment(new WebFragment());
        adapter.addFragment(Fragment.instantiate(this, MeFragment.class.getName()));
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.main_sliding:
//                slidingMenu.toggle();
//                break;
//            case R.id.grzx_nav01:
//                slidingMenu.toggle();
//                viewPager.setCurrentItem(0);
//                break;
//            case R.id.grzx_nav02:
//                slidingMenu.toggle();
//                viewPager.setCurrentItem(1);
//                break;
//            case R.id.grzx_nav03:
//                slidingMenu.toggle();
//                viewPager.setCurrentItem(2);
//                break;
            case R.id.tab_1:
//                tab1.setImageResource(R.mipmap.tab01);
//                tab2.setImageResource(R.mipmap.tab2);
//                tab3.setImageResource(R.mipmap.tab3);
//                tab4.setImageResource(R.mipmap.tab4);
                viewPager.setCurrentItem(0);
                break;
            case R.id.tab_2:
//                tab1.setImageResource(R.mipmap.tab1);
//                tab2.setImageResource(R.mipmap.tab02);
//                tab3.setImageResource(R.mipmap.tab3);
//                tab4.setImageResource(R.mipmap.tab4);
                viewPager.setCurrentItem(1);
                break;
            case R.id.tab_3:
//                tab1.setImageResource(R.mipmap.tab1);
//                tab2.setImageResource(R.mipmap.tab2);
//                tab3.setImageResource(R.mipmap.tab03);
//                tab4.setImageResource(R.mipmap.tab4);
                viewPager.setCurrentItem(2);
                break;
            case R.id.tab_4:
//                tab1.setImageResource(R.mipmap.tab1);
//                tab2.setImageResource(R.mipmap.tab2);
//                tab3.setImageResource(R.mipmap.tab3);
//                tab4.setImageResource(R.mipmap.tab04);
                viewPager.setCurrentItem(3);
                break;
        }
    }

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
}
