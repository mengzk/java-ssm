package com.item.study.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 *
 * 服务端生成的 token 通常不会直接存数据库，而是存储在高性能缓存（如 Redis）中，便于校验和失效控制。
 *
 * 用户登录成功后，服务端生成 token（如 JWT 或随机字符串）。
 * 将 token 作为 key，用户信息（如 userId、权限等）作为 value，存入 Redis，并设置过期时间（如 2 小时）。
 * 客户端收到 token，后续请求通过 header 携带 token。
 * 服务端收到请求后，从 Redis 校验 token 是否有效，获取用户信息。
 */

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
//                .withClaim("l", level)
//                .withIssuedAt(now)
                .withExpiresAt(expiresAt)
                .sign(algorithm);

        return Base64.getEncoder().encodeToString(token.getBytes());
    }

    /**
     * 生成刷新 Token
     */
    public static String createRefresh(int id) {
        Date now = new Date();
        Date expiresAt = new Date(now.getTime() + GAP); // 过期时间
        String token = JWT.create()
                .withClaim("id", id)
                .withExpiresAt(expiresAt)
                .withJWTId(UUID.randomUUID().toString())
                .sign(algorithm);

        return Base64.getEncoder().encodeToString(token.getBytes());
    }

    /**
     * 刷新 Token
     */
    public static String refresh(String token) {
        if (token == null || token.isEmpty()) {
            return null; // 无效的token
        }
        try {
            var verifier = JWT.require(algorithm).build();
            var decodedToken = verifier.verify(token);

            // 校验刷新 token 是否过期
            if (decodedToken.getExpiresAt().before(new Date())) {
                throw new RuntimeException("刷新 token 已过期");
            }

            // 获取用户 ID
            int userId = decodedToken.getClaim("userId").asInt();

            // 生成新的访问 token
            return createRefresh(userId);
        } catch (Exception e) {
            throw new RuntimeException("刷新 token 无效", e);
        }
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
