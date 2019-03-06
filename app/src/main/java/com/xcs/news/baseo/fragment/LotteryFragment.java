package com.xcs.news.baseo.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.xcs.news.baseo.R;
import com.xcs.news.baseo.activity.CommonActivity;
import com.xcs.news.baseo.adapter.KjRecyclerViewAdapter;
import com.xcs.news.baseo.entity.caizhong.CZbean;
import com.xcs.news.baseo.utils.Config;
import com.xcs.news.baseo.utils.NetworkUtil;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;


import java.util.ArrayList;
import java.util.List;

/**
 * Date：2018/4/2 on 下午7:01
 * Describe:
 * Created by:stefan
 */
public class LotteryFragment extends Fragment {
    private View view;
    private PullLoadMoreRecyclerView my_recycler_view;
    private LinearLayoutManager mLayoutManager;
    private KjRecyclerViewAdapter adapter;
    private List<CZbean> list = new ArrayList<CZbean>();
    private Handler handler;
    private Bundle bundle;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (!NetworkUtil.isNetworkAvailable(getActivity())) {
            Toast.makeText(getActivity(),"网络异常，请检查网络",Toast.LENGTH_LONG);
        }
        view = inflater.inflate(R.layout.fragment_lotterty, container, false);
        iniData();
        init(view);

        return view;
    }

    private void iniData() {
        list.clear();
        list.add(new CZbean("大乐透", Config.KCDLTURL1));
        list.add(new CZbean("福彩3D", Config.KCFC3DURL1));
        list.add(new CZbean("排列3", Config.KCPL3URL1));
        list.add(new CZbean("排列5", Config.KCPL5URL1));
        list.add(new CZbean("安徽11选5", Config.KCAH11X5URL1));
        list.add(new CZbean("北京11选5", Config.KCBJ11X5URL1));
        list.add(new CZbean("福建11选5", Config.KCFJ11X5URL1));
        list.add(new CZbean("双色球", Config.KCSSQURL1));
        list.add(new CZbean("广东11选5", Config.KCGD11X5URL1));
        list.add(new CZbean("甘肃11选5", Config.KCGS11X5URL1));
        list.add(new CZbean("广西11选5", Config.KCGX11X5URL1));
        list.add(new CZbean("七乐彩", Config.KCQLCURL1));
        list.add(new CZbean("七星彩", Config.KCQXCURL1));
        list.add(new CZbean("广西快3", Config.GXK3URL1));
    }

    private void init(View view) {
        bundle = new Bundle();
        my_recycler_view = view.findViewById(R.id.recycler);
        // 设置布局管理器
        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        my_recycler_view.setLinearLayout();
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.custom_divider));
        my_recycler_view.addItemDecoration(divider);
        handler = new Handler();
        adapter = new KjRecyclerViewAdapter(getActivity());
        adapter.setItemClickListener(new KjRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(CZbean position) {
                //跳转到开奖历史界面
                bundle.putInt("type", 1);
                String url = position.getUrl().replace("-1", "-20");
                bundle.putString("url", url);
                String czname = position.getCzName();
                bundle.putString("czname", czname);
                CommonActivity.launch(getActivity(), bundle, position.getCzName() + "开奖历史");
            }
        });
        my_recycler_view.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(() -> my_recycler_view.setPullLoadMoreCompleted(), 1000);
            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(() -> my_recycler_view.setPullLoadMoreCompleted(), 1000);
            }
        });
        my_recycler_view.setAdapter(adapter);
        adapter.addAllData(list);
    }


    @Override
    public void onStart() {
        super.onStart();
    }
}
