package com.xcs.news.baseo.entity.model_zcw;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by HuangYuGuang on 2018/5/17.
 */
public class CitysBean implements Serializable{

    private static final long serialVersionUID = -2270352129732839206L;
    private String newFlag;

    private List<Citys> dataList;

    public String getNewFlag() {
        return newFlag;
    }

    public void setNewFlag(String newFlag) {
        this.newFlag = newFlag;
    }

    public List<Citys> getDataList() {
        return dataList;
    }

    public void setDataList(List<Citys> dataList) {
        this.dataList = dataList;
    }

    public List<City> getCityList(){
        if(dataList == null || dataList.size() == 0){
            return null;
        }
        List<City> cityList = new ArrayList<>();
        for(Citys citys:dataList){
            for(City city:citys.getCity()){
                cityList.add(city);
            }
        }
        return cityList;
    }
}
