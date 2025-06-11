package com.item.study.modules.network;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.google.gson.Gson;
import com.item.study.config.Configs;
import okhttp3.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: 智普网络请求
 */
public class ChatRequest {
    private final static String TAG = "ChatRequest";
    private final static String DOMAIN = "https://open.bigmodel.cn/api/paas/v4";
    private static final OkHttpClient client = OkClient.client();
    private static final String AUTH = getJWTAuth();

//    // get请求
//    public static <T> T get(String path) {
//        String url = DOMAIN + path;
//        Request.Builder builder = new Request.Builder().url(url);
//
//        return execute(builder);
//    }

    // get请求
    public static OkResult<String> get(String path) {
        String url = DOMAIN + path;
        Request.Builder builder = new Request.Builder().url(url);

        return execute(builder);
    }

    // post请求
    public static OkResult<String> post(String path, Object params) {
        String url = DOMAIN + path;
        Request.Builder builder = new Request.Builder().url(url);

        String json = params != null ? new Gson().toJson(params) : "";
        RequestBody body = RequestBody.create(json, OkClient.MEDIA_JSON);
        builder.post(body);

        return execute(builder);
    }

    // post请求
    public static OkResult<String> upload(String path,  RequestBody body) {
        String url = DOMAIN + path;
        Request.Builder builder = new Request.Builder().url(url);

//        RequestBody requestBody = new MultipartBody.Builder()
//                .setType(MultipartBody.FORM)
//                .addFormDataPart("title", "Square Logo")
//                .addFormDataPart("image", "logo-square.png",
//                        RequestBody.create(MEDIA_PNG, new File("website/static/logo-square.png")))
//                .build();
        builder.post(body);
        return execute(builder);
    }

    // put请求
    public static OkResult<String> put(String path, Object params) {
        String url = DOMAIN + path;
        Request.Builder builder = new Request.Builder().url(url);

        String json = params != null ? new Gson().toJson(params) : "";
        RequestBody body = RequestBody.create(json, OkClient.MEDIA_JSON);
        builder.put(body);

        return execute(builder);
    }

    // delete请求
    public static OkResult<String> delete(String path, Object params) {
        String url = DOMAIN + path;
        Request.Builder builder = new Request.Builder().url(url);

        String json = params != null ? new Gson().toJson(params) : "";
        RequestBody body = RequestBody.create(json, OkClient.MEDIA_JSON);
        builder.delete(body);

        return execute(builder);
    }

    // 发送请求
    private static OkResult<String> execute(Request.Builder builder) {

        try {
            builder.addHeader("Content-Type", "application/json");
            builder.addHeader("Authorization", AUTH);
            Response response = client.newCall(builder.build()).execute();

            OkResult<String> result = new OkResult<String>(0, "ok", null);
            if (response.isSuccessful()) {
                if (response.body() != null) {
                    result.data = response.body().string();
                }
                System.out.printf("-----> %s res %s \n", TAG, result);
            }else {
                System.out.printf("-----> %s fail code: %s, msg: %s \n", TAG, response.code(), response.message());
                result.code = response.code();
                result.msg = response.message();
            }
            response.close();
            return result;
        } catch (IOException e) {
            System.out.printf("-----> %s io %s%n", TAG, e.getMessage());

            return OkResult.fail(e.getMessage());
        }
    }

    // 发送请求
    private static OkResult<byte[]> executeB(Request.Builder builder) {

        try {
            builder.addHeader("Content-Type", "application/json");
            builder.addHeader("Authorization", AUTH);
            Response response = client.newCall(builder.build()).execute();

            OkResult<byte[]> result = new OkResult<byte[]>(0, "ok", null);
            if (response.isSuccessful()) {
                if (response.body() != null) {
                    result.data = response.body().bytes();
                    System.out.printf("-----> %s res %s \n", TAG, result);
                }
            }else {
                System.out.printf("-----> %s fail code: %s, msg: %s \n", TAG, response.code(), response.message());
                result.code = response.code();
                result.msg = response.message();
            }
            response.close();
            return result;
        } catch (IOException e) {
            System.out.printf("-----> %s io %s%n", TAG, e.getMessage());

            return OkResult.fail(e.getMessage());
        }
    }


    public static String getJWTAuth() {
        long expSeconds = 12 * 3600000;

        long currentTime = System.currentTimeMillis();
        Map<String, Object> payload = new HashMap<>();
        payload.put("api_key", Configs.ZPKey);
        payload.put("exp", currentTime + expSeconds);
        payload.put("timestamp", currentTime);

        Map<String, Object> headers = new HashMap<>();
        headers.put("alg", "HS256");
        headers.put("sign_type", "SIGN");

        String token = "";

        try {
            Algorithm algorithm = Algorithm.HMAC256(Configs.ZPSecret);
             token = JWT.create()
//                    .withIssuer("auth0")
                     .withHeader(headers)
                     .withPayload(payload)
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            System.out.println("JWTCreationException: " + exception.getMessage());
        }
        return token;
    }

    public static <T> T jsonToBean(String json, Class<T> clazz) {
        try {
            return new Gson().fromJson(json, clazz);
        }catch (Exception e) {
            return null;
        }
    }
}
