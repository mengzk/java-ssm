package com.item.study.modules.exception;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public interface CustomError {
    int getCECode();
    String getCEMsg();
    CustomError setCEMsg(String message);
}
