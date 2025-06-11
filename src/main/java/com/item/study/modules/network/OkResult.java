package com.item.study.modules.network;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public class OkResult<T> {
    public int code = -1;
    public String msg = "";
    public T data;

    public OkResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> OkResult<T> ok(T data) {
        return new OkResult<T>(0, "ok", data);
    }

    public static <T> OkResult<T> ok(T data, String msg) {
        return new OkResult<T>(0, msg, data);
    }

    public static  <T> OkResult<T> fail( String msg) {
        return new OkResult<T>(1011, msg, null);
    }

    public static  <T> OkResult<T> fail(int code, String msg) {
        return new OkResult<T>(code, msg, null);
    }

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
