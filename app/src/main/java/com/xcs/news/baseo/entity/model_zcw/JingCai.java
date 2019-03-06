package com.xcs.news.baseo.entity.model_zcw;

import java.io.Serializable;

/**
 * 竞彩（http://m.159cai.com）
 * Created by HuangYuGuang on 2018/5/18.
 */

public class JingCai implements Serializable{

    private static final long serialVersionUID = -6191643531368358886L;
    /**
     * 跳转地址
     */
    private String url;
    /**
     * 图片
     */
    private String image;
    /**
     * 标题
     */
    private String experttitle;
    /**
     * 描述
     */
    private String expertaddtitle;
    /**
     * 命中标志。 1,：命中了   0：没有中
     */
    private String experthit;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getExperttitle() {
        return experttitle;
    }

    public void setExperttitle(String experttitle) {
        this.experttitle = experttitle;
    }

    public String getExpertaddtitle() {
        return expertaddtitle;
    }

    public void setExpertaddtitle(String expertaddtitle) {
        this.expertaddtitle = expertaddtitle;
    }

    public String getExperthit() {
        return experthit;
    }

    public void setExperthit(String experthit) {
        this.experthit = experthit;
    }
}
