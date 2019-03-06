package com.xcs.news.baseo.callback.base;

import java.io.Serializable;

/**
 * Created by HuangYuGuang on 2018/5/7.
 */

public interface ISwipeListView<B extends Serializable, Bs extends Serializable> {

    void onGetSwipeListSuccess(Bs t);

    void  onError();
}
