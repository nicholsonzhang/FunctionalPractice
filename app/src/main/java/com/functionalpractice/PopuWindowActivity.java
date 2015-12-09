package com.functionalpractice;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;


/**
 * Created by Administrator on 2015/12/8.
 */
public class PopuWindowActivity extends AppCompatActivity{
    private Button showButton;
    private TextView anchor;
    private PopupWindow mPopuWindow;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.popuwindow_activity_layout);
        showButton = (Button) findViewById(R.id.show);
        anchor  = (TextView) findViewById(R.id.anchor);

        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopuWindow();
            }
        });
    }


    private void showPopuWindow(){

        if (mPopuWindow != null && mPopuWindow.isShowing()){
            mPopuWindow.dismiss();
            return;
        }
       View contentView =  LayoutInflater.from(this).inflate(R.layout.popuwindow_content,null);


        if (mPopuWindow == null){
            mPopuWindow = new PopupWindow(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.WRAP_CONTENT);
            mPopuWindow.setTouchable(true);
            mPopuWindow.setOutsideTouchable(true);
//            mPopuWindow.setTouchInterceptor(new View.OnTouchListener() {
//                @Override
//                public boolean onTouch(View v, MotionEvent event) {
//                    return true;
//                }
//            });
            Drawable drawable = getResources().getDrawable(android.R.color.holo_orange_light);
            mPopuWindow.setBackgroundDrawable(drawable);
        }

        mPopuWindow.setContentView(contentView);
        mPopuWindow.showAsDropDown(anchor);


    }
}
