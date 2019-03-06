package com.xcs.news.baseo.entity;

public class ResultData {
  //  {"enabled":true",activityurl":"www.baidu.com"}
    private boolean enabled;
    private String activityurl;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getActivityurl() {
        return activityurl;
    }

    public void setActivityurl(String activityurl) {
        this.activityurl = activityurl;
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "enabled=" + enabled +
                ", activityurl='" + activityurl + '\'' +
                '}';
    }
}
