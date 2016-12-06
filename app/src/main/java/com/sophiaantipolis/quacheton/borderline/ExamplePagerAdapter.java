package com.sophiaantipolis.quacheton.borderline;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import org.w3c.dom.Text;

/**
 * Created by Blfab on 26/09/2016.
 */
public class ExamplePagerAdapter extends FragmentStatePagerAdapter {
    public ExamplePagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        Fragment fragment = null;
        switch (i) {
            case 0:
                fragment = new GameFragment();
                break;

            case 1:
                fragment = new  OptionFragment();
                break;
            case 2:
                fragment = new ScoreFragment();
                break;
            default:
                break;
        }

        return fragment;
    }

    @Override
    public int getCount() {
        //le nombre d’onglet
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return "myFrag";
    }
}
