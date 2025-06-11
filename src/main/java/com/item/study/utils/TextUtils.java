package com.item.study.utils;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public class TextUtils {

    /**
     * 判断字符串是否为空
     * @param str 字符串
     */
    public static boolean isEmpty(String str) {
        return str == null || str.trim().isEmpty() || "null".equals(str) || "undefined".equals(str);
    }

    /**
     * 获取随机验证码
     */
    public static String getCode() {
        return Integer.toString((int) (1000000 * Math.random())).substring(1);
    }
}
