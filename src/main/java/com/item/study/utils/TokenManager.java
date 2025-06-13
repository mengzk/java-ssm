package com.item.study.utils;

import org.springframework.data.redis.core.RedisTemplate;
import java.util.concurrent.TimeUnit;

/**
 *
 * 存储 token：将 token 存储到 Redis 中，设置过期时间。
 * 校验 token：每次请求时从 Redis 中校验 token 是否有效。
 * 失效处理：当 token 过期或被删除时，用户需要重新登录。
 * 强制下线：通过删除 Redis 中的 token 实现强制下线。
 */
public class TokenManager {
    private RedisTemplate<String, String> redisTemplate;

    public TokenManager(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    // 保存 token 到 Redis，设置过期时间
    public void save(String token, int userId, long expiration) {
        redisTemplate.opsForValue().set("token:" + token, String.valueOf(userId), expiration, TimeUnit.MILLISECONDS);
    }

    // 校验 token 是否有效
    public boolean validate(String token) {
        String userId = redisTemplate.opsForValue().get("token:" + token);
        return userId != null;
    }

    // 强制下线（删除 token）
    public void invalidate(String token) {
        redisTemplate.delete("token:" + token);
    }

    // 获取用户 ID
    public Integer getId(String token) {
        String userId = redisTemplate.opsForValue().get("token:" + token);
        return userId != null ? Integer.parseInt(userId) : null;
    }
}