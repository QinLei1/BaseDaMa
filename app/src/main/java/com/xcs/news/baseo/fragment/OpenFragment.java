package com.xcs.news.baseo.fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.activity.CommonActivity;
import com.xcs.news.baseo.activity.ShuangseActivity;

public class OpenFragment extends Fragment{

    private View view;
    private ImageView kj_img01,kj_img02,kj_img03,kj_img04,kj_img05,kj_img06,kj_img07,kj_img08,kj_img09,kj_img010,kj_img011;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_open, container, false);
        initView();
        return view;
    }

    private void initView(){
        final Intent intent = new Intent(getActivity(), ShuangseActivity.class);
        intent.putExtra("url", "https://m.500.com/datachart/");

        view.findViewById(R.id.kj_img01).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent.putExtra("title", "开奖详情");
                getContext().startActivity(intent);
            }
        });
//        view.findViewById(R.id.kj_img02).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });
//        view.findViewById(R.id.kj_img03).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });
//        view.findViewById(R.id.kj_img04).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });
//        view.findViewById(R.id.kj_img05).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });
//        view.findViewById(R.id.kj_img06).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });
//        view.findViewById(R.id.kj_img07).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });

//        kj_img01=view.findViewById(R.id.kj_img01);
//        kj_img02=view.findViewById(R.id.kj_img02);
//        kj_img03=view.findViewById(R.id.kj_img03);
//        kj_img04=view.findViewById(R.id.kj_img04);
//        kj_img05=view.findViewById(R.id.kj_img05);
//        kj_img06=view.findViewById(R.id.kj_img06);
//        kj_img07=view.findViewById(R.id.kj_img07);
//
//        Intent intent = new Intent(getActivity(), ShuangseActivity.class);
//        intent.putExtra("url", "https://m.500.com/datachart/");
////                Bundle bundle = new Bundle();
////                bundle.putString("url", "http://m.zhcw.com/kaijiang/kj_live.jsp?lottery=FC_SSQ&from=client");
////                bundle.putInt("type", 4);
////                CommonActivity.launch(getActivity(), bundle, "开奖直播");
//        kj_img01.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });
//        kj_img02.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });
//        kj_img03.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });
//        kj_img04.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });
//        kj_img05.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });
//        kj_img06.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });
//        kj_img07.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                intent.putExtra("title", "开奖详情");
//                getContext().startActivity(intent);
//            }
//        });
    }
}
