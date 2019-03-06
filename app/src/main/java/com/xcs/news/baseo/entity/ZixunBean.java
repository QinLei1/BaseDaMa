package com.xcs.news.baseo.entity;

public class ZixunBean {
    private String date;
    private String title;
    private String content;
    private int imageId;
    private String url;

    public ZixunBean() {
    }

    public ZixunBean(String date, String title, String content, int imageId) {
        this.date = date;
        this.title = title;
        this.content = content;
        this.imageId = imageId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
