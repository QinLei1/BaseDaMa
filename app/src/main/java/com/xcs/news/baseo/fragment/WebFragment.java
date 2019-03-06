package com.xcs.news.baseo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.activity.CommonActivity;
import com.xcs.news.baseo.entity.ZixunBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Date：2018/4/7 on 下午7:53
 * Describe:
 * Created by:stefan
 */
public class WebFragment extends Fragment {
//    @Bind(R.id.info01)
//    ImageView zixunImg1;
//    @Bind(R.id.info02)
//    ImageView zixunImg2;
//    @Bind(R.id.info03)
//    ImageView zixunImg3;
//    @Bind(R.id.info04)
//    ImageView zixunImg4;
//    @Bind(R.id.info05)
//    ImageView zixunImg5;

    public static WebFragment newInstance(String url) {
        Bundle args = new Bundle();
        args.putString("url", url);
        WebFragment fragment = new WebFragment();
        fragment.setArguments(args);
        return fragment;
    }

    private static String TAG = WebFragment.class.getName();
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_web_, container, false);
        Log.d(TAG, "-=onCreateView=--");
        ButterKnife.bind(this, view);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

//    @OnClick({R.id.info01, R.id.info02, R.id.info03, R.id.info04, R.id.info05})
//    public void onViewClicked(View view) {
//        Bundle bundle = new Bundle();
//        switch (view.getId()) {
//            case R.id.info01:
//                bundle.putString("url", "https://m.500.com/datachart/");
//                bundle.putInt("type", 4);
//                CommonActivity.launch(getActivity(), bundle, "资讯");
//                break;
//            case R.id.info02:
//                bundle.putString("url", "https://m.500.com/datachart/");
//                bundle.putInt("type", 4);
//                CommonActivity.launch(getActivity(), bundle, "资讯");
//                break;
//            case R.id.info03:
//                bundle.putString("url", "https://m.500.com/datachart/");
//                bundle.putInt("type", 4);
//                CommonActivity.launch(getActivity(), bundle, "资讯");
//                break;
//            case R.id.info04:
//                bundle.putString("url", "https://m.500.com/datachart/");
//                bundle.putInt("type", 4);
//                CommonActivity.launch(getActivity(), bundle, "资讯");
//                break;
//            case R.id.info05:
//                bundle.putString("url", "https://m.500.com/datachart/");
//                bundle.putInt("type", 4);
//                CommonActivity.launch(getActivity(), bundle, "资讯");
//                break;
//        }
//    }
}
