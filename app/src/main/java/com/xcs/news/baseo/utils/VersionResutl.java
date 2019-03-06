package com.xcs.news.baseo.utils;

import com.xcs.news.baseo.entity.Resutl;

/**
 * Date：2018/3/6 on 下午4:23
 * Describe:
 * Created by:stefan
 */
public class VersionResutl extends Resutl {


    /**
     * data : {"hasnew":true,"url":"www.baidu.com"}
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * hasnew : true
         * url : www.baidu.com
         */

        private boolean hasNew;
        private String url;

        public boolean isHasNew() {
            return hasNew;
        }

        public void setHasNew(boolean hasNew) {
            this.hasNew = hasNew;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
