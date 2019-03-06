package com.xcs.news.baseo.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.xcs.news.baseo.R;
import com.xcs.news.baseo.activity.CommonActivity;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<Integer> adapterBeans;
    private Context context;

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image = itemView.findViewById(R.id.item_home_img11);
        }
    }

    public HomeAdapter(List<Integer> adapterBeans, Context context) {
        this.adapterBeans = adapterBeans;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home,
                viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        int adapterBean = adapterBeans.get(i);
        viewHolder.image.setImageResource(adapterBean);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putString("url", "http://www.sporttery.cn/football/jcdj/2014/1017/123451.html");
                bundle.putInt("type", 4);
                CommonActivity.launch(context, bundle, "彩票大全");
            }
        });
    }

    @Override
    public int getItemCount() {
        return adapterBeans.size();
    }
}