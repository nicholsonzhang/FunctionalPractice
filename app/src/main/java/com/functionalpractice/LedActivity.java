package com.functionalpractice;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by nichol on 16/1/6.
 */

public class LedActivity extends AppCompatActivity {

    @Bind(R.id.custom_led)
    TextView mLedView;

    private static final String DATE_FORMAT = "%02d:%02d:%02d" ;
    private static final int REFRESH_DELAY = 500;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_led_layout);
        ButterKnife.bind(this);

        mHandler.post(mTimeRefresher);


    }
    private final Handler mHandler = new Handler();
    private final Runnable mTimeRefresher = new Runnable() {
        @Override
        public void run() {
            Calendar calendar = Calendar. getInstance (TimeZone
                    . getTimeZone( "GMT+8")); // 设置时区
            final Date d = new Date();
            calendar .setTime (d );
            mLedView. setText( String. format (DATE_FORMAT ,
                    calendar .get (Calendar .HOUR ), calendar. get( Calendar. MINUTE),
                    calendar .get (Calendar.SECOND )));
            mHandler. postDelayed (this , REFRESH_DELAY );

        }
    };


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacks(mTimeRefresher);
    }

}
