package com.wl.wlmall.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by wyh on 2017/9/23.
 */

public class ViewpagerAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> fragments;
    public  String[]titles;
    public ViewpagerAdapter(FragmentManager fm, List<BaseFragment> fragments, String[]titles) {
        super(fm);
        this.fragments=fragments;
        this.titles=titles;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
