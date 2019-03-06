package com.xcs.news.baseo.entity.model_zcw;

import java.io.Serializable;

/**
 * Created by HuangYuGuang on 2018/5/17.
 */

public class City implements Serializable{

    private static final long serialVersionUID = -3570154855221330604L;
    /**
     * 城市名称
     */
    private String name;

    /**
     * 城市编号
     */
    private String dqId;

    public City() {
    }

    public City(String name, String dqId) {
        this.name = name;
        this.dqId = dqId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDqId() {
        return dqId;
    }

    public void setDqId(String dqId) {
        this.dqId = dqId;
    }
}
