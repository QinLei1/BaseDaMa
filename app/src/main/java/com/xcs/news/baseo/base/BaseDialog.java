package com.xcs.news.baseo.base;

import android.app.Dialog;
import android.content.Context;

/**
 * Date：2018/1/30 on 下午3:02
 * Describe:
 * Created by:stefan
 */
public class BaseDialog extends Dialog {
    private int res;

    public BaseDialog(Context context, int theme, int res) {
        super(context, theme);
        setContentView(res);
        this.res = res;
    }
}
