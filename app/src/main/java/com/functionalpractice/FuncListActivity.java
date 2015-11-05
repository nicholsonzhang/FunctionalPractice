package com.functionalpractice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;



/**
 * Created by Administrator on 2015/11/4.
 */
public class FuncListActivity extends AppCompatActivity {
    private ListView mListView;
    private static Sample[] mSamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.func_list_layout);
        mListView = (ListView)findViewById(R.id.func_list_view);
        mSamples = new Sample[]{new Sample(R.string.collase_toolbar_activity,CollaseToolbarActivity.class),
        new Sample(R.string.toolbar_activity,ToolbarActivity.class),
        new Sample(R.string.volley_activity,VolleyActivity.class)};
        mListView.setAdapter(new ArrayAdapter<Sample>(this,android.R.layout.simple_list_item_1,android.R.id.text1,mSamples));


        mListView.setOnItemClickListener(onItemClickListener);


    }
    private AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            startActivity(new Intent(FuncListActivity.this,mSamples[position].activityClass));

        }
    };


    private class Sample {
        private CharSequence title;
        private Class<? extends Activity> activityClass;

        public Sample(int titleResId, Class<? extends Activity> activityClass) {
            this.activityClass = activityClass;
            this.title = getResources().getString(titleResId);
        }

        @Override
        public String toString() {
            return title.toString();
        }
    }




}
