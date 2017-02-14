package com.example.hante.thirdopen;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created By HanTe
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragmentList;
    private List<String> mListString;

    public ViewPagerAdapter (FragmentManager fm, List<Fragment> fragmentList,
                             List<String> listString) {
        super(fm);
        this.mFragmentList = fragmentList;
        this.mListString = listString;
    }



    @Override
    public Fragment getItem (int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount () {
        return mListString.size();
    }

    @Override
    public CharSequence getPageTitle (int position) {
        return mListString.get(position % mListString.size());
    }
}
