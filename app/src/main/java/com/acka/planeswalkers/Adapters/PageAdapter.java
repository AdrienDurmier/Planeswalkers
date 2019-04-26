package com.acka.planeswalkers.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.acka.planeswalkers.Controllers.Fragments.TabSetFragment;
import com.acka.planeswalkers.Controllers.Fragments.TabCardFragment;
import com.acka.planeswalkers.Controllers.Fragments.TabDeckFragment;
import com.acka.planeswalkers.Controllers.Fragments.TabRulingFragment;
import com.acka.planeswalkers.Controllers.Fragments.TabTokenFragment;


public class PageAdapter extends FragmentPagerAdapter {


    //Default Constructor
    public PageAdapter(FragmentManager mgr) {
        super(mgr);
    }

    @Override
    public int getCount() {
        return(5);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return TabSetFragment.newInstance();
            case 1:
                return TabCardFragment.newInstance();
            case 2:
                return TabDeckFragment.newInstance();
            case 3:
                return TabRulingFragment.newInstance();
            case 4:
                return TabTokenFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "Sets";
            case 1:
                return "Cards";
            case 2:
                return "Decks";
            case 3:
                return "Rulings";
            case 4:
                return "Tokens";
            default:
                return null;
        }
    }
}
