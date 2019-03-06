package com.xcs.news.baseo.adapter;

import android.content.Context;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xcs.news.baseo.R;

import java.util.ArrayList;
import java.util.List;

public class FregRecyclerViewAdapter extends RecyclerView.Adapter<FregRecyclerViewAdapter.ViewHolder> implements View.OnClickListener {
    private static String TAG = FregRecyclerViewAdapter.class.getName();

    private Context mContext;
    private List<String> dataList = new ArrayList<String>();

    public FregRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    public void addAllData(List<String> dataList) {
        this.dataList.clear();
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public void clearData() {
        this.dataList.clear();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView img;
        public View itemView;

        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            this.itemView = itemView;
        }

        public void setBitmapImage(Context context, String imageId) {
            Glide.with(context)
                    .load(imageId)
                    .error(R.mipmap.ic_launcher)
                    .centerCrop()
                    .placeholder(R.mipmap.ic_launcher)
                    .skipMemoryCache(false)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .into(img);
//            Log.d(TAG, "-setBitmapImage :"+imageId);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fre_recycler_view_item, parent, false);
        v.setOnClickListener(this);
        return new FregRecyclerViewAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //holder.img.setImageBitmap(readBitMap(mContext,dataList.get(position)));
//        Log.d(TAG, "---onBindViewHolder----");
        holder.setBitmapImage(mContext, dataList.get(position));
        holder.itemView.setTag(position);
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    private OnItemClickListener mItemClickListener;

    public void setItemClickListener(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    @Override
    public void onClick(View v) {
        if (mItemClickListener != null) {
            mItemClickListener.onItemClick((Integer) v.getTag());
        }
    }
}
