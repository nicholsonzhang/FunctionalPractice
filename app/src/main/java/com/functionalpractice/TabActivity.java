package com.functionalpractice;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.functionalpractice.adapter.TabAdapter;
import com.functionalpractice.common.CommonTag;
import com.functionalpractice.viewpageindicator.UnderlinePageIndicator;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by nichol on 16/1/11.
 */
public class TabActivity extends AppCompatActivity{

    @Bind(R.id.view_pager)
    ViewPager mViewPager;

    @Bind(android.R.id.tabhost)
    TabHost mTabHost;

    @Bind(R.id.tab_indicator)
    UnderlinePageIndicator mIndicator;

    private TabAdapter mTabAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_layout);
        ButterKnife.bind(this);
        initTab();
    }
    private void initTab(){
        mTabHost.setup();
        TabWidget widget = mTabHost.getTabWidget();
        widget.setShowDividers(TabWidget.SHOW_DIVIDER_NONE);
        mTabAdapter = new TabAdapter(this,mTabHost,mViewPager,getSupportFragmentManager());

        mTabAdapter.addTab(createTabSpec(CommonTag.WEATHER,getTabBottomView("天气")),WeatherFragment.class,new Bundle());
        mTabAdapter.addTab(createTabSpec(CommonTag.MAP,getTabBottomView("地图")),MapFragment.class,new Bundle());

        mIndicator.setViewPager(mViewPager);
        mIndicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                mTabAdapter.onPageScrolled(position,positionOffset,positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                mTabAdapter.onPageSelected(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                mTabAdapter.onPageScrollStateChanged(state);

            }
        });


    }

    private View getTabBottomView(String titleStr){
        View view = View.inflate(this,R.layout.tab_bottom_layout,null);

        TextView textView = (TextView) view.findViewById(R.id.tab_title);
        textView.setText(titleStr);
        return view;

    }
    private TabHost.TabSpec createTabSpec(String tag,View indicator){
        TabHost.TabSpec spec = mTabHost.newTabSpec(tag);
        spec.setIndicator(indicator);
        spec.setContent(new DummyTabFactory(this));
        return spec;
    }

}
