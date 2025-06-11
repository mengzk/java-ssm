package com.item.study.modules.network.sse;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.google.gson.Gson;
import com.item.study.config.Configs;
import com.item.study.modules.network.OkClient;
import com.item.study.modules.network.OkResult;
import okhttp3.*;
import okhttp3.internal.sse.RealEventSource;
import okhttp3.sse.EventSource;
import okhttp3.sse.EventSourceListener;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: SSE请求
 */
public class ChatSSERequest {
    private final static String TAG = "ChatRequest";
    private final static String DOMAIN = "https://open.bigmodel.cn/api";
    private static final OkHttpClient client = OkClient.client();
    private static final String AUTH = getJWTAuth();

    // get请求
    public static void get(String path) {
        // 定义see接口
        Request request = new Request.Builder().url("http://127.0.0.1:8080/sse/chat").build();
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(1, TimeUnit.HOURS)
                .readTimeout(1, TimeUnit.HOURS) //这边需要将超时显示设置长一点，不然刚连上就断开，之前以为调用方式错误被坑了半天
                .build();
        // 实例化EventSource，注册EventSource监听器
        RealEventSource realEventSource = new RealEventSource(request, new EventSourceListener() {
            private long callStartNanos;

            private void printEvent(String name) {
                long nowNanos = System.nanoTime();
                if (name.equals("callStart")) {
                    callStartNanos = nowNanos;
                }
                long elapsedNanos = nowNanos - callStartNanos;
                System.out.printf("=====> %.3f %s%n", elapsedNanos / 1000000000d, name);
            }

            @Override
            public void onOpen(EventSource eventSource, Response response) {
                printEvent("onOpen");
            }

            @Override
            public void onEvent(EventSource eventSource, String id, String type, String data) {
                printEvent("onEvent");
                System.out.println(data);//请求到的数据
            }

            @Override
            public void onClosed(EventSource eventSource) {
                printEvent("onClosed");
            }

            @Override
            public void onFailure(EventSource eventSource, Throwable t, Response response) {
                printEvent("onFailure");//这边可以监听并重新打开
            }
        });
        realEventSource.connect(okHttpClient);//真正开始请求的一步
    }

    // 发送请求
    public static OkResult<String> execute(Request.Builder builder) {

        try {
            // 创建一个 CountDownLatch 对象，其初始计数为1，表示需要等待一个事件发生后才能继续执行。
            CountDownLatch eventLatch = new CountDownLatch(1);

//            builder.addHeader("Content-Type", "application/json");
            builder.addHeader("Accept", "text/event-stream");
            builder.addHeader("Authorization", AUTH);
            // 实例化EventSource，注册EventSource监听器 -- 创建一个用于处理服务器发送事件的实例，并定义处理事件的回调逻辑
            RealEventSource realEventSource = new RealEventSource(builder.build(), new EventSourceListener() {

                @Override
                public void onEvent(EventSource es, String id, String type, String data) {
                    System.out.println(data);   // 请求到的数据
                    if ("finish".equals(type)) {
                        // 消息类型，add 增量，finish 结束，error 错误，interrupted 中断
                        eventLatch.countDown();
                    }
                }

            });

            // 与服务器建立连接
            realEventSource.connect(client);
            // await() 方法被调用来阻塞当前线程，直到 CountDownLatch 的计数变为0。
            eventLatch.await();
            return null;
        } catch (Exception e) {
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
        return new Gson().fromJson(json, clazz);
    }
}
