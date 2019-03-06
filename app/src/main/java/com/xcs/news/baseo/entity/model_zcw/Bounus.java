package com.xcs.news.baseo.entity.model_zcw;

import java.io.Serializable;

/**
 * Created by HuangYuGuang on 2018/5/17.
 */

public class Bounus implements Serializable{

    private static final long serialVersionUID = -4659545091720557680L;
    /**
     *一等奖
     */
    private String zname;

    /**
     *中奖注数（注）
     */
    private String znum;

    /**
     *单注中奖金额（元）
     */
    private String money;

    public String getZname() {
        return zname;
    }

    public void setZname(String zname) {
        this.zname = zname;
    }

    public String getZnum() {
        return znum;
    }

    public void setZnum(String znum) {
        this.znum = znum;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }
}
