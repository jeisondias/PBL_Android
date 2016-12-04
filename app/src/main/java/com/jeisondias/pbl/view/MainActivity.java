package com.jeisondias.pbl.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.View;
import android.widget.TabHost;

import com.jeisondias.pbl.R;
import com.jeisondias.pbl.helper.MainActivityHelper;


public class MainActivity extends AppCompatActivity {

    private MainActivityHelper helperM;
    private TabHost mTabHost;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        helperM = new MainActivityHelper(this);
        helperM.initialiseTabHost(savedInstanceState);
        if (savedInstanceState != null){
//            mTabHost.setCurrentTabByTag(savedInstanceState.getString("tab"));
        }
        helperM.intialiseViewPager();
    }

    @Override
    protected void onResume(){
        super.onResume();
        helperM = new MainActivityHelper(this);
        //helperM.exibeLista();
    }

   /* @Override
    public void onCreateContextMenu(ContextMenu menu, View view, ContextMenu.ContextMenuInfo menuInfo){
        helperM = new MainActivityHelper(this);
        helperM.contextMenu(menu);
        super.onCreateContextMenu(menu, view, menuInfo);
    }*/

}