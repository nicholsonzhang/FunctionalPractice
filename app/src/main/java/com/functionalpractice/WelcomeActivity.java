package com.functionalpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


import com.functionalpractice.viewpageindicator.IconPageIndicator;
import com.functionalpractice.viewpageindicator.IconPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/29.
 */
public class WelcomeActivity extends AppCompatActivity {
    private ViewPager mViewPager;
    private IconPageIndicator mIndicator;
    private static final int[] ICONS = new int[]{
            R.drawable.perm_dot, R.drawable.perm_dot,
            R.drawable.perm_dot};

    private int[] images = new int[]{
            R.layout.page01_layout,R.layout.page02_layout,R.layout.page03_layout
    };
    private List<View> imageList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
       LayoutInflater mInflater =  LayoutInflater.from(this);
        mViewPager = (ViewPager)findViewById(R.id.welcome_view_pager);
        mIndicator = (IconPageIndicator)findViewById(R.id.indicator);

        for (int resId :images){
           View view =  mInflater.inflate(resId, null);
            imageList.add(view);
        }
        mViewPager.setAdapter(new WelcomePagerAdapter());

        mIndicator.setViewPager(mViewPager);
        mIndicator.setOnPageChangeListener(pageChangeListener);

    }

    private ViewPager.OnPageChangeListener pageChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            if (position == images.length-1){
                initLastPageListener(position);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    private void initLastPageListener(int position){
        View lastView = mViewPager.findViewById(position);
        Button nextButton = (Button)lastView.findViewById(R.id.next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                WelcomeActivity.this.finish();
            }
        });


    }
    class WelcomePagerAdapter extends PagerAdapter implements IconPagerAdapter {
        @Override
        public int getIconResId(int index) {
            return ICONS[index % ICONS.length];
        }

        @Override
        public int getCount() {
            return imageList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View view = imageList.get(position);
            view.setId(position);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageList.get(position));
        }
    }


}
