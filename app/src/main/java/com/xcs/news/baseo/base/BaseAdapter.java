package com.xcs.news.baseo.base;

import android.content.Context;

import com.xcs.news.baseo.adapter.common.CommonRecycleAdapter;
import com.xcs.news.baseo.adapter.common.CommonViewHolder;

import java.util.List;

public abstract class BaseAdapter<T> extends CommonRecycleAdapter<T> {

    private Context context;
    private CommonViewHolder.onItemCommonClickListener commonClickListener;

    public BaseAdapter(Context context, List<T> dataList, int layoutId) {
        super(context, dataList, layoutId);
        this.context = context;
    }

    public BaseAdapter(Context context, List<T> dataList, int layoutId, CommonViewHolder.onItemCommonClickListener commonClickListener) {
        super(context, dataList, layoutId);
        this.context = context;
        this.commonClickListener = commonClickListener;
    }

    @Override
    public void bindData(CommonViewHolder holder, T data) {
        holder.setCommonClickListener(commonClickListener);
        doSomething(holder, data);
    }

    public abstract void doSomething(CommonViewHolder holder, T data);
}
