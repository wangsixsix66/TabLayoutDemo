package com.sixsix.tablayout;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private NoScrollViewPager viewPager;
    private List<String> mTabTexts;
    private ArrayList<Fragment> mFragmentsList;
    private FragmentTabPagerAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (NoScrollViewPager) findViewById(R.id.viewpager);

        mTabTexts = new ArrayList<>();
        mTabTexts.add("预定选房");
        mTabTexts.add("租约信息");
        mTabTexts.add("预定协议");
        mTabTexts.add("确认提交");
        mFragmentsList = new ArrayList<>();
        mFragmentsList.add(new SelectRoomReserveFragment());
        mFragmentsList.add(new LeaseInfoReserveFragment());
        mFragmentsList.add(new LeaseInfoReserveFragment());
        mFragmentsList.add(new LeaseInfoReserveFragment());
        for (int i = 0; i < mTabTexts.size(); i++) {
            tabLayout.addTab(tabLayout.newTab().setText(mTabTexts.get(i)));
        }


        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        pageAdapter = new FragmentTabPagerAdapter(getSupportFragmentManager(), mFragmentsList, mTabTexts);
        viewPager.setAdapter(pageAdapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.setCurrentItem(0);//设置默认选中某个tab
        viewPager.setNeedScroll(false);
        setTabLayoutCanClick(false);
    }

    public void setTabLayoutCanClick(boolean canClick) {
        LinearLayout tabStrip = (LinearLayout) tabLayout.getChildAt(0);
        for (int i = 0; i < tabStrip.getChildCount(); i++) {
            View tabView = tabStrip.getChildAt(i);
            if (tabView != null) {
                tabView.setClickable(canClick);
            }
        }
    }
}
