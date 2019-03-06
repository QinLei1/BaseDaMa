package com.xcs.news.baseo.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.adapter.common.CommonRecycleAdapter;
import com.xcs.news.baseo.adapter.common.CommonViewHolder;
import com.xcs.news.baseo.entity.OpenCaiDataBean;

import java.util.List;

public class HistoryKjAdapter extends CommonRecycleAdapter<OpenCaiDataBean> {
    private final String BLUE = "blue";
    private final String RED = "red";
    private String czName;
    private Context context;

    public HistoryKjAdapter(Context context, List<OpenCaiDataBean> dataList, int layoutId) {
        super(context, dataList, layoutId);
        this.context = context;


    }

    public String getCzName() {
        return czName;
    }

    public void setCzName(String czName) {
        this.czName = czName;
    }

    @Override
    public void bindData(CommonViewHolder holder, OpenCaiDataBean data) {
        TextView tv_CaiZhongName = (TextView) holder.getView(R.id.tv_name);
        TextView tv_OpenTime = (TextView) holder.getView(R.id.tv_time);
        TextView tv_BlueBall = (TextView) holder.getView(R.id.tv_lanqiu);
        LinearLayout layout_RedBall = (LinearLayout) holder.getView(R.id.lay_hongqiu);
        LinearLayout layout_BlueBall = (LinearLayout) holder.getView(R.id.lay_lanqiu);
        ImageView more = (ImageView) holder.getView(R.id.img_more);
        more.setVisibility(View.INVISIBLE);
        /////////////////////////////////
        tv_CaiZhongName.setText(czName);
        tv_OpenTime.setText(String.format("第%s期  时间:%s", data.getExpect(), data.getOpentime()));
        String openCode = data.getOpencode();
        String[] redBall = null;
        String[] blueBall = null;
        if (openCode.contains("+")) {
            redBall = getOpenCodeByColor(RED, openCode);
            blueBall = getOpenCodeByColor(BLUE, openCode);
        } else {
            redBall = openCode.split(",");
        }
        if (redBall != null) {
            layout_RedBall.removeAllViews();
            for (String str : redBall) {
                TextView tv = (TextView) View.inflate(context, R.layout.textview_hongqiu, null);
                tv.setText(str);
                layout_RedBall.addView(tv);
            }

        }
        if (blueBall != null) {
            layout_BlueBall.removeAllViews();
            for (String str : blueBall) {
                TextView tv = (TextView) View.inflate(context, R.layout.textview_lanqiu, null);
                tv.setText(str);
                layout_BlueBall.addView(tv);
            }
        } else {
            tv_BlueBall.setVisibility(View.INVISIBLE);
        }

    }

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
