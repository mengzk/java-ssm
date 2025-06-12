package com.item.study.utils;

import com.item.study.config.Configs;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.time.LocalDateTime;
import java.util.Base64;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
public class TokenUtil {
    private static final String ENCODE_RULE = "AES"; // 转换模式
    private static final String ENCODE_KEY = "QXKALHZJDCOPVNMS"; // 16位 -每隔1周更换一次
    private static final int GAP = Configs.Token_Gap; // token过期时间 1小时

//    public static void main(String[] strs) {
//        try {
//            String str = create(12313);
//            String str2 = parse(str);
//            System.out.println(str+" | "+str2);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    /**
     * 创建token
     */
    public static String create(int id, int level) {
        String token = null; // 当前时间+1小时
        String str = String.format("%d_%d_%s", id, level, LocalDateTime.now().plusHours(GAP));
        try {
            Cipher cipher = Cipher.getInstance(ENCODE_RULE);
            SecretKeySpec secretKeySpec = new SecretKeySpec(ENCODE_KEY.getBytes(), ENCODE_RULE);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encrypt = cipher.doFinal(str.getBytes());
            token = Base64.getEncoder().encodeToString(encrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

    /**
     * 解析token
     */
    public static String parse(String token) {
        String result = "";
        try {
            Cipher cipher = Cipher.getInstance(ENCODE_RULE);
            SecretKeySpec secretKeySpec = new SecretKeySpec(ENCODE_KEY.getBytes(), ENCODE_RULE);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] decrypt = cipher.doFinal(Base64.getDecoder().decode(token));
            result = new String(decrypt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Integer getUserId(String token) {
        String parsedToken = parse(token);
        if (parsedToken.isEmpty()) {
            return -1;
        }else {
            return Integer.parseInt(parsedToken.split("_")[0]);
        }
    }

    /**
     * 判断token是否过期
     */
    public static boolean isExpired(String token) {
        String parsedToken = parse(token);
        if (parsedToken.isEmpty()) {
            return true;
        }
        String[] parts = parsedToken.split("_");
        LocalDateTime createTime = LocalDateTime.parse(parts[2]);
        return LocalDateTime.now().isAfter(createTime);
    }

    /**
     * 重置过期token
     */
    public static void reset() {

    }
}
