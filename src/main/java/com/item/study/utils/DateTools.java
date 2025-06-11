package com.item.study.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public class DateTools {

    // 格式化日期 yyyy-MM-dd
    public static String formatDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new Date());
    }

    // 格式化时间 yyyy-MM-dd HH:mm:ss
    public static String formatTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    // 格式化时间 yyyy/MM/dd HH:mm:ss
    public static String formatTime2(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.format(date);
    }

    // 生成当前时间 yyyyMMddHHmmss
    public static String currentDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }

    // 生成版本号
    public static String formatVer() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmss");
        return sdf.format(new Date());
    }

    // 生成当前时间 yyyy-MM-dd HH:mm:ss
    public static Date getDate(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            if(format == null) {
                return null;
            }
            return sdf.parse(format);
        } catch (ParseException e) {
            e.fillInStackTrace();
            return null;
        }
    }
}
