package com.item.study.utils;

import java.util.Random;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public class CodeUtils {

//    public static void main(String[] args) {
//        long num = createNewId(5);
//        String code = createCode(6);
//        System.out.println(num);
//        System.out.println(code);
//    }
//    public static long createNewId(int len) {
//        StringBuilder num = new StringBuilder(((int)Math.floor(Math.random() * 9) + 1) + "");
//        for (int i = 0; i < len; i++) {
//            num.append((int) (Math.random() * 10));
//        }
//        return Long.parseLong(num.toString());
//    }

    // 生成指定位数的随机数
    public static long createNewId(int len) {
        Random ran = new Random();
        int one = ran.nextInt(10);
        StringBuilder num = new StringBuilder();
        num.append(one > 0 ? one : 1);
        for (int i = 0; i < len; i++) {
            num.append(ran.nextInt(10));
        }
        return Long.parseLong(num.toString());
    }

    // 生成指定位数的随机数
    public static int createIntId(int len) {
        Random ran = new Random();
        int one = ran.nextInt(10);
        StringBuilder num = new StringBuilder();
        num.append(one > 0 ? one : 1);
        for (int i = 0; i < len; i++) {
            num.append(ran.nextInt(10));
        }
        return Integer.parseInt(num.toString());
    }

    // 生成6位随机数
    public static String createCode() {
        Random ran = new Random();
        String num = ran.nextInt(1000000) + "";
        return num.substring(1);
    }
}
