package com.jeisondias.pbl.model;

/**
 * Created by jeiso on 11/7/2016.
 */
import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter{

    //Essa classe vai gerenciar as telas que serão exibidas nos fragmentos ao deslizar o dedo.

    private List<Fragment> mFragments;


    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    //Retorna o Fragment pelo índice
    @Override
    public Fragment getItem(int i) {
        return mFragments.get(i);
    }

    // Retorna a quantidade de Fragments na lista
    @Override
    public int getCount() {
        return mFragments.size();
    }
}