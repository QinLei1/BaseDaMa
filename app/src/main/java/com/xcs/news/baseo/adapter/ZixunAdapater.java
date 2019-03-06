package com.xcs.news.baseo.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xcs.news.baseo.MyApp;
import com.xcs.news.baseo.R;
import com.xcs.news.baseo.activity.CommonActivity;
import com.xcs.news.baseo.entity.ZixunBean;

import java.util.ArrayList;
import java.util.List;

public class ZixunAdapater extends RecyclerView.Adapter<ZixunAdapater.ViewHolder> {
    private List<ZixunBean> zixunBeans;
    private Context context;

    public ZixunAdapater(List<ZixunBean> zixunBeans, Context context) {
        this.zixunBeans = zixunBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_zixun,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ZixunBean zixunBean = zixunBeans.get(position);
        holder.title.setText(zixunBean.getTitle());
        holder.date.setText(zixunBean.getDate());
        holder.content.setText(zixunBean.getContent());
        holder.image.setImageResource(zixunBean.getImageId());
    }

    @Override
    public int getItemCount() {
        return zixunBeans.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView date;
        private TextView title;
        private TextView content;
        private ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.item_zixun_date);
            title = itemView.findViewById(R.id.item_zixun_title);
            content = itemView.findViewById(R.id.item_zixun_content);
            image = itemView.findViewById(R.id.item_zixun_image);
        }
    }
}
