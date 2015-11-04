package com.functionalpractice;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class CollaseToolbarActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private CollapsingToolbarLayout collapsingToolbarLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        collapsingToolbarLayout = (CollapsingToolbarLayout)findViewById(R.id.collaps_toolbar);
        collapsingToolbarLayout.setTitle("Title");

        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        LinearLayoutManager linearLayoutManager  = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        List<String> dataSet = new ArrayList<>();
        for (int i = 0 ;i < 50 ;i++){
            dataSet.add("数据"+i);
        }

        RecyclerAdapter adapter = new RecyclerAdapter(dataSet);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
