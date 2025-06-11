package com.item.study.modules.network;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.util.Set;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public class OkRequest {
    private final static String TAG = "OkRequest";

    public static String request(RequestOption options) {
        if (options.url == null) {
            return null;
        }
        OkHttpClient client = OkClient.client();

        Request.Builder builder = new Request.Builder().url(options.url);

        // 请求方法
        if (options.method.equalsIgnoreCase("post")) {
            String json = options.params != null ? new Gson().toJson(options.params) : "";
            RequestBody body = RequestBody.create(json, OkClient.MEDIA_JSON);
            builder.post(body);
        } else if (options.method.equalsIgnoreCase("get")) {
            // 拼接参数
        }

        // 请求头
        if (options.headers != null) {
            Set<String> keys = options.headers.keySet();
            for (String key : keys) {
                builder.addHeader(key, (String) options.headers.get(key));
            }
        }

        // 发送请求
        try{
            Response response = client.newCall(builder.build()).execute();

            String result = null;
            if(response.isSuccessful()) {
                if (response.body() != null) {
                    result = response.body().string();
                }
                System.out.printf("%s res-----> %s%n" ,TAG, result);
            }
            return result;
        }catch (IOException e) {
            System.out.printf("%s io-----> %s%n" ,TAG, e.getMessage());
        }
        return null;
    }

    public static void asyncRequest(RequestOption options, OkCallback callback) {
        if (options.url == null) {
            return;
        }
        OkHttpClient client = OkClient.client();

        Request.Builder builder = new Request.Builder().url(options.url);

        // 请求方法
        if (options.method.equalsIgnoreCase("post")) {
            String json = options.params != null ? new Gson().toJson(options.params) : "";
            RequestBody body = RequestBody.create(json, OkClient.MEDIA_JSON);
            builder.post(body);
        }

        // 请求头
        if (options.headers != null) {
            Set<String> keys = options.headers.keySet();
            for (String key : keys) {
                builder.addHeader(key, (String) options.headers.get(key));
            }
        }

        // 发送请求
        client.newCall(builder.build()).enqueue(callback);
    }
}
