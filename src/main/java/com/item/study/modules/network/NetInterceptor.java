package com.item.study.modules.network;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public class NetInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request result = chain.request();

        Request.Builder builder = result.newBuilder()
                .addHeader("Accept", "application/json")
                .addHeader("Content-Type", "application/json;charset=UTF-8")
                .addHeader("Authorization", "baaa696e5a564afe36e85gTIO7SasX8K6H");

//        if(result.method.lowercase() == "get") {
//            val newUrl = result.url.newBuilder().addQueryParameter("TOKEN", token).build()
//            builder.url(newUrl)
//        }else {}
        return chain.proceed(builder.build());
    }
}