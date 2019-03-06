package com.xcs.news.baseo.fragment.mj1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.activity.CommonActivity;

/**
 * Date：2018/4/2 on 下午8:15
 * Describe:
 * Created by:stefan
 */
public class MeFragment extends Fragment implements View.OnClickListener {
    private View view;

    private ImageView imgview1;
    private ImageView imgview2;
    private ImageView imgview3;
    private ImageView imgview4;
    private Bundle bundle;
    private Handler handler;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_me, container, false);
//        imgview1 = view.findViewById(R.id.imgview1);
//        imgview2 = view.findViewById(R.id.imgview2);
//        imgview3 = view.findViewById(R.id.imgview3);
//        imgview4 = view.findViewById(R.id.imgview4);
//        bundle = new Bundle();
//        imgview1.setOnClickListener(this);
//        imgview2.setOnClickListener(this);
//        imgview3.setOnClickListener(this);
//        imgview4.setOnClickListener(this);
//        handler = new Handler();
//        progressDialog = new ProgressDialog(getActivity());
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
//        if (MyApplication.getAppContext().sharePreferenceUtil.getLogin()) {
//           imgview.setImageResource(R.mipmap.head_bg_01);
//        } else {
//            imgview.setImageResource(R.mipmap.head_bg_02);
//        }

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.imgview1:
//                bundle.putInt("type", 15);
//                bundle.putString("title", "免责声明");
//                CommonActivity.launch(getActivity(), bundle, "免责声明");
//                break;
//            case R.id.imgview2:
//                progressDialog.setMessage("正在检查版本");
//                progressDialog.show();
//                handler.postDelayed(() -> {
//                    Snackbar.make(imgview2, "暂时没更新的版本", Snackbar.LENGTH_SHORT).show();
//                    progressDialog.dismiss();
//                }, 1000);
//                break;
//            case R.id.imgview3:
//                Intent textIntent = new Intent(Intent.ACTION_SEND);
//                textIntent.setType("text/plain");
//                textIntent.putExtra(Intent.EXTRA_TEXT, "http://shouji.baidu.com");
//                startActivity(Intent.createChooser(textIntent, "分享"));
//                break;
//            case R.id.imgview4:
//                bundle.putInt("type", 8);
//                bundle.putString("title", "意见反馈");
//                CommonActivity.launch(getActivity(), bundle, "意见反馈");
//                break;
        }
    }
}
