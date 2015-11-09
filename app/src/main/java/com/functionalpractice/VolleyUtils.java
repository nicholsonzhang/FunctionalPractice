package com.functionalpractice;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by nichol on 15/11/5.
 */
public class VolleyUtils {
    private RequestQueue mRequestQueue;
    private volatile static VolleyUtils mInstance;
    private Context mContext;

    private VolleyUtils(Context context){

        mContext = context;

    }

    public static synchronized VolleyUtils getInstance(Context context){
        if (mInstance == null){
            synchronized (VolleyUtils.class){
                if (mInstance == null){
                    mInstance = new VolleyUtils(context);
                }
            }
        }

        return mInstance;
    }
    public RequestQueue getRequestQueue(){

        if (mRequestQueue == null){
            // use Application's Context
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());
        }
        return mRequestQueue;
    }

}
