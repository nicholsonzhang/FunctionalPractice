package com.functionalpractice;

import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ScrollView;

import com.functionalpractice.view.ScrollListView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nichol on 16/1/6.
 */


@EActivity(R.layout.activity_scroll_listview)
public class ScrollListViewActivity extends AppCompatActivity {

    private List<String> mList;
    private ArrayAdapter<String> mAdapter;

    @ViewById(R.id.list_view)
    ScrollListView mListView;

    @ViewById(R.id.scroll_view)
    ScrollView mScrollView;


    @AfterViews
    void initViews() {


        mList = new ArrayList<>();

        for (int i = 1; i <=30; i++) {
            mList.add("第" + i + "个数据");
        }

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, mList);
        mListView.setAdapter(mAdapter);

        mScrollView.post(new Runnable() {
            @Override
            public void run() {
                mScrollView.smoothScrollTo(0,1500);
            }
        });
    }


}
