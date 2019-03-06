package com.xcs.news.baseo.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.activity.CommonActivity;
import com.xcs.news.baseo.adapter.common.CommonViewHolder;
import com.xcs.news.baseo.base.BaseAdapter;
import com.xcs.news.baseo.base.BasePresenter;
import com.xcs.news.baseo.base.BasePresenterFragment;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class Yc_child_Fragment extends BasePresenterFragment implements CommonViewHolder.onItemCommonClickListener {

    public Yc_child_Fragment() {

    }

    private String SHUANGSEQIU = "shuangseqiu";
    private String FUCAI3D = "fucai3d";
    private List<Integer> imgList = new ArrayList<Integer>();
    private String czname;
    @Bind(R.id.recycler)
    PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private Myadapter myadapter;

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.yc_child_layout;
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        Bundle bundle = getArguments();
        czname = bundle.getString("czname");
        imgList.clear();
        initItemData();
        myadapter = new Myadapter(getActivity(), imgList, R.layout.single_img_item, this);
        mPullLoadMoreRecyclerView.setPullRefreshEnable(false);
        mPullLoadMoreRecyclerView.setPushRefreshEnable(false);
        mPullLoadMoreRecyclerView.setLinearLayout();//参数为列数;
        mPullLoadMoreRecyclerView.setAdapter(myadapter);
    }

    private void initItemData() {
        if (SHUANGSEQIU.equals(czname)) {
            imgList.add(R.mipmap.shuangseqiu_21);
            imgList.add(R.mipmap.shuangseqiu_22);
            imgList.add(R.mipmap.shuangseqiu_23);
            imgList.add(R.mipmap.shuangseqiu_24);
            imgList.add(R.mipmap.shuangseqiu_25);
            imgList.add(R.mipmap.shuangseqiu_26);
            imgList.add(R.mipmap.shuangseqiu_27);
            imgList.add(R.mipmap.shuangseqiu_28);
            imgList.add(R.mipmap.shuangseqiu_29);
            imgList.add(R.mipmap.shuangseqiu_30);
            imgList.add(R.mipmap.shuangseqiu_31);
            imgList.add(R.mipmap.shuangseqiu_32);
            imgList.add(R.mipmap.shuangseqiu_33);
            imgList.add(R.mipmap.shuangseqiu_34);
            imgList.add(R.mipmap.shuangseqiu_35);
            imgList.add(R.mipmap.shuangseqiu_36);
            imgList.add(R.mipmap.shuangseqiu_37);
            imgList.add(R.mipmap.shuangseqiu_38);
            imgList.add(R.mipmap.shuangseqiu_40);
            imgList.add(R.mipmap.shuangseqiu_41);
            imgList.add(R.mipmap.shuangseqiu_42);
            imgList.add(R.mipmap.shuangseqiu_43);
            imgList.add(R.mipmap.shuangseqiu_44);
            imgList.add(R.mipmap.shuangseqiu_45);
            imgList.add(R.mipmap.shuangseqiu_46);
        } else {
            imgList.add(R.mipmap.fucai_3d_21);
            imgList.add(R.mipmap.fucai_3d_22);
            imgList.add(R.mipmap.fucai_3d_23);
            imgList.add(R.mipmap.fucai_3d_24);
            imgList.add(R.mipmap.fucai_3d_25);
            imgList.add(R.mipmap.fucai_3d_26);
            imgList.add(R.mipmap.fucai_3d_27);
            imgList.add(R.mipmap.fucai_3d_28);
            imgList.add(R.mipmap.fucai_3d_29);
            imgList.add(R.mipmap.fucai_3d_30);
            imgList.add(R.mipmap.fucai_3d_31);
            imgList.add(R.mipmap.fucai_3d_32);
            imgList.add(R.mipmap.fucai_3d_33);
            imgList.add(R.mipmap.fucai_3d_34);
            imgList.add(R.mipmap.fucai_3d_35);
            imgList.add(R.mipmap.fucai_3d_36);
            imgList.add(R.mipmap.fucai_3d_37);
            imgList.add(R.mipmap.fucai_3d_39);
            imgList.add(R.mipmap.fucai_3d_40);
        }
    }

    private static class Myadapter extends BaseAdapter<Integer> {
        public Myadapter(Context context, List<Integer> dataList, int layoutId, CommonViewHolder.onItemCommonClickListener commonClickListener) {
            super(context, dataList, layoutId, commonClickListener);
        }

        @Override
        public void doSomething(CommonViewHolder holder, Integer data) {
            holder.setImageResource(R.id.img, data);
        }
    }

    @Override
    public void onItemClickListener(int position) {
        String url = "";
        String name = "";
        int p = position + 1;
        if (SHUANGSEQIU.equals(czname)) {

            if (p > 9) {
                url = "file:///android_asset/ss_" + p + ".html";
            } else {
                url = "file:///android_asset/ss_0" + p + ".html";
            }
            name="双色球";
        } else {
            if (p > 9) {
                url = "file:///android_asset/fc_" + p + ".html";
            } else {
                url = "file:///android_asset/fc_0" + p + ".html";
            }
            name="福彩3D";
        }
        Bundle bundle = new Bundle();
        bundle.putInt("type", 5);
        bundle.putString("url", url);
        bundle.putString("czname", czname);
        CommonActivity.launch(getActivity(), bundle, name + "预测");
    }

    @Override
    public void onItemLongClickListener(int position) {

    }
}
