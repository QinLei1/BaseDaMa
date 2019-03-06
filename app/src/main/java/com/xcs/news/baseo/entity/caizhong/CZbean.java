package com.xcs.news.baseo.entity.caizhong;

public class CZbean {
    private String czName;
    private String url;

    public CZbean() {
    }

    public CZbean(String czName, String url) {
        this.czName = czName;
        this.url = url;
    }

    public String getCzName() {
        return czName;
    }

    public void setCzName(String czName) {
        this.czName = czName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "CZbean{" +
                "czName='" + czName + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
