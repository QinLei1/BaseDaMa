package com.xcs.news.baseo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Date：2018/3/6 on 下午2:51
 * Describe:
 * Created by:stefan
 */
public class SharePreferenceUtil {
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public SharePreferenceUtil(Context context, String file) {
        sp = context.getSharedPreferences(file, Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public void setIp(String ip) {
        editor.putString("ip", ip);
        editor.commit();
    }

    public String getIp() {
        return sp.getString("ip", "http://www.bx7zc.cc/api/");
    }

    public void setLogin(boolean fig) {
        editor.putBoolean("fig", fig);
        editor.commit();
    }

    public boolean getLogin() {
        return sp.getBoolean("fig", false);
    }

    public String getName() {
        return sp.getString("name", "小明");
    }

    public void setName(String name) {
        editor.putString("name", name);
        editor.commit();
    }

    public String getSex() {
        return sp.getString("sex", "男");
    }

    public void setSex(String sex) {
        editor.putString("sex", sex);
        editor.commit();
    }

    public String getBitmap() {
        return sp.getString("bitmap", "");
    }

    public void setBitmap(String bitmap) {
        editor.putString("bitmap", bitmap);
        editor.commit();
    }

    public boolean getOne() {
        return sp.getBoolean("one", false);
    }

    public void setOne(boolean fig) {
        editor.putBoolean("one", fig);
        editor.commit();
    }
    public boolean getTwo() {
        return sp.getBoolean("two", false);
    }

    public void setTwo(boolean fig) {
        editor.putBoolean("two", fig);
        editor.commit();
    }
    public boolean getThree() {
        return sp.getBoolean("three", false);
    }

    public void setThree(boolean fig) {
        editor.putBoolean("three", fig);
        editor.commit();
    }
}
