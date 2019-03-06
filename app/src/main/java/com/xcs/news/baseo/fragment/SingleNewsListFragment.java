package com.xcs.news.baseo.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.activity.CommonActivity;
import com.xcs.news.baseo.adapter.common.CommonViewHolder;
import com.xcs.news.baseo.adapter.news.NewsAdapter;
import com.xcs.news.baseo.api.ApiRetrofit;
import com.xcs.news.baseo.api.ApiService;
import com.xcs.news.baseo.base.BasePresenterFragment;
import com.xcs.news.baseo.base.SwipeListPresenter;
import com.xcs.news.baseo.callback.base.ISwipeListView;
import com.xcs.news.baseo.entity.model_zcw.TouTiaoBean;
import com.xcs.news.baseo.entity.model_zcw.TouTiaoBeans;
import com.xcs.news.baseo.utils.NetworkUtil;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import rx.Observable;

public class SingleNewsListFragment extends BasePresenterFragment<SwipeListPresenter<TouTiaoBean, TouTiaoBeans>>
        implements ISwipeListView<TouTiaoBean, TouTiaoBeans>, CommonViewHolder.onItemCommonClickListener {

    public SingleNewsListFragment() {
    }

    public static SingleNewsListFragment newInstance(String channel) {
        Bundle args = new Bundle();
        SingleNewsListFragment fragment = new SingleNewsListFragment();
        args.putString("channel", channel);
        fragment.setArguments(args);
        return fragment;
    }

    private NewsAdapter newsAdapter;
    private Handler handler;
    private ProgressDialog progressDialog;
    private List<TouTiaoBean> beanList = new ArrayList<TouTiaoBean>();
    private static String TAG = SingleNewsListFragment.class.getName();
    private String[] channels;
    private String targetChannel = "";
    @Bind(R.id.recycler)
    PullLoadMoreRecyclerView pullLoadMoreRecyclerView;

    @Bind(R.id.imgview)
    ImageView neterrorImg;
    private ApiService apiService = ApiRetrofit.getInstance().getApiService();

    @Override
    protected SwipeListPresenter<TouTiaoBean, TouTiaoBeans> createPresenter() {
        return new SwipeListPresenter<>(this);
    }

    @Override
    protected int provideContentViewId() {
        //提供布局
        return R.layout.news_frg_layout;
    }

    @Override
    protected void loadData() {
        //网络请求在这里调用
        if (NetworkUtil.isNetworkAvailable(getActivity())) {
            mPresenter.getList(getObservable(10, 10));
        } else {
            neterrorImg.setVisibility(View.VISIBLE);
        }


    }

    //当在loadData方法中调用getObservable就会开启网络请求数据,可以继承该fragment然后重写该方法
    public Observable<TouTiaoBeans> getObservable(int pageNo, int pageCount) {
        //此处调用Retrofit开启网络请求，获取Observable对象给presenter使用
        Observable<TouTiaoBeans> observable = null;
        switch (targetChannel) {
            case "头条":
//                observable = apiService.getTouTiaoList(pageNo);
                break;
            case "彩讯":
//                observable = apiService.getCaixunaoList(pageNo);
                break;
            case "足球":
                break;

            case "篮球":
                //observable =apiService.getBasketballList(pageNo);
                break;
            case "公益":
//                observable =apiService.getGongyiList(pageNo);
                break;
            case "政策":
//                observable =apiService.getPoliceList(pageNo);
                break;
            default:
//                observable = apiService.getTouTiaoList(pageNo);
                break;
        }
//        return observable==null? apiService.getTouTiaoList(pageNo):observable;
        return null;
    }

    @Override
    public void initView(View rootView) {
        //初始化界面
        super.initView(rootView);
//        pullLoadMoreRecyclerView.setPullRefreshEnable(false);
//        pullLoadMoreRecyclerView.setPushRefreshEnable(false);
        // pullLoadMoreRecyclerView.setGridLayout(1);//参数为列数
        pullLoadMoreRecyclerView.setLinearLayout();
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.custom_divider));
        pullLoadMoreRecyclerView.addItemDecoration(divider);
        handler = new Handler();
        newsAdapter = new NewsAdapter(getActivity(), beanList, R.layout.item_toutiao, this);
        pullLoadMoreRecyclerView.setAdapter(newsAdapter);
        pullLoadMoreRecyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(() -> pullLoadMoreRecyclerView.setPullLoadMoreCompleted(), 1000);
            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(() -> pullLoadMoreRecyclerView.setPullLoadMoreCompleted(), 1000);
            }
        });
        showLoadingDialog();
    }

    private void showLoadingDialog() {
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("正在加载");
        progressDialog.show();
        handler.postDelayed(() -> progressDialog.dismiss(), 1000);
    }

    private void disMissDiaLog() {
        if (progressDialog.isShowing()) {
            progressDialog.dismiss();
        }
    }

    @Override
    public void initData() {
        //初始化数据
        super.initData();
        channels = getResources().getStringArray(R.array.channel);
     //   getArguments().get("channel");
        if (getArguments() != null) {
            targetChannel = getArguments().getString("channel");
        }
    }

    @Override
    public void initListener() {
        super.initListener();
        pullLoadMoreRecyclerView.setAdapter(null);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onGetSwipeListSuccess(TouTiaoBeans t) {
        TouTiaoBeans touTiaoBeans = t;
        disMissDiaLog();
        beanList.addAll(t.getDataList());
        newsAdapter.addAllData(beanList);
        Log.d(TAG, t.toString());
    }

    @Override
    public void onError() {
        Log.d(TAG, "onError");
        neterrorImg.setVisibility(View.VISIBLE);
    }

    @Override
    public void onItemClickListener(int position) {
        Log.d(TAG, "onItemClickListener");
        Bundle bundle1 = new Bundle();
        bundle1.putInt("type", 4);//webviewfragment
        String url = "http://m.500.com/datachart/sfc/zfb/2.html";
        try {
            url = beanList.get(position).getUrl();
        } catch (Exception e) {
            Log.d(TAG, "onItemClickListener---Exception:", e);

        }
        bundle1.putString("url", url);
        CommonActivity.launch(getActivity(), bundle1, "");
    }

    @Override
    public void onItemLongClickListener(int position) {

    }
}
