package com.xcs.news.baseo.fragment.mj1;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.activity.CommonActivity;
import com.xcs.news.baseo.adapter.RecyclerViewAdapter;

import com.xcs.news.baseo.adapter.common.CommonRecycleAdapter;
import com.xcs.news.baseo.adapter.common.CommonViewHolder;
import com.xcs.news.baseo.base.BaseAdapter;
import com.xcs.news.baseo.base.BasePresenter;
import com.xcs.news.baseo.base.BasePresenterFragment;
import com.xcs.news.baseo.widget.ImageCycleView;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class Mj1_HomeFragment extends BasePresenterFragment implements CommonViewHolder.onItemCommonClickListener {

    @Bind(R.id.image)
    ImageCycleView imageCycleView;
    private List<ImageCycleView.ImageInfo> imageInfo = new ArrayList<>();
    private View view;
    @Bind(R.id.recycler)
    PullLoadMoreRecyclerView mPullLoadMoreRecyclerView;
    private int mCount = 1;
    MyAdapter mRecyclerViewAdapter;
    private List<bean> list = new ArrayList<bean>();
    private String[] caizhong;
    private int[] imgs = {R.mipmap.ic_jczq, R.mipmap.ic_jclq
            , R.mipmap.ic_bjdc, R.mipmap.ic_qxc, R.mipmap.ic_pl3, R.mipmap.ic_pl5, R.mipmap.ic_sfc,
            R.mipmap.ic_11x5, R.mipmap.ic_x11x5, R.mipmap.ic_xysc};

    @Override
    public void initView(View rootView) {
        super.initView(rootView);
        initFlashView();
        caizhong = getResources().getStringArray(R.array.caizhong);
        mPullLoadMoreRecyclerView.setPullRefreshEnable(false);
        mPullLoadMoreRecyclerView.setPushRefreshEnable(false);
        mPullLoadMoreRecyclerView.setLinearLayout();
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.custom_divider));
        mPullLoadMoreRecyclerView.addItemDecoration(divider);
        mRecyclerViewAdapter = new MyAdapter(getActivity(), list, R.layout.list_item, this);
        mPullLoadMoreRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerViewAdapter.addAllData(setList());
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_mj1_home;
    }

    private void initFlashView() {
        imageInfo.clear();
        imageInfo.add(new ImageCycleView.ImageInfo(R.mipmap.ic_launcher, "", ""));
        imageInfo.add(new ImageCycleView.ImageInfo(R.mipmap.ic_launcher, "", ""));
        imageInfo.add(new ImageCycleView.ImageInfo(R.mipmap.ic_launcher, "", ""));
        imageCycleView.loadData(imageInfo, new ImageCycleView.LoadImageCallBack() {
            @Override
            public ImageView loadAndDisplay(ImageCycleView.ImageInfo imageInfo) {
                //本地图片
                ImageView imageView = new ImageView(getActivity());
                imageView.setImageResource(Integer.parseInt(imageInfo.image.toString()));
                return imageView;
            }
        });
    }


    private List<bean> setList() {
        list.clear();
        int i = 0;
        for (String b : caizhong
                ) {
            list.add(new bean(imgs[i], b));
            i++;
        }
        return list;
    }

    @Override
    public void onItemClickListener(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("type", 3);
        bundle.putString("title", "");
        bundle.putInt("position", position);
        // bundle.putString("url","http://m.500.com/datachart/ssq/jb.html");
        CommonActivity.launch(getActivity(), bundle, "走势图以及玩法介绍");
    }

    @Override
    public void onItemLongClickListener(int position) {

    }

    @Override
    protected void loadData() {

    }

    private static class MyAdapter extends BaseAdapter<bean> {

        public MyAdapter(Context context, List<bean> dataList, int layoutId, CommonViewHolder.onItemCommonClickListener commonClickListener) {
            super(context, dataList, layoutId, commonClickListener);
        }

        @Override
        public void doSomething(CommonViewHolder holder, bean data) {
            holder.setImageResource(R.id.img, data.getImgId());
            holder.setText(R.id.tv, data.getName());

        }
    }

    private static class bean {
        private int imgId;
        private String name;

        public bean(int imgId, String name) {
            this.imgId = imgId;
            this.name = name;
        }

        public int getImgId() {
            return imgId;
        }

        public void setImgId(int imgId) {
            this.imgId = imgId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
