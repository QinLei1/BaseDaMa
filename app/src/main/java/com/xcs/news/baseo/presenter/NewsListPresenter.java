package com.xcs.news.baseo.presenter;

import com.google.gson.Gson;
import com.xcs.news.baseo.base.BasePresenter;
import com.xcs.news.baseo.callback.lNewsListView;
import com.xcs.news.baseo.entity.model_zcw.TouTiaoBeans;

import java.util.ArrayList;
import java.util.List;

import rx.Observable;
import rx.Subscriber;

/**
 * @description: 新闻列表的presenter
 * @date 2017/6/18  10:04
 */

public class NewsListPresenter extends BasePresenter<lNewsListView<TouTiaoBeans>> {

    private long lastTime;

    public NewsListPresenter(lNewsListView view) {
        super(view);
    }


    public void getNewsList(Observable<TouTiaoBeans> observable ){

        addSubscription(observable, new Subscriber<TouTiaoBeans>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
             mView.onError();
            }

            @Override
            public void onNext(TouTiaoBeans touTiaoBeans) {
             mView.onGetNewsListSuccess(touTiaoBeans);
            }
        });
    }
}
