package com.item.study.modules.exception;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public enum CommonError implements CustomError {

    SUCCESS(0, "成功"),
    FAIL(10, "操作失败"),

    UNKNOWN_ERR(10100, "未知错误"),
    PARAM_FAIL(10210, "参数不正确"),
    PARAM_EMPTY(10220, "参数不能为空"),
    PARAM_Lack(10221, "必要参数不能为空"),
    PARAM_VALIDATE_FAIL(10230, "参数检验失败"),

    DB_ERROR(10300, "数据库操作失败"),

    LOGIN_ERR(20100, "账号登录失败"),
    ACCOUNT_PWD_ERR(20110, "账号或密码错误"),
    ACCOUNT_EXIST(20120, "账号已存在"),
    ACCOUNT_NOT_EXIST(20130, "账号不存在"),
    ACCOUNT_REGISTER_ERR(20131, "账号注册失败"),
    UNAUTHORIZED(20140, "登录已过期"),
    NOT_LOGIN(20141, "账号未登录"),
    INVALID_TOKEN(20142, "您的账户已在其他设备登录，请重新登录"),

    FORBIDDEN(30100, "没有相关权限");

    private final int code;
    private String msg;

    CommonError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public int getCECode() {
        return code;
    }

    @Override
    public String getCEMsg() {
        return msg;
    }

    @Override
    public CustomError setCEMsg(String msg) {
        this.msg = msg;
        return this;
    }

    @Override
    public String toString() {
        return "CommonError{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
