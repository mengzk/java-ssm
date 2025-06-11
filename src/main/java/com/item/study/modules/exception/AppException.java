package com.item.study.modules.exception;


/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public abstract class AppException extends Exception implements CustomError  {
//    @Serial
//    private static final long serialVersionUID = 1L;

    @Override
    public abstract int getCECode();

    @Override
    public abstract String getCEMsg();

    @Override
    public abstract CustomError setCEMsg(String message);
}
