package com.sophiaantipolis.quacheton.borderline;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener, OptionFragment.OnActionListener{

    private PagerAdapter mExamplePagerAdapter;
    private ViewPager mViewPager;
    GameFragment gameFragment = new GameFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ActionBar actionBar = getSupportActionBar();

        mViewPager = (ViewPager) findViewById(R.id.pager);
        mExamplePagerAdapter = new ExamplePagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mExamplePagerAdapter);

        /*----CREATION DES ONGLETS DE NAVIGATION AVEC L'ACTION BAR----*/
        actionBar.addTab(actionBar.newTab().setText(getResources().getString(R.string.Game)).setTabListener(this));
        actionBar.addTab(actionBar.newTab().setText(getResources().getString(R.string.Option)).setTabListener(this));


        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
                    @Override
                    public void onPageSelected(int position) {
                         /*----AFFICHE L'ONGLET CORRESPONDANT APRES AVOIR GLISSE VERS UNE AUTRE PAGE----*/
                        getSupportActionBar().setSelectedNavigationItem(position);
                    }
                });

    /*----AFFICHAGE DU MODE DE NAGIVATION SOUS FORME D'ONGLET----*/
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
    }

    /*----AFFICHAGE DU CONTENU LORS DE L'APPUI SUR UN ONGLET----*/
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void OnAction(int position) {
    }

}