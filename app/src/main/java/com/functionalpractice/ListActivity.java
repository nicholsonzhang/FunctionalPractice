package com.functionalpractice;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * 空列表刷新demo
 * Created by nichol on 15/12/15.
 */

@EActivity(R.layout.activity_list_layout)
public class ListActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    @ViewById(R.id.swipe_layout)
    SwipeRefreshLayout mSwipeRefreshLayout;

    @ViewById(R.id.list_view)
    ListView mListView;

    @ViewById(R.id.swipe_empty)
    SwipeRefreshLayout mEmptySwipeRefreshLayout;

    private List<String> mList;
    private ArrayAdapter<String> mAdapter;


    @AfterViews
    void AfterViews(){
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.main_red_color,android.R.color.holo_green_light,
                android.R.color.holo_orange_light, R.color.main_red_color);

        mEmptySwipeRefreshLayout.setOnRefreshListener(this);
        mEmptySwipeRefreshLayout.setColorSchemeResources(R.color.main_red_color,android.R.color.holo_green_light,
                android.R.color.holo_orange_light, R.color.main_red_color);

        mList = new ArrayList<>();
        for (int i = 0 ; i < 30 ;i++){
            mList.add("第"+i+"个数据");
        }
        mListView.setEmptyView(mEmptySwipeRefreshLayout);

        mEmptySwipeRefreshLayout.setVisibility(View.GONE);

        mAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,mList);
        mListView.setAdapter(mAdapter);





    }

    @Click(R.id.clear_data)
    void clearData(){

        mList.clear();
        mEmptySwipeRefreshLayout.setVisibility(View.GONE);
        mAdapter.notifyDataSetChanged();
    }


    @Override
    public void onRefresh() {
        mHandler.sendEmptyMessageDelayed(0,3000);


    }

    private void  updateData(){
        mList.clear();
        for (int i = 0 ; i < 30 ;i++){
            mList.add("第"+i+"个数据");
        }
        mEmptySwipeRefreshLayout.setVisibility(View.VISIBLE);
        mAdapter.notifyDataSetChanged();



    }
    private Handler mHandler  = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case 0:
                    mSwipeRefreshLayout.setRefreshing(false);
                    mEmptySwipeRefreshLayout.setRefreshing(false);
                    updateData();
                    break;
            }

            super.handleMessage(msg);
        }
    };


}
