package com.functionalpractice;

import android.content.Context;
import android.view.View;
import android.widget.TabHost;

/**
 * Created by nichol on 16/1/12.
 */
public class DummyTabFactory implements TabHost.TabContentFactory {
    private  Context mContext;

    public DummyTabFactory(Context context) {
        mContext = context;
    }

    @Override
    public View createTabContent(String tag) {
        View v = new View(mContext);
        v.setMinimumWidth(0);
        v.setMinimumHeight(0);
        return v;
    }
}
