package com.functionalpractice;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by nichol on 15/11/10.
 */
public class AnimationActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButton;
    private ImageView mImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_layout);

        mButton = (Button) findViewById(R.id.start);
        mButton.setOnClickListener(this);
        mImageView = (ImageView) findViewById(R.id.image);

    }

    @Override
    public void onClick(View v) {
        move();
    }


    private void move(){
//       ObjectAnimator.ofFloat(mImageView,"translationY",0f,300f).setDuration(2000).start();
//       ObjectAnimator.ofFloat(mImageView,"translationX",0f,300f).setDuration(2000).start();
//       ObjectAnimator.ofFloat(mImageView,"rotation",0f,360f).setDuration(2000).start();
        //多动画同时播放，比上述方法效率高
        PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("translationY",0f,300f);
        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationX",0f,300f);
        PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("rotation",0f,300f);
        ObjectAnimator.ofPropertyValuesHolder(mImageView,p1,p2,p3).setDuration(2000).start();
    }
}
