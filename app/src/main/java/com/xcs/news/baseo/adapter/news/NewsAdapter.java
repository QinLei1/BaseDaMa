package com.xcs.news.baseo.adapter.news;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.adapter.common.CommonRecycleAdapter;
import com.xcs.news.baseo.adapter.common.CommonViewHolder;
import com.xcs.news.baseo.entity.model_zcw.TouTiaoBean;
import com.xcs.news.baseo.utils.GlideUtils;

import java.util.List;

public class NewsAdapter extends CommonRecycleAdapter<TouTiaoBean> {
    private Context context;
    private CommonViewHolder.onItemCommonClickListener commonClickListener;
    public NewsAdapter(Context context, List<TouTiaoBean> dataList, int layoutId) {
        super(context, dataList, layoutId);
        this.context = context;
    }
    public NewsAdapter(Context context, List<TouTiaoBean> dataList, int layoutId,CommonViewHolder.onItemCommonClickListener commonClickListener) {
        super(context, dataList, layoutId);
        this.context = context;
        this.commonClickListener = commonClickListener;
    }
    @Override
    public void bindData(CommonViewHolder holder, TouTiaoBean data) {
        if (data == null) {
            return;
        }
        if (TextUtils.isEmpty(data.getLogoFile())) {
            holder.getView(R.id.iv_news).setVisibility(View.INVISIBLE);
        } else {
            GlideUtils.load(context, data.getLogoFile(), holder.getView(R.id.iv_news));
        }
        holder.setText(R.id.tv_title, data.getTitle())
                .setText(R.id.tv_content, data.getSummary());
        holder.setCommonClickListener(commonClickListener);
    }
}
