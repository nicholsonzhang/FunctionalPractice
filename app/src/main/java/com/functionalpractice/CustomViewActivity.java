package com.functionalpractice;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by nichol on 16/1/14.
 */
public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        getScreenSize();
        getAppSize();
        Log.e("yyzhang","Double"+Double.compare(0,0.1));
    }

    private void getScreenSize(){
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        Log.e("yyzhang","getScreenSize  widthPixels="+metrics.widthPixels+"heightPixels="+metrics.heightPixels+"density="+metrics.density+"densityDpi="+metrics.densityDpi);
    }
    private void getAppSize(){
        Rect rect = new Rect();
        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        Log.e("yyzhang","getAppSize height="+rect.height()+"width="+rect.width()+"top="+rect.top);
    }
}
