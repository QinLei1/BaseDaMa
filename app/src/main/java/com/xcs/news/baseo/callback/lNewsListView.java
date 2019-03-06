package com.xcs.news.baseo.callback;
import java.util.List;

/**
 * @description: 获取各种频道广告的View回调接口
 * @date 2017/6/18  9:33
 */

public interface lNewsListView<T> {

    void onGetNewsListSuccess(T t);

    void  onError();
}
