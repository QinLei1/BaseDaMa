package com.xcs.news.baseo.api;

import rx.Subscriber;

/**
 * @author ChayChan
 * @description: 抽取CallBack
 * @date 2017/6/18  21:37
 */
public abstract class SubscriberCallBack<T> extends Subscriber<Object/*ResultResponse<T>*/> {

    @Override
    public void onNext(Object/*ResultResponse*/ response) {
     /*   boolean isSuccess = (!TextUtils.isEmpty(response.message) && response.message.equals("success"))
                || !TextUtils.isEmpty(response.success) && response.success.equals("true");
        if (isSuccess) {
            onSuccess((T) response.data);
        } else {
            UIUtils.showToast(response.message);
            onFailure(response);
        }*/
    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

        onError();
    }

    protected abstract void onSuccess(T response);
    protected abstract void onError();

    protected void onFailure(Object/*ResultResponse*/ response) {

    }

}
