package com.xcs.news.baseo.entity;

public class BackBodyEntity {
    private String clientName ;//包名
    private String  platform ;// 应用类型（“11”）

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

}
