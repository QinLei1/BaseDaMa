package com.xcs.news.baseo.entity.model_zcw;

import java.io.Serializable;
import java.util.List;

/**
 * 开奖结果
 * Created by HuangYuGuang on 2018/5/10.
 */

public class CPKaiJiang implements Serializable{

    private static final long serialVersionUID = -1100448524818439135L;
    /**
     * 彩票类型 FC_SSQ：双色球  FC_3：福彩3D  FC_QLC：七乐彩
     */
    private String lottery;
    /**
     * 彩种id
     */
    private String czId;
    /**
     * 彩种名字
     */
    private String czname;
    /**
     *第几期开奖
     */
    private String kjIssue;
    /**
     *开奖时间
     */
    private String kjdate;
    /**
     * 红球
     */
    private String kjznum;
    /**
     *篮球
     */
    private String kjtnum;

    /**
     * 福彩3D(本期销售)
     */
    private String tzmoney;

    /**
     *销量和奖池
     */
    private List<KaiJiang1> mlist;

    /**
     * 多少等奖
     */
    private List<Bounus> bonus;

    public String getCzId() {
        return czId;
    }

    public void setCzId(String czId) {
        this.czId = czId;
    }

    public String getCzname() {
        return czname;
    }

    public void setCzname(String czname) {
        this.czname = czname;
    }

    public String getKjIssue() {
        return kjIssue;
    }

    public void setKjIssue(String kjIssue) {
        this.kjIssue = kjIssue;
    }

    public String getKjdate() {
        return kjdate;
    }

    public void setKjdate(String kjdate) {
        this.kjdate = kjdate;
    }

    public String getKjznum() {
        return kjznum;
    }

    public void setKjznum(String kjznum) {
        this.kjznum = kjznum;
    }

    public String getKjtnum() {
        return kjtnum;
    }

    public void setKjtnum(String kjtnum) {
        this.kjtnum = kjtnum;
    }

    public List<KaiJiang1> getMlist() {
        return mlist;
    }

    public void setMlist(List<KaiJiang1> mlist) {
        this.mlist = mlist;
    }

    public List<Bounus> getBonus() {
        return bonus;
    }

    public void setBonus(List<Bounus> bonus) {
        this.bonus = bonus;
    }

    public String getTzmoney() {
        return tzmoney;
    }

    public void setTzmoney(String tzmoney) {
        this.tzmoney = tzmoney;
    }

    public String getLottery() {
        return lottery;
    }

    public void setLottery(String lottery) {
        this.lottery = lottery;
    }
}
