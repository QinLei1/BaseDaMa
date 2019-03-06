package com.xcs.news.baseo.utils;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xcs.news.baseo.R;


/**
 * @author ChayChan
 * @description: 对glide进行封装的工具类
 * @date 2017/6/19  20:43
 */

public class GlideUtils {

    public static void load(Context context, String url, ImageView iv) {

        Glide.with(context)
                .load(url)
                .error(R.mipmap.ic_default)
                .centerCrop()
                .placeholder(R.mipmap.ic_default)
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(iv);
    }

    public static void load(Context context, String url, ImageView iv, int placeHolderResId) {
        if (placeHolderResId == -1) {
            Glide.with(context)
                    .load(url)
                    .into(iv);
            return;
        }
        Glide.with(context)
                .load(url)
                .error(R.mipmap.ic_default)
                .centerCrop()
                .placeholder(placeHolderResId)
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(iv);
    }

    public static void loadRound(Context context, String url, ImageView iv) {
        Glide.with(context)
                .load(url)
                .error(R.mipmap.ic_circle_default)
                .centerCrop()
                .placeholder(R.mipmap.ic_circle_default)
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .into(iv);
    }
}
