package com.sixsix.tablayout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by wangxin on 2017/5/12.
 */

public class FragmentTabPagerAdapter extends FragmentPagerAdapter{

    private List<Fragment> fragmentList;                         //fragment列表
    private List<String> fragmentTitleList;                              //tab名的列表



    public FragmentTabPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> fragmentTitleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.fragmentTitleList = fragmentTitleList;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentTitleList.size();
    }

    //此方法用来显示tab上的名字
    @Override
    public CharSequence getPageTitle(int position) {

        return fragmentTitleList.get(position % fragmentTitleList.size());
    }
}