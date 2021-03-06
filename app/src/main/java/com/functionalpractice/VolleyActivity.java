package com.functionalpractice;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.functionalpractice.bean.User;
import com.functionalpractice.bean.Weather;
import com.functionalpractice.bean.WeatherInfo;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by nichol on 15/11/5.
 */
public class VolleyActivity extends AppCompatActivity{
    public String STRINGTAG = "stringRequestTag";
    private TextView textView1 ;
    private ImageView imageView1;
    private RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volley_activity_layout);
        textView1 = (TextView)findViewById(R.id.text1);
        imageView1 = (ImageView)findViewById(R.id.image1);
        requestQueue = VolleyUtils.getInstance(this).getRequestQueue();

//        testStringRequestGet();
//        testJsonObjectRequest();
//        testJsonArrayRequest();
//          testImageRequest();
        testFastJsonRequest();
    }


    private void testStringRequestGet(){
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
        stringRequest.setTag(STRINGTAG);
        requestQueue.add(stringRequest);
    }

    private void testJsonObjectRequest(){
        String url = "http://m.weather.com.cn/data/101010100.html";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject) {
                textView1.setText(jsonObject.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                textView1.setText("uuuuu="+volleyError.getMessage());
            }
        });

        requestQueue.add(jsonObjectRequest);

    }


    private void testJsonArrayRequest(){
        String url = "http://baike.baidu.com/api/openapi/BaikeLemmaCardApi?scope=103&format=json&appid=379020&bk_key=MAC&bk_length=600";
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray jsonArray) {
                textView1.setText(jsonArray.toString());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                textView1.setText("pppp="+volleyError.getMessage());

            }
        });
        requestQueue.add(jsonArrayRequest);

    }

    private void testImageRequest(){
        String url = "http://i.imgur.com/7spzG.png";
        ImageRequest imageRequest = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap bitmap) {
                textView1.setText(bitmap.getHeight()+"  "+bitmap.getWidth()+"   "+bitmap.getDensity());
                imageView1.setImageBitmap(bitmap);

            }
        }, 200, 200, null, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                imageView1.setBackgroundResource(R.mipmap.ic_launcher);

            }
        });
        requestQueue.add(imageRequest);

    }



    private void testFastJsonRequest(){
        String url = "http://www.weather.com.cn/adat/sk/101010100.html";
        FastJsonRequest<Weather> request = new FastJsonRequest<Weather>(url, Weather.class, new Response.Listener<Weather>() {
            @Override
            public void onResponse(Weather weather) {
                WeatherInfo info = weather.getWeatherinfo();
                textView1.setText(info.getCity()+info.getTemp()+info.getTime());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                textView1.setText(volleyError.getMessage());

            }
        });

        requestQueue.add(request);
    }


}
