package com.xcs.news.baseo.base;


import com.xcs.news.baseo.callback.base.ISwipeListView;

import java.io.Serializable;

import rx.Observable;
import rx.Subscriber;

/**
 * @author ChayChan
 * @description: 头条资讯列表的presenter
 * @date 2017/6/18  10:04
 */

public class SwipeListPresenter<B extends Serializable, Bs extends Serializable> extends BasePresenter<ISwipeListView<B,Bs>> {


    public SwipeListPresenter(ISwipeListView view) {
        super(view);
    }


    public void  getList(Observable<Bs> observable){
        if(observable == null){
            return;
        }

        addSubscription(observable, new Subscriber<Bs>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                mView.onError();
            }

            @Override
            public void onNext(Bs response) {
                mView.onGetSwipeListSuccess(response);
            }
        });
    }

}
