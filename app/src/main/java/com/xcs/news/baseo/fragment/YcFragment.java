package com.xcs.news.baseo.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.base.BasePresenter;
import com.xcs.news.baseo.base.BasePresenterFragment;

import net.avenwu.support.widget.FlatTabGroup;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class YcFragment extends BasePresenterFragment{


    public YcFragment() {
    }

    @Bind(R.id.content)
    FrameLayout content;
    @Bind(R.id.flattabgroup)
    FlatTabGroup flattabgroup;
    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.yc_fragment_layout;
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void initView(View rootView) {
        super.initView(rootView);

        initFragment();
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initListener() {
        super.initListener();
        flattabgroup.setOnTabCheckedListener(new FlatTabGroup.OnTabCheckedListener() {
            @Override
            public void onChecked(FlatTabGroup group, int position) {
                setIndexSelected(position);
            }
        });
    }
    private Fragment[] mFragments;
    private int mIndex;
    private void initFragment() {

        Bundle args = new Bundle();
        args.putString("czname", "shuangseqiu");
        Yc_child_Fragment ssq_fragment = new Yc_child_Fragment();
        ssq_fragment.setArguments(args);
        Bundle args1 = new Bundle();
        args1.putString("czname", "fucai3d");
        Yc_child_Fragment fc3d_fragment = new Yc_child_Fragment();
        fc3d_fragment.setArguments(args1);
        //添加到数组
        mFragments = new Fragment[]{ssq_fragment,fc3d_fragment};

        //开启事务
        FragmentTransaction ft =
                getActivity().getSupportFragmentManager().beginTransaction();
        //添加首页
        ft.add(R.id.content,ssq_fragment).commit();

        //默认设置为第0个
        setIndexSelected(0);
    }

    private void setIndexSelected(int index) {

        if(mIndex==index){
            return;
        }
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();


        //隐藏
        //ft.hide(mFragments[mIndex]);
        //判断是否添加
        //if(!mFragments[index].isAdded()){
         //   ft.add(R.id.content,mFragments[index]).show(mFragments[index]);
        //}else {
         //   ft.show(mFragments[index]);
        //}
        ft.replace(R.id.content,mFragments[index]);
        ft.commit();
        //再次赋值
        mIndex=index;

    }
}
