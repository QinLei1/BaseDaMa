package com.xcs.news.baseo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.activity.CommonActivity;


/**
 * Date：2018/4/4 on 上午11:59
 * Describe:
 * Created by:stefan
 */
public class PlayFragment extends Fragment {

    public static PlayFragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt("position", position);
        PlayFragment fragment = new PlayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private View view;
    private int type;
    private LinearLayout trend;
    private LinearLayout play;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_play, container, false);
        Bundle bundle = getArguments();
        type = bundle.getInt("position");
        trend = view.findViewById(R.id.trend);
        play = view.findViewById(R.id.play);
        Bundle bundle1 = new Bundle();

        trend.setOnClickListener(view -> {
            if (type == 0) {
                bundle1.putString("url", "http://m.500.com/datachart/sfc/zfb/2.html");//足彩竞彩
            } else if (type == 1) {
                bundle1.putString("url", "http://m.500.com/datachart/dlt/jb.html");//大乐透
            } else if (type == 2) {
                bundle1.putString("url", "http://m.500.com/datachart/ssq/jb.html");//双色球
            } else if (type == 3) {
                bundle1.putString("url", "http://m.500.com/datachart/qxc/zx/0.html");//七星彩
            } else if (type == 4) {
                bundle1.putString("url", "http://m.500.com/datachart/sd/jb.html");//福彩3D
            } else if (type == 5) {
                bundle1.putString("url", "http://m.500.com/datachart/pls/jb.html");//排列3
            } else if (type == 6) {
                bundle1.putString("url", "http://m.500.com/datachart/plw/zx/0.html");////排列5
            } else if (type == 7) {
                bundle1.putString("url", "http://m.500.com/datachart/ssc/zx/jb.html");//时时彩
            } else if (type == 8) {
                bundle1.putString("url", "http://m.500.com/datachart/sfc/zfb/2.html");//胜负彩
            } else if(type==9){
                bundle1.putString("url", "https://m.500.com/lottery/jzdg/index.html#/bet/jczq");//竞足单关
            }
            bundle1.putInt("type", 4);
            CommonActivity.launch(getActivity(), bundle1, "走势图分析");
        });
        play.setOnClickListener(view -> {
            bundle1.putInt("type", 4);
            if (type == 0) {
                bundle1.putString("url", "http://m.500.com/lottery/help/jczq_help.html");//足彩竞彩
            } else if (type == 1) {
                bundle1.putString("url", "http://m.500.com/lottery/help/dlt_help.html");//大乐透
            } else if (type == 2) {
                bundle1.putString("url", "http://m.500.com/lottery/help/ssq_help.html");//双色球
            } else if (type == 3) {
                bundle1.putString("url", "http://m.500.com/lottery/help/sd_help.html");//福彩3D
            } else if (type == 4) {
                bundle1.putString("url", "http://m.500.com/lottery/help/pls_help.html");//排列3
            } else if (type == 5) {
                bundle1.putString("url", "http://m.500.com/lottery/help/plw_help.html");//排列5
            } else {

            }
            CommonActivity.launch(getActivity(), bundle1, "玩法介绍");
        });

        return view;
    }
}
