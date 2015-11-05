package com.functionalpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 * Created by nichol on 15/11/5.
 */
public class VolleyActivity extends AppCompatActivity{
    private TextView textView1 ;
    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley_activity_layout);
        textView1 = (TextView)findViewById(R.id.text1);
        requestQueue = Volley.newRequestQueue(this);

        testStringRequest();

    }


    private void testStringRequest(){
        String url = "http://www.baidu.com";
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                textView1.setText("Response is"+s.substring(0,500));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                textView1.setText(" that's don't work");
            }
        });
        requestQueue.add(stringRequest);
    }
}
