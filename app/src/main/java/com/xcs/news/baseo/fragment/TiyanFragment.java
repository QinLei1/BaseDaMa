package com.xcs.news.baseo.fragment;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.base.BasePresenter;
import com.xcs.news.baseo.base.BasePresenterFragment;

import butterknife.Bind;

/**
 * A simple {@link Fragment} subclass.
 */
public class TiyanFragment extends BasePresenterFragment {

    //设置一个时间常量，此常量有两个作用，1.圆灯视图显示与隐藏中间的切换时间；2.指针转一圈所需要的时间，现设置为500毫秒
    private static final long ONE_WHEEL_TIME = 500;
    //记录圆灯视图是否显示的布尔常量
    private boolean lightsOn = true;
    //开始转动时候的角度，初始值为0
    private int startDegree = 0;
    ImageView lightIv;
    @Bind(R.id.point)
    ImageView pointIv;
    @Bind(R.id.main_wheel)
    ImageView wheelIv;

    //指针转圈圈数数据源
    private int[] laps = {5, 7, 10, 15};
    //指针所指向的角度数据源，因为有6个选项，所有此处是6个值
    private int[] angles = {0, 60, 120, 180, 240, 300};
    //转盘内容数组
    private String[] lotteryStr = {"集分宝10个", "呀没中！", "集分宝10000个", "集分宝1000个",
            "集分宝1个", "集分宝100个",};

    //监听动画状态的监听器
    private Animation.AnimationListener al = new Animation.AnimationListener() {

        @Override
        public void onAnimationStart(Animation animation) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onAnimationRepeat(Animation animation) {
            // TODO Auto-generated method stub

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            String name = lotteryStr[startDegree % 360 / 60];
            Toast.makeText(getActivity(), name, Toast.LENGTH_LONG).show();
        }
    };

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.wheel_fragment_layout;
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void initListener() {
        super.initListener();
        pointIv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                int lap = laps[(int) (Math.random() * 4)];
                int angle = angles[(int) (Math.random() * 6)];
                //每次转圈角度增量
                int increaseDegree = lap * 360 + angle;
                //初始化旋转动画，后面的四个参数是用来设置以自己的中心点为圆心转圈
                RotateAnimation rotateAnimation = new RotateAnimation(
                        startDegree, startDegree + increaseDegree,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f,
                        RotateAnimation.RELATIVE_TO_SELF, 0.5f);
                //将最后的角度赋值给startDegree作为下次转圈的初始角度
                startDegree += increaseDegree;
                //计算动画播放总时间
                long time = (lap + angle / 360) * ONE_WHEEL_TIME;
                //设置动画播放时间
                rotateAnimation.setDuration(time);
                //设置动画播放完后，停留在最后一帧画面上
                rotateAnimation.setFillAfter(true);
                //设置动画的加速行为，是先加速后减速
                rotateAnimation.setInterpolator(getActivity(),
                        android.R.anim.accelerate_decelerate_interpolator);
                //设置动画的监听器
                rotateAnimation.setAnimationListener(al);
                //开始播放动画
                pointIv.startAnimation(rotateAnimation);
            }
        });
    }
}
