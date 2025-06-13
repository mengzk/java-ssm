package com.item.study.modules.network;

import com.google.gson.Gson;
import okhttp3.*;
import okio.BufferedSink;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 * https://square.github.io/okhttp/recipes/
 * https://github.com/square/okhttp/tree/master/samples/guide/src/main/java/okhttp3/recipes
 */
public class OkClient {
    public static MediaType MEDIA_MARKDOWN = MediaType.parse("text/x-markdown; charset=utf-8");
    public static MediaType MEDIA_PNG = MediaType.parse("image/png");
    public static MediaType MEDIA_JSON = MediaType.parse("application/json; charset=utf-8");

    private static final ConnectionPool pool = new ConnectionPool(10, 6, TimeUnit.MINUTES);
    private static OkHttpClient okClient;

    public static OkHttpClient client() {
        if (okClient == null) {
            create();
        }
        return okClient;
    }

    private static void create() {
        okClient = new OkHttpClient.Builder()
                .connectionPool(pool)
                .connectTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .callTimeout(60, TimeUnit.SECONDS)
//                .addNetworkInterceptor(new NetInterceptor())
                .addInterceptor(new LogInterceptor())
                .build();
    }

    public static OkHttpClient sse() {
        return new OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.MINUTES)
                .writeTimeout(60, TimeUnit.MINUTES)
                .readTimeout(60, TimeUnit.MINUTES)
                .callTimeout(60, TimeUnit.MINUTES)
                .build();
    }


    private void get(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = okClient.newCall(request).execute();
        response.body().string();
    }

    private void post(String url, Object obj) throws IOException {
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        RequestBody body = RequestBody.create(json, MEDIA_JSON);
        Request request = new Request.Builder()
                .url(url)
                .header("User-Agent", "OkHttp Headers.java")
                .addHeader("Accept", "application/json; q=0.5")
                .post(body)
                .build();
        Response response = okClient.newCall(request).execute();
        response.body().string();
// 写法2
//        okClient.newCall(request).enqueue(new Callback() {
//            @Override
//            public void onFailure(@NotNull Call call, @NotNull IOException e) {}
//            @Override
//            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {}
//        });
    }

    private void form() {
        RequestBody formBody = new FormBody.Builder()
                .add("search", "Jurassic Park")
                .build();
        Request request = new Request.Builder()
                .url("https://en.wikipedia.org/w/index.php")
                .post(formBody)
                .build();
    }

    private void file() {
        File file = new File("README.png");
        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(RequestBody.create(file, MEDIA_PNG))
                .build();
    }

    private void files() {
        // Use the imgur image upload API as documented at https://api.imgur.com/endpoints/image
        RequestBody requestBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("title", "Square Logo")
                .addFormDataPart("image", "logo-square.png",
                        RequestBody.create(new File("website/static/logo-square.png"), MEDIA_PNG))
                .build();
        String IMGUR_CLIENT_ID = "...";
        Request request = new Request.Builder()
                .header("Authorization", "Client-ID " + IMGUR_CLIENT_ID)
                .url("https://api.imgur.com/3/image")
                .post(requestBody)
                .build();

    }
    private void markdown() throws IOException {
        RequestBody requestBody = new RequestBody() {
            @Override
            public MediaType contentType() {
                return MEDIA_MARKDOWN;
            }

            @Override
            public void writeTo(BufferedSink sink) throws IOException {
                sink.writeUtf8("Numbers\n");
                sink.writeUtf8("-------\n");
                for (int i = 2; i <= 997; i++) {
                    sink.writeUtf8(String.format(" * %s = %s\n", i, factor(i)));
                }
            }

            private String factor(int n) {
                for (int i = 2; i < n; i++) {
                    int x = n / i;
                    if (x * i == n) return factor(x) + " × " + i;
                }
                return Integer.toString(n);
            }
        };

        Request request = new Request.Builder()
                .url("https://api.github.com/markdown/raw")
                .post(requestBody)
                .build();
    }
}
