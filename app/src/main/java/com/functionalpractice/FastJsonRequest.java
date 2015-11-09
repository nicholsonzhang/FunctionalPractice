package com.functionalpractice;

import com.alibaba.fastjson.JSON;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.HttpHeaderParser;


public class FastJsonRequest<T> extends Request<T> {
    private Class<T> mClass;
    private Response.Listener<T> mListener;

    public FastJsonRequest(int method, String url, Class<T> clzz,Response.Listener<T> listener,Response.ErrorListener errorListener) {
        super(method, url, errorListener);
        mClass = clzz;
        mListener = listener;
    }

    public FastJsonRequest(String url,Class<T> clzz,Response.Listener<T> listener,Response.ErrorListener errorListener){
        this(Method.GET,url,clzz,listener,errorListener);


    }
    @Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {

            T parseObject =JSON.parseObject(new String(response.data),mClass);
        return Response.success(parseObject,HttpHeaderParser.parseCacheHeaders(response));
    }

    @Override
    protected void deliverResponse(T t) {
        mListener.onResponse(t);



    }
}
