package com.item.study.modules.exception;

import java.io.Serial;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public class CustomException extends AppException  {
    @Serial
    private static final long serialVersionUID = 9736L;

    private final int ceCode;
    private String ceMsg;

    public CustomException(int code, String msg) {
        this.ceCode = code;
        this.ceMsg = msg;
    }

    public static CustomException create(CommonError err) {
        return new CustomException(err.getCECode(), err.getCEMsg());
    }

    public static CustomException create(int code, String msg) {
        return new CustomException(code, msg);
    }

    @Override
    public int getCECode() {
        return ceCode;
    }

    @Override
    public String getCEMsg() {
        return ceMsg;
    }

    @Override
    public CustomError setCEMsg(String message) {
        ceMsg = message;
        return this;
    }
}
