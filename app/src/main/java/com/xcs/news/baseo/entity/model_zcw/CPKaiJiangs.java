package com.xcs.news.baseo.entity.model_zcw;

import java.io.Serializable;
import java.util.List;

/**
 * 开奖结果
 * Created by HuangYuGuang on 2018/5/10.
 */

public class CPKaiJiangs implements Serializable{

    private static final long serialVersionUID = 8051195975221425971L;
    /**
     * 开奖直播室
     */
    private String url;

    private String textTitle;

    private String lottery;

    private String pageNo;

    private String pageSize;

    private String totalPage;

    private List<CPKaiJiang> dataList;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public void setTextTitle(String textTitle) {
        this.textTitle = textTitle;
    }

    public String getLottery() {
        return lottery;
    }

    public void setLottery(String lottery) {
        this.lottery = lottery;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(String totalPage) {
        this.totalPage = totalPage;
    }

    public List<CPKaiJiang> getDataList() {
        return dataList;
    }

    public void setDataList(List<CPKaiJiang> dataList) {
        this.dataList = dataList;
    }
}
