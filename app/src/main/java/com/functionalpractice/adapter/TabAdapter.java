package com.functionalpractice.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabWidget;

import com.functionalpractice.DummyTabFactory;

import java.util.ArrayList;

/**
 * Created by nichol on 16/1/12.
 */
public class TabAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener {

    private Context mContext;
    private TabHost mTabHost;
    private ViewPager mViewPager;
    private final ArrayList<TabInfo> mTabs = new ArrayList<>();

    public TabAdapter(Context context, TabHost tabHost, ViewPager viewPager, FragmentManager fm) {
        super(fm);
        mContext = context;
        mTabHost = tabHost;
        mViewPager = viewPager;
        mViewPager.setAdapter(this);
        mTabHost.setOnTabChangedListener(this);
    }

    public void addTab(TabHost.TabSpec tabSpec, Class<?> clss, Bundle args) {
        tabSpec.setContent(new DummyTabFactory(mContext));
        String tag = tabSpec.getTag();
        TabInfo info = new TabInfo(tag, clss, args);
        mTabs.add(info);
        mTabHost.addTab(tabSpec);
        notifyDataSetChanged();
    }

    @Override
    public Fragment getItem(int position) {
        TabInfo info = mTabs.get(position);
        Fragment fragment = Fragment.instantiate(mContext, info.clss.getName(), info.args);
        return fragment;
    }

    @Override
    public int getCount() {
        return mTabs.size();
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        TabWidget widget = mTabHost.getTabWidget();
        widget.setShowDividers(TabWidget.SHOW_DIVIDER_NONE);
        int oldFocusability = widget.getDescendantFocusability();
        widget.setDescendantFocusability(ViewGroup.FOCUS_BLOCK_DESCENDANTS);
        mTabHost.setCurrentTab(position);
        widget.setDescendantFocusability(oldFocusability);

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTabChanged(String tabId) {
        int position = mTabHost.getCurrentTab();
        mViewPager.setCurrentItem(position,false);

    }

    class TabInfo {
        private final String tag;
        private final Class<?> clss;
        private final Bundle args;

        TabInfo(String _tag, Class<?> _class, Bundle _args) {
            tag = _tag;
            clss = _class;
            args = _args;
        }
    }
}
