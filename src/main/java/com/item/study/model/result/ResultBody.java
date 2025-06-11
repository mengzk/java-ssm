package com.item.study.model.result;

import com.item.study.modules.exception.CustomError;
import com.item.study.modules.exception.CommonError;
import java.util.List;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public class ResultBody {
    private int code;
    private String message;
    private Object data;

    public ResultBody(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static ResultBody success(Object data) {
        return new ResultBody(CommonError.SUCCESS.getCECode(), CommonError.SUCCESS.getCEMsg(), data);
    }

    public static <T> ResultBody list(List<T> list, int total, int pageSize, int pageNum) {
        ResultList data = ResultList.create(list, total, pageSize, pageNum);
        return new ResultBody(CommonError.SUCCESS.getCECode(), CommonError.SUCCESS.getCEMsg(), data);
    }

    public static ResultBody fail(int code, String message) {
        return new ResultBody(code, message, null);
    }

    public static ResultBody fail(CustomError error) {
        return new ResultBody(error.getCECode(), error.getCEMsg(), null);
    }

    public static ResultBody unknown(String message) {
        return new ResultBody(CommonError.UNKNOWN_ERR.getCECode(), message, null);
    }

    public static ResultBody paramFail(String message) {
        return new ResultBody(CommonError.PARAM_VALIDATE_FAIL.getCECode(), message, null);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "{" +
                "code=" + code +
                ", message='" + message +
                ", data=" + data.toString() + '}';
    }
}
