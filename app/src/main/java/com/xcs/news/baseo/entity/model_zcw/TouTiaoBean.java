package com.xcs.news.baseo.entity.model_zcw;

import java.io.Serializable;

/**
 * Created by HuangYuGuang on 2018/5/5.
 */

public class TouTiaoBean implements Serializable{
    private static final long serialVersionUID = -5197582011059204249L;
    /**
     * 图片
     */
    private String logoFile;

    public TouTiaoBean(String title,String summary,String url,String logoFile, String publishDate ) {
        this.logoFile = logoFile;
        this.publishDate = publishDate;
        this.summary = summary;
        this.title = title;
        this.url = url;
    }

    /**
     *发布时间
     */
    private String publishDate;
    /**
     *描述
     */
    private String summary;
    /**
     *标题
     */
    private String title;
    /**
     *链接
     */
    private String url;

    /*-------------------------159彩票----------------------------------------------*/
    /**
     * 发布时间
     */
    private String pubdate;

    /**
     * 内容描述
     */
    private String contents;

    /**
     * 图片
     */
    private String image;
    /*-------------------------159彩票----------------------------------------------*/
    public TouTiaoBean() {
    }


    public String getLogoFile() {
        return logoFile;
    }

    public void setLogoFile(String logoFile) {
        this.logoFile = logoFile;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "TouTiaoBean{" +
                "logoFile='" + logoFile + '\'' +
                ", publishDate='" + publishDate + '\'' +
                ", summary='" + summary + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", pubdate='" + pubdate + '\'' +
                ", contents='" + contents + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}
