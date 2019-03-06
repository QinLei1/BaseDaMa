package com.xcs.news.baseo.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.xcs.news.baseo.R;
import com.xcs.news.baseo.utils.Config;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Date：2018/4/6 on 下午4:19
 * Describe:
 * Created by:stefan
 */
public class PublicMoenyDetailsFragment extends Fragment {
    private View view;
    private ImageView imgview;
    private List<String> list = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_public_moeny_details, container, false);
        imgview = view.findViewById(R.id.imgview);
        list.clear();
        list.add(Config.CPURL698);
        list.add(Config.CPURL699);
        list.add(Config.CPURL700);
        list.add(Config.CPURL701);
        list.add(Config.CPURL702);
        list.add(Config.CPURL703);
        list.add(Config.CPURL704);
        list.add(Config.CPURL705);
        list.add(Config.CPURL706);
        list.add(Config.CPURL707);
        list.add(Config.CPURL708);
        list.add(Config.CPURL709);
        list.add(Config.CPURL710);
        list.add(Config.CPURL711);
        list.add(Config.CPURL712);
        list.add(Config.CPURL713);
        list.add(Config.CPURL714);
        list.add(Config.CPURL715);
        list.add(Config.CPURL716);
        list.add(Config.CPURL717);

        Random random = new Random();
        int n = random.nextInt(list.size());
        String imgviewId = list.get(n);
        Glide.with(getActivity()).load(imgviewId).skipMemoryCache(false).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imgview);
        return view;
    }
}
