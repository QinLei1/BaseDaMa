package com.xcs.news.baseo.fragment;


import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.fingerth.supdialogutils.SYSDiaLogUtils;
import com.xcs.news.baseo.R;
import com.xcs.news.baseo.adapter.HistoryKjAdapter;
import com.xcs.news.baseo.entity.OpenCaiDataBean;
import com.xcs.news.baseo.entity.OpenCaiHttpResult;
import com.xcs.news.baseo.net.RetrofitClient;
import com.xcs.news.baseo.utils.NetworkUtil;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LotteryHistoryFragment extends Fragment {
    private View view;
    private PullLoadMoreRecyclerView my_recycler_view;
    private Handler handler;
    private String url;
    private String czname;
    private final String BASEURL = "http://f.apiplus.net";
    private List<OpenCaiDataBean> moreDataList = new ArrayList<OpenCaiDataBean>();
    private HistoryKjAdapter adapter;

    public LotteryHistoryFragment() {
        // Required empty public constructor
    }

    public static LotteryHistoryFragment newInstance(String url, String czName) {
        Bundle args = new Bundle();
        args.putString("url", url);
        args.putString("czname", czName);
        LotteryHistoryFragment fragment = new LotteryHistoryFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (NetworkUtil.isNetworkAvailable(getActivity())) {
            view = inflater.inflate(R.layout.fragment_lotterty, container, false);
            init(view);
            loadData(getContext(), url);
        } else {
            view = inflater.inflate(R.layout.network_false, container, false);
        }
        return view;
    }

    private void init(View view) {

        Bundle bundle = getArguments();
        url = bundle.getString("url");
        czname = bundle.getString("czname");
        my_recycler_view = view.findViewById(R.id.recycler);
        my_recycler_view.setLinearLayout();
        DividerItemDecoration divider = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        divider.setDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.custom_divider));
        my_recycler_view.addItemDecoration(divider);
        handler = new Handler();
        adapter = new HistoryKjAdapter(getActivity(), moreDataList, R.layout.item_caizhong);
        adapter.setCzName(czname);
        my_recycler_view.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                handler.postDelayed(() -> my_recycler_view.setPullLoadMoreCompleted(), 1000);
            }

            @Override
            public void onLoadMore() {
                handler.postDelayed(() -> my_recycler_view.setPullLoadMoreCompleted(), 1000);
            }
        });
        my_recycler_view.setAdapter(adapter);

        SYSDiaLogUtils.showProgressDialog(getActivity(), SYSDiaLogUtils.SYSDiaLogType.IosType, "加载中...", false, new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {

            }
        });

    }

    private void loadData(Context context, String url) {
//        RetrofitClient.getInstance(/*context, */BASEURL).getCZInfo(url, new Callback<OpenCaiHttpResult<OpenCaiDataBean>>() {
//            @Override
//            public void onResponse(Call<OpenCaiHttpResult<OpenCaiDataBean>> call, Response<OpenCaiHttpResult<OpenCaiDataBean>> response) {
//                OpenCaiHttpResult<OpenCaiDataBean> openCaiHttpResult = response.body();
//                if (openCaiHttpResult != null) {
//                    SYSDiaLogUtils.dismissProgress();
//                    moreDataList.clear();
//                    moreDataList.addAll(openCaiHttpResult.getData());
//                    adapter.addAllData(moreDataList);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<OpenCaiHttpResult<OpenCaiDataBean>> call, Throwable t) {
//                // Toast.makeText(context,"亲！请求服务器异常，请稍后重试",Toast.LENGTH_LONG);
//                SYSDiaLogUtils.dismissProgress();
//                SYSDiaLogUtils.showErrorDialog(getActivity(), "服务器异常", "很抱歉，请稍后重试！", "取消", false);
//            }
//        });

    }
}
