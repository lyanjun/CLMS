package com.sis.clms.network;

import android.os.Handler;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 作者： LYJ
 * 功能： 网络工具类
 * 创建日期： 2017/5/3
 */

public class HttpUtils {


    /**
     * get请求网络数据
     */
    public static void HttpGet(final Handler handler, String url ,final int requestCode){
        final Request request = new Request.Builder().url(url).build();
        HttpClient.getInstance().getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.obtainMessage(HttpCode.ERROR,e.getMessage()).sendToTarget();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handler.obtainMessage(requestCode,response.body().string()).sendToTarget();
            }
        });
    }

    /**
     * post请求网络数据
     */
    public static void HttpPost(final Handler handler, String url,Map params ,final int requestCode){
        FormBody.Builder builder = new FormBody.Builder();
        Iterator<Map.Entry> iterator =  params.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry entry = iterator.next();
            String key = entry.getKey().toString();
            String values = entry.getValue().toString();
            builder.add(key,values);
        }
        Request request = new Request.Builder().url(url).post(builder.build()).build();
        HttpClient.getInstance().getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.obtainMessage(HttpCode.ERROR,e.getMessage()).sendToTarget();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                handler.obtainMessage(requestCode,response.body().string()).sendToTarget();
            }
        });
    }
}
