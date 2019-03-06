package com.xcs.news.baseo.entity.model_zcw;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HuangYuGuang on 2018/5/17.
 */

public class Citys implements Serializable{

    private static final long serialVersionUID = -6617300596951385725L;
    /**
     * 地区
     */
    private String qyName;

    /**
     * 城市列表
     */
    private List<City> city;

    public String getQyName() {
        return qyName;
    }

    public void setQyName(String qyName) {
        this.qyName = qyName;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }
}
