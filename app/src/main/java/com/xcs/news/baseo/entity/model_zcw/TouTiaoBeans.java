package com.xcs.news.baseo.entity.model_zcw;

import java.io.Serializable;
import java.util.List;

/**
 * Created by HuangYuGuang on 2018/5/5.
 */

public class TouTiaoBeans implements Serializable{

    private static final long serialVersionUID = 9140251235074146315L;

    private List<TouTiaoBean> dataList;

    private int totalPage;
    private int pageNo;
    private int pageSize;

    public TouTiaoBeans() {
    }

    public TouTiaoBeans(List<TouTiaoBean> dataList) {
        this.dataList = dataList;
    }

    public List<TouTiaoBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<TouTiaoBean> dataList) {
        this.dataList = dataList;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "TouTiaoBeans{" +
                "dataList=" + dataList +
                ", totalPage=" + totalPage +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                '}';
    }
}
