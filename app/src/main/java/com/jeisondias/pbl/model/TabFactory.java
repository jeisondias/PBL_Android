package com.jeisondias.pbl.model;

/**
 * Created by jeiso on 11/7/2016.
 */
import android.content.Context;
import android.view.View;
import android.widget.TabHost;

/**
 * Created by jeiso on 11/6/2016.
 */

// TabFactory para retornar a View para o TabHost

public class TabFactory implements TabHost.TabContentFactory{

    private final Context mContext;

    public TabFactory(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public View createTabContent(String tag) {
        View viewTab = new View(mContext);
        viewTab.setMinimumWidth(0);
        viewTab.setMinimumHeight(0);
        return viewTab;
    }
}