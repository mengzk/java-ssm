package com.item.study.modules.network;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public abstract class OkCallback<T> implements Callback {
    private final String TAG = "OkCallback";

    @Override
    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
        if (response.isSuccessful()) {
            String data = null;
            MediaType mt = response.body().contentType();
            if (response.body() != null) {
                data = response.body().string();
                System.out.printf("onResponse -----> %s", data);
            }else {
                System.out.println("onResponse -----> %" + mt.type());
            }
//            System.out.printf("%S---> %s%n", TAG, data);
            if (data != null) {
//                Gson gson = new Gson();
//                OkResult result = gson.fromJson(data, OkResult.class);
//                onResult(result);
//                onResult(data);
            } else {
                onFail(-1, response.message());
            }
        } else {
            onFail(response.code(), response.message());
        }
    }

    @Override
    public void onFailure(@NotNull Call call, @NotNull IOException e) {
        System.out.printf("%S---> %s%s", TAG, call.request().url(), e.getMessage());
        onFail(10101, e.getMessage());
    }

    private void onFail(int code, String msg) {
        System.out.printf("%s---> %d%s", TAG, code, msg);
    }

    protected abstract void onResult(OkResult<T> data);

}
