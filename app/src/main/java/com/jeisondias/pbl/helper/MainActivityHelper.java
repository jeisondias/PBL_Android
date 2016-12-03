package com.jeisondias.pbl.helper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TabHost;

import com.jeisondias.pbl.R;
import com.jeisondias.pbl.dao.DisciplinaDAO;
import com.jeisondias.pbl.model.Disciplina;
import com.jeisondias.pbl.model.TabFactory;
import com.jeisondias.pbl.model.TabInfo;
import com.jeisondias.pbl.model.ViewPagerAdapter;
import com.jeisondias.pbl.tab.TabFragmentAluno;
import com.jeisondias.pbl.tab.TabFragmentDisciplina;
import com.jeisondias.pbl.tab.TabFragmentTurma;
import com.jeisondias.pbl.view.DisciplinaActivity;
import com.jeisondias.pbl.view.MainActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

/**
 * Created by jeiso on 10/6/2016.
 */
public class MainActivityHelper implements TabHost.OnCreateContextMenuListener, ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {

    private MainActivity mActivity;

    private static Disciplina disciplina;
    private DisciplinaDAO bancoD;
    private ArrayList<Disciplina> disciplinas;
    private ArrayAdapter<Disciplina> adapter;
    private Intent intent;

    private ListView listV;
    private Button botaoAdd;

    //Administração Tabs
    private TabHost mTabHost;
    private ViewPager mViewPager;
    private HashMap<String, TabInfo> mapTabInfo = new HashMap<String, TabInfo>();
    private PagerAdapter mPagerAdapter;

    public MainActivityHelper(MainActivity mActivity){
        this.mActivity = mActivity;
        componentesStart();
        exibeLista();
    }

    public void exibeLista() {
        disciplinas = bancoD.getDisciplina();
        adapter = new ArrayAdapter<Disciplina>(mActivity, android.R.layout.simple_list_item_1, disciplinas);
        //listV.setAdapter(adapter);
    }

    private void componentesStart() {
        disciplinas = new ArrayList<>();
        bancoD = new DisciplinaDAO(mActivity.getApplicationContext());
    }

    private void funcBotao(Button button){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent  = new Intent(mActivity, DisciplinaActivity.class);
                mActivity.startActivity(intent);
            }
        });
    }

    public void contextMenu(ContextMenu menu){
        MenuItem atualizarM = menu.add("Atualizar");
        atualizarM.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                intent = new Intent(mActivity, DisciplinaActivity.class);
                intent.putExtra("disciplina", disciplina);
                System.out.println("Disciplina Id Intent" + disciplina.getCodigo());
                mActivity.startActivity(intent);
                return false;
            }
        });

        MenuItem deletarM = menu.add("Deletar");
        deletarM.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                bancoD.deletD(disciplina);
                return false;
            }
        });
    }

    protected void onSaveInstanceState(Bundle outState){
        outState.putString("tab", mTabHost.getCurrentTabTag());
    }
    public void initialiseTabHost(Bundle args) {
        mTabHost = (TabHost) mActivity.findViewById(R.id.tabhost);
        mTabHost.setup();

        TabInfo tabInfo = null;
        AddTab(mActivity, this.mTabHost,
                this.mTabHost.newTabSpec("Tab1").setIndicator("Aluno"),
                (tabInfo = new TabInfo("Tab1", TabFragmentAluno.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        AddTab(mActivity, this.mTabHost,
                this.mTabHost.newTabSpec("Tab2").setIndicator("Disciplina"),
                (tabInfo = new TabInfo("Tab2", TabFragmentDisciplina.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        AddTab(mActivity, this.mTabHost,
                this.mTabHost.newTabSpec("Tab3").setIndicator("Turma"),
                (tabInfo = new TabInfo("Tab3", TabFragmentTurma.class, args)));
        this.mapTabInfo.put(tabInfo.tag, tabInfo);
        mTabHost.setOnTabChangedListener(this);
    }


    public void intialiseViewPager(){

        List<Fragment> fragments = new Vector<Fragment>();
        fragments.add(Fragment.instantiate(mActivity, TabFragmentAluno.class.getName()));
        fragments.add(Fragment.instantiate(mActivity, TabFragmentDisciplina.class.getName()));
        fragments.add(Fragment.instantiate(mActivity, TabFragmentTurma.class.getName()));
        this.mPagerAdapter = new ViewPagerAdapter(mActivity.getSupportFragmentManager(), fragments);
        this.mViewPager = (ViewPager) mActivity.findViewById(R.id.viewpager);
        this.mViewPager.setAdapter(this.mPagerAdapter);
        this.mViewPager.addOnPageChangeListener(this);

    }

    private static void AddTab(MainActivity activity, TabHost tabHost, TabHost.TabSpec tabSpec, TabInfo tabInfo){
        // Attach uma Tab View factory para o spec
        tabSpec.setContent(new TabFactory(activity));
        tabHost.addTab(tabSpec);
    }

    public void onTabChanged(String tag){
        // Avisa para o mViewPager qual a Tab que está ativa
        int pos = this.mTabHost.getCurrentTab();
        this.mViewPager.setCurrentItem(pos);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        this.mTabHost.setCurrentTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

    }

}


