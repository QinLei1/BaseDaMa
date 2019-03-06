package com.xcs.news.baseo.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.adapter.MyFragmentAdapter;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Date：2018/3/15 on 下午4:31
 * Describe:
 * Created by:stefan
 */
public class TabLotteryFragment extends Fragment {
    private View view;
    private ViewPager viewPager;
    private TabLayout indicator;
    private List<Fragment> fragments;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_tab_lotterty_news, container, false);
        intData();
        intView(view);
        return view;
    }

    private void intView(View view) {
        viewPager = view.findViewById(R.id.viewPager);
        indicator = view.findViewById(R.id.indicator);
        FragmentPagerAdapter adapter = new MyFragmentAdapter(getFragmentManager(), fragments, list);
        viewPager.setAdapter(adapter);
        indicator.setupWithViewPager(viewPager);

    }

    private void intData() {
        fragments = new ArrayList<>();
        list = new ArrayList<>();
        int type[] = {1, 2, 3, 4};
        fragments.clear();
        list.addAll(Arrays.asList(getResources().getStringArray(R.array.lottery)));
        for (int i = 0; i < list.size(); i++) {
            fragments.add(LotteryPagFragment.getInstance(type[i]));
        }

    }
}
