package com.jeisondias.pbl.model;

/**
 * Created by jeiso on 11/7/2016.
 */
import android.app.Fragment;
import android.os.Bundle;

/**
 * Created by jeiso on 11/6/2016.
 */

public class TabInfo {

    private Class<?> clss;
    private Bundle args;
    private Fragment fragment;
    public String tag;

    // Informação da Tab
    public TabInfo(String tag, Class<?> clazz, Bundle args) {
        this.tag = tag;
        this.clss = clazz;
        this.args = args;
    }
}
