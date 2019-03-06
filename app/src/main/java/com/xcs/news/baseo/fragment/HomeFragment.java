package com.xcs.news.baseo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.activity.CommonActivity;
import com.xcs.news.baseo.activity.ShuangseActivity;
import com.xcs.news.baseo.adapter.HomeAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment implements View.OnClickListener {
    private Bundle bundle;

    public HomeFragment() {
        // Required empty public constructor
    }


    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);
        bundle = new Bundle();

        initView();

        return view;
    }

    private void initView() {
        final Intent intent = new Intent(getContext(), ShuangseActivity.class);

//        view.findViewById(R.id.home_banner).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "热点");
//                getContext().startActivity(intent);
//            }
//        });
        view.findViewById(R.id.home_img01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("title", "开奖详情");
                getContext().startActivity(intent);
            }
        });
        view.findViewById(R.id.home_img02).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("title", "开奖详情");
                getContext().startActivity(intent);
            }
        });
        view.findViewById(R.id.home_img03).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("title", "开奖详情");
                getContext().startActivity(intent);
            }
        });
//        view.findViewById(R.id.home_img04).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });
//        view.findViewById(R.id.home_img05).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });
//        view.findViewById(R.id.home_img06).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });

//        ImageView banner = view.findViewById(R.id.home_banner);
//        ImageView home01 = view.findViewById(R.id.home_img01);
//        ImageView home02 = view.findViewById(R.id.home_img02);
//        ImageView home03 = view.findViewById(R.id.home_img03);
//        ImageView home04 = view.findViewById(R.id.home_img04);
//        ImageView home05 = view.findViewById(R.id.home_img05);
//        ImageView home06 = view.findViewById(R.id.home_img06);
//        banner.setOnClickListener(this);
//        home01.setOnClickListener(this);
//        home02.setOnClickListener(this);
//        home03.setOnClickListener(this);
//        home04.setOnClickListener(this);
//        home05.setOnClickListener(this);
//        home06.setOnClickListener(this);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onClick(View v) {
//        Bundle bundle = new Bundle();
//        Intent intent = new Intent(getActivity(), ShuangseActivity.class);
//        switch (v.getId()) {
//            case R.id.home_banner:
//                intent.putExtra("title", "热点");
//                getContext().startActivity(intent);
//
////                bundle.putString("url", "https://m.500.com/datachart/");
////                bundle.putInt("type", 4);
////                CommonActivity.launch(getActivity(), bundle, "最热");
//                break;
//            case R.id.home_img01:
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//                break;
//            case R.id.home_img02:
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//                break;
//            case R.id.home_img03:
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//                break;
//            case R.id.home_img04:
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//                break;
//            case R.id.home_img05:
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//                break;
//            case R.id.home_img06:
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//                break;
//        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
