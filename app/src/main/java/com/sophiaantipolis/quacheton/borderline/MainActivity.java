package com.sophiaantipolis.quacheton.borderline;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import io.realm.Realm;
import io.realm.RealmConfiguration;


public class MainActivity extends AppCompatActivity{

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.mytoolbar);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.mytabs);
        tabLayout.setupWithViewPager(viewPager);

       /*----Realm----*/
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder().build();
        Realm.deleteRealm(realmConfig); // Delete Realm between app restarts.
        Realm.setDefaultConfiguration(realmConfig);
    }

    private void setViewPager(ViewPager viewPager) {
        ExamplePagerAdapter adapter = new ExamplePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new GameFragment(), getString(R.string.Game));
        adapter.addFragment(new OptionFragment(),getString(R.string.Option));
        adapter.addFragment(new ScoreFragment(), getString(R.string.Score));
        viewPager.setAdapter(adapter);
    }
}