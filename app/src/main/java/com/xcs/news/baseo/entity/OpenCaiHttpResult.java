package com.xcs.news.baseo.entity;

import java.util.List;

public class OpenCaiHttpResult<T> {
    //    {
//        "rows": 1,
//            "code": "dlt",
//            "info": "免费接口随机延迟3-6分钟，实时接口请访问www.opencai.net查询、购买或续费",
//            "data": [{
//        "expect": "2018058",
//                "opencode": "09,11,12,26,32+04,10",
//                "opentime": "2018-05-21 20:33:20",
//                "opentimestamp": 1526906000
//    }]
//    }
    private int rows;
    private String code;
    private String info;
    private List<T> data;

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
