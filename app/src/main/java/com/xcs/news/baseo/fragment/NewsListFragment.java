package com.xcs.news.baseo.fragment;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.google.gson.Gson;
import com.xcs.news.baseo.R;
import com.xcs.news.baseo.base.BasePresenterFragment;
import com.xcs.news.baseo.callback.lNewsListView;
import com.xcs.news.baseo.presenter.NewsListPresenter;
import com.xcs.news.baseo.utils.UIUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import me.weyye.library.colortrackview.ColorTrackTabLayout;

/**
 * @description: 展示每个频道新闻列表的fragment
 * @date 2017/6/16  21:22
 */

public class NewsListFragment extends BasePresenterFragment {

    private static final String TAG = NewsListFragment.class.getSimpleName();
    @Bind(R.id.tab_channel)
    ColorTrackTabLayout mTabChannel;

    @Bind(R.id.vp_content)
    ViewPager mVpContent;
    String[] channels;
    private Gson mGson = new Gson();
    private List<Fragment> fragments;

    @Override
    protected NewsListPresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_new_lists;
    }

    @Override
    public void initView(View rootView) {
        // 设置下拉刷新和上拉加载更多的风格
    }

    @Override
    public void initData() {
        //设置数据
        channels = getResources().getStringArray(R.array.channel);
        fragments = new ArrayList<Fragment>();
        for (int i = 0; i < channels.length; i++) {
            fragments.add(new SingleNewsListFragment());
        }

    }

    @Override
    public void initListener() {
        //  设置适配器

        mVpContent.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return channels.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return channels[position];
            }
        });
        //隐藏指示器
        mTabChannel.setSelectedTabIndicatorHeight(0);
        //设置每个Tab的内边距
        mTabChannel.setTabPaddingLeftAndRight(UIUtils.dip2Px(getActivity(), 30), UIUtils.dip2Px(getActivity(), 30));
        mTabChannel.setupWithViewPager(mVpContent);
    }

    @Override
    protected void loadData() {
        //加载网络数据，此处会使用RXJAVA来实现，例子：  mPresenter.getNewsList(mChannelCode);

    }

    @Override
    public void onStart() {
        super.onStart();
        //  registerEventBus(NewsListFragment.this);
    }

    @Override
    public void onStop() {
        super.onStop();
        //  unregisterEventBus(NewsListFragment.this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
