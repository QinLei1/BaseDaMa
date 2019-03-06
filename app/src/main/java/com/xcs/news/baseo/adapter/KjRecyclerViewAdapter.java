package com.xcs.news.baseo.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.entity.OpenCaiDataBean;
import com.xcs.news.baseo.entity.OpenCaiHttpResult;
import com.xcs.news.baseo.entity.caizhong.CZbean;
import com.xcs.news.baseo.net.RetrofitClient;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;

public class KjRecyclerViewAdapter extends RecyclerView.Adapter<KjRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private final String BLUE = "blue";
    private final String RED = "red";
    private List<CZbean> dataList = new ArrayList<>();
    private static String TAG = KjRecyclerViewAdapter.class.getName();
    private final String BASEURL = "http://f.apiplus.net";

    public void addAllData(List<CZbean> dataList) {
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public void clearData() {
        this.dataList.clear();
    }

    public KjRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // public ImageView img;
        public View itemView;
        public TextView tv_CaiZhongName;//彩种名称
        public TextView tv_OpenTime;//开奖时间
        public TextView tv_BlueBall;//兰球
        public LinearLayout layout_RedBall;//红球区域
        public LinearLayout layout_BlueBall;//蓝球区域

        public ViewHolder(View itemView) {
            super(itemView);
            // img = (ImageView) itemView.findViewById(R.id.img);
            tv_CaiZhongName = (TextView) itemView.findViewById(R.id.tv_name);
            tv_OpenTime = (TextView) itemView.findViewById(R.id.tv_time);
            tv_BlueBall = (TextView) itemView.findViewById(R.id.tv_lanqiu);
            layout_RedBall = (LinearLayout) itemView.findViewById(R.id.lay_hongqiu);
            layout_BlueBall = (LinearLayout) itemView.findViewById(R.id.lay_lanqiu);
            this.itemView = itemView;
        }
    }

    @Override
    public KjRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_caizhong, parent, false);
        v.setOnClickListener(this);
        return new KjRecyclerViewAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(KjRecyclerViewAdapter.ViewHolder holder, final int position) {//  holder.ImageView.set(dataList.get(position));

        // holder.img.setImageBitmap(readBitMap(mContext, dataList.get(position)));
        //开启网络请求
        holder.itemView.setTag(dataList.get(position));
//        loadData(mContext, dataList.get(position), holder);
       // holder.itemView.setTag(dataList.get(position).getCzName());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    private Bitmap readBitMap(Context context, int resId) {
        BitmapFactory.Options opt = new BitmapFactory.Options();
        opt.inPreferredConfig = Bitmap.Config.RGB_565;
        opt.inPurgeable = true;
        opt.inInputShareable = true;
        // 获取资源图片
        InputStream is = context.getResources().openRawResource(resId);
        return BitmapFactory.decodeStream(is, null, opt);
    }

    private KjRecyclerViewAdapter.OnItemClickListener mItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(CZbean position);
    }

    public void setItemClickListener(KjRecyclerViewAdapter.OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        if (mItemClickListener != null) {
            mItemClickListener.onItemClick((CZbean) v.getTag());
        }
    }

//    private void loadData(Context context, CZbean cZbean, KjRecyclerViewAdapter.ViewHolder holder) {
//        RetrofitClient.getInstance(/*context,*/ BASEURL).getCZInfo(cZbean.getUrl(), new Callback<OpenCaiHttpResult<OpenCaiDataBean>>() {
//            @Override
//            public void onResponse(Call<OpenCaiHttpResult<OpenCaiDataBean>> call, Response<OpenCaiHttpResult<OpenCaiDataBean>> response) {
//                OpenCaiHttpResult<OpenCaiDataBean> openCaiHttpResult = response.body();
//                if (openCaiHttpResult != null) {
//                    CZbean TagCZbean= (CZbean) holder.itemView.getTag();
//                    if (!TagCZbean.getUrl().equals(cZbean.getUrl())) {
//                        return;
//                    }
//                    OpenCaiDataBean openCaiDataBean = openCaiHttpResult.getData().get(0);
//                    holder.tv_CaiZhongName.setText(cZbean.getCzName());
//                    holder.tv_OpenTime.setText(String.format("第%s期  时间:%s", openCaiDataBean.getExpect(), openCaiDataBean.getOpentime()));
//                    String openCode = openCaiDataBean.getOpencode();
//                    String[] redBall = null;
//                    String[] blueBall = null;
//                    if (openCode.contains("+")) {
//                        redBall = getOpenCodeByColor(RED, openCode);
//                        blueBall = getOpenCodeByColor(BLUE, openCode);
//                    } else {
//                        redBall = openCode.split(",");
//                    }
//                    if (redBall != null) {
//                        holder.layout_RedBall.removeAllViews();
//                        for (String str : redBall) {
//                            TextView tv = (TextView) View.inflate(context, R.layout.textview_hongqiu, null);
//                            tv.setText(str);
//                            holder.layout_RedBall.addView(tv);
//                        }
//
//                    }
//                    if (blueBall != null) {
//                        holder.layout_BlueBall.removeAllViews();
//                        for (String str : blueBall) {
//                            TextView tv = (TextView) View.inflate(context, R.layout.textview_lanqiu, null);
//                            tv.setText(str);
//                            holder.layout_BlueBall.addView(tv);
//                        }
//                    } else {
//                        holder.tv_BlueBall.setVisibility(View.INVISIBLE);
//                    }
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<OpenCaiHttpResult<OpenCaiDataBean>> call, Throwable t) {
//                Log.d(TAG, "onFailure--t" + t);
//            }
//        });
//    }

    private String[] getOpenCodeByColor(String color, String openCode) {
        String str = openCode.replace("+", "h");
        String[] balls = str.split("h");
        if (BLUE.equals(color)) {
            return balls[1].split(",");//蓝球
        } else {
            return balls[0].split(",");//红球
        }
    }



}
