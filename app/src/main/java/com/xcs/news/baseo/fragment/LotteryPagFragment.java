package com.xcs.news.baseo.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.xcs.news.baseo.R;
import com.xcs.news.baseo.activity.CommonActivity;
import com.xcs.news.baseo.adapter.FregRecyclerViewAdapter;
import com.xcs.news.baseo.utils.Config;
import com.xcs.news.baseo.utils.NetworkUtil;
import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;


/**
 * Date：2018/1/26 on 下午2:43
 * Describe:
 * Created by:stefan stefan
 */
public class LotteryPagFragment extends Fragment implements FregRecyclerViewAdapter.OnItemClickListener {
    //  private RecyclerView.LayoutManager mLayoutManager;
    private static String TAG = LotteryPagFragment.class.getName();
    private View view;
    private int type;
    private PullLoadMoreRecyclerView my_recycler_view;
    private List<String> list = new ArrayList<>();

    private Bundle bundle;


    private FregRecyclerViewAdapter fregRecyclerViewAdapter;
    private Handler handler = new Handler();
    private ProgressDialog progressDialog;


    public static LotteryPagFragment getInstance(int type) {
        LotteryPagFragment lotteryPagFragment = new LotteryPagFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("type", type);
        lotteryPagFragment.setArguments(bundle);
        return lotteryPagFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "---onCreateView----");
        if (NetworkUtil.isNetworkAvailable(getActivity())) {
            view = inflater.inflate(R.layout.fragment_homepage, container, false);
            bundle = getArguments();

            progressDialog = new ProgressDialog(getActivity());
            progressDialog.setMessage("正在加载");
            progressDialog.show();
            handler.postDelayed(() -> progressDialog.dismiss(), 1000);
            initData(view);
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

        } else {
            view = inflater.inflate(R.layout.network_false, container, false);
        }
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "---onResume----");
        if (fregRecyclerViewAdapter != null) {
            fregRecyclerViewAdapter.clearData();
            fregRecyclerViewAdapter.addAllData(list);
        }
    }

    private void initData(View view) {
        type = bundle.getInt("type", 0);
        if (type == 1) {
            list.clear();
            list.add(Config.CPURL1134);
            list.add(Config.CPURL1135);
            list.add(Config.CPURL1136);
            list.add(Config.CPURL1137);
            list.add(Config.CPURL1138);
            list.add(Config.CPURL1139);
            list.add(Config.CPURL1140);
            list.add(Config.CPURL1141);
            list.add(Config.CPURL1142);
            list.add(Config.CPURL1143);
            list.add(Config.CPURL1144);
            list.add(Config.CPURL1145);
            list.add(Config.CPURL1146);
            list.add(Config.CPURL1147);
            list.add(Config.CPURL1149);
            list.add(Config.CPURL1150);
            list.add(Config.CPURL1151);
            list.add(Config.CPURL1152);
            list.add(Config.CPURL1153);
            list.add(Config.CPURL1154);

        } else if (type == 2) {
            list.clear();
            list.add(Config.CPURL1155);
            list.add(Config.CPURL1156);
            list.add(Config.CPURL1157);

            list.add(Config.CPURL1158);
            list.add(Config.CPURL1159);
            list.add(Config.CPURL1160);
            list.add(Config.CPURL1161);
            list.add(Config.CPURL1162);
            list.add(Config.CPURL1163);
            list.add(Config.CPURL1164);
            list.add(Config.CPURL1165);
            list.add(Config.CPURL1166);
            list.add(Config.CPURL1167);
            list.add(Config.CPURL1168);
            list.add(Config.CPURL1169);
            list.add(Config.CPURL1170);

            list.add(Config.CPURL1171);
            list.add(Config.CPURL1172);
            list.add(Config.CPURL1173);
            list.add(Config.CPURL1174);
            list.add(Config.CPURL1175);
        } else if (type == 3) {
            list.clear();
            list.add(Config.CPURL1176);
            list.add(Config.CPURL1177);
            list.add(Config.CPURL1178);
            list.add(Config.CPURL1179);
            list.add(Config.CPURL1180);
            list.add(Config.CPURL1181);
            list.add(Config.CPURL1182);
            list.add(Config.CPURL1183);
            list.add(Config.CPURL1184);
            list.add(Config.CPURL1185);
            list.add(Config.CPURL1186);
            list.add(Config.CPURL1187);
            list.add(Config.CPURL1188);
            list.add(Config.CPURL1189);
            list.add(Config.CPURL1190);
            list.add(Config.CPURL1191);
            list.add(Config.CPURL1192);
            list.add(Config.CPURL1193);
            list.add(Config.CPURL1194);
            list.add(Config.CPURL1195);
            list.add(Config.CPURL1196);


        } else if (type == 4) {
            list.clear();
            list.add(Config.CPURL1196);
            list.add(Config.CPURL1197);
            list.add(Config.CPURL1198);
            list.add(Config.CPURL1199);
            list.add(Config.CPURL1200);
            list.add(Config.CPURL1201);
            list.add(Config.CPURL1202);
            list.add(Config.CPURL1203);
            list.add(Config.CPURL1204);
            list.add(Config.CPURL1205);
            list.add(Config.CPURL1206);
            list.add(Config.CPURL1207);
            list.add(Config.CPURL1208);
            list.add(Config.CPURL1209);
            list.add(Config.CPURL1210);
            list.add(Config.CPURL1211);
            list.add(Config.CPURL1212);
            list.add(Config.CPURL1213);
            list.add(Config.CPURL1214);
        } else if (type == 5) {
            list.clear();
            list.add(Config.CPURL276);
            list.add(Config.CPURL277);
            list.add(Config.CPURL278);
            list.add(Config.CPURL279);
            list.add(Config.CPURL280);
            list.add(Config.CPURL281);
            list.add(Config.CPURL282);
            list.add(Config.CPURL284);
            list.add(Config.CPURL283);
            list.add(Config.CPURL285);
            list.add(Config.CPURL286);
            list.add(Config.CPURL287);
            list.add(Config.CPURL288);
            list.add(Config.CPURL289);
            list.add(Config.CPURL292);
            list.add(Config.CPURL294);
            list.add(Config.CPURL295);
            list.add(Config.CPURL296);
            list.add(Config.CPURL297);
            list.add(Config.CPURL298);
            list.add(Config.CPURL299);

        }
        my_recycler_view = view.findViewById(R.id.recycler);
        //  my_recycler_view.setLinearLayout();
        my_recycler_view.setPullRefreshEnable(false);
        my_recycler_view.setPushRefreshEnable(false);
        //   my_recycler_view.setGridLayout(1);//参数为列数
        my_recycler_view.setLinearLayout();
        Bundle bundle = new Bundle();
        ////设置adapter begin///////////////
        fregRecyclerViewAdapter = new FregRecyclerViewAdapter(getActivity());
        my_recycler_view.setAdapter(fregRecyclerViewAdapter);
        fregRecyclerViewAdapter.addAllData(list);
        ////设置adapter end///////////////
        fregRecyclerViewAdapter.setItemClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        Log.d(TAG, "onItemClick position:" + position);
        bundle.putInt("type", 13);
        bundle.putInt("type1", type);
        bundle.putInt("position", position);
        bundle.putString("title", "资讯详情");
        CommonActivity.launch(getActivity(), bundle, "资讯详情");
    }
}