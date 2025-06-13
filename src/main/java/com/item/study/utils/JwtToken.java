package com.item.study.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;

public class JwtToken {
    private static long GAP = 24 * 60 * 60 * 1000; // token过期时间 1天
    private static String SECRET_KEY = "QXKALHZJDCOPVNMS"; // 16位 -每隔1周更换一次
    private static String ISSUER = "ItemStudy"; // 发行人
    private static String AUDIENCE = "ItemStudyUser"; // 受众
    private static String TOKEN_PREFIX = "Bearer ";
    private static Algorithm algorithm = Algorithm.HMAC256(SECRET_KEY);

    /**
     * 创建JWT Token
     */
    public static String create(int id, int level) {
        Date now = new Date();
        Date expiresAt = new Date(now.getTime() + GAP); // 过期时间
       String token = JWT.create()
//                .withIssuer(ISSUER)
//                .withAudience(AUDIENCE)
//                .withJWTId(UUID.randomUUID().toString())
                .withClaim("id", id)
                .withClaim("l", level)
//                .withIssuedAt(now)
                .withExpiresAt(expiresAt)
                .sign(algorithm);

        return Base64.getEncoder().encodeToString(token.getBytes());
    }

    /**
     * 解析JWT Token
     */
    public static String parse(String token) {
        if (token == null) {
            return null;
        }
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(token);
            return new String(decodedBytes);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return null; // Base64解码失败
        }
    }

    /**
     * 验证JWT Token
     */
    public static boolean check(String token) {
        try {
            String parsedToken = parse(token);
            if (parsedToken == null) {
                return false;
            }
            // 解析JWT
            JWT.require(algorithm)
                    .build()
                    .verify(parsedToken);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 获取用户ID
     */
    public static Integer getId(String token) {
        String parsedToken = parse(token);
        if (parsedToken == null || parsedToken.isEmpty()) {
            return -1; // 无效的token
        }
        try {
            return JWT.decode(parsedToken).getClaim("id").asInt();
        } catch (Exception e) {
            e.printStackTrace();
            return -1; // 解析失败
        }
    }
}
