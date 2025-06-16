package com.item.study.modules.network;

import com.google.gson.Gson;
import okhttp3.*;

import java.io.File;
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

    public static void asyncRequest(RequestOption options, OkBack callback) {
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

    // get请求
    public static String get(String url) {
        RequestOption options = new RequestOption(url, "get");
        return request(options);
    }

    // post请求
    public static String post(String url, Object params) {
        RequestOption options = new RequestOption(url, "post", params);
        return request(options);
    }

    // put请求
    public static String put(String url, Object params) {
        RequestOption options = new RequestOption(url, "put", params);
        return request(options);
    }

    // delete请求
    public static String delete(String url, Object params) {
        RequestOption options = new RequestOption(url, "delete", params);
        return request(options);
    }

    // patch请求
    public static String patch(String url, Object params) {
        RequestOption options = new RequestOption(url, "patch", params);
        return request(options);
    }

    // file上传
    public static String upload(String url, File file) {
        RequestOption options = new RequestOption(url, "post");
        options.headers.put("Content-Type", "multipart/form-data");
        // 文件上传的逻辑
//        MultipartBody.create(file, MediaType.parse("multipart/form-data"));
        // 例如使用MultipartBody.Builder来构建请求体
        return request(options);
    }
}
