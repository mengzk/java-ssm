package com.item.study.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 如果需要用作缓存，可在启动类加上 @EnableCaching 注解，
 * 并在业务方法上使用 @Cacheable、@CachePut、@CacheEvict 等注解。
 * 这样即可实现 Redis 的基本功能，如缓存、分布式锁、消息队列等。
 */

@Service
public class RedisService {
    @Autowired
    private StringRedisTemplate redisTemplate;
    private static final String QUEUE_NAME = "messageQueue";

    public void setValue(String key, String value) {
        redisTemplate.opsForValue().set(key, value);
    }

    public String getValue(String key) {
        return redisTemplate.opsForValue().get(key);
    }

    public void delete(String key) {
        redisTemplate.delete(key);
    }

    public boolean exists(String key) {
        return redisTemplate.hasKey(key);
    }

    public void sendMessage(String message) {
        redisTemplate.opsForList().leftPush(QUEUE_NAME, message);
    }

    public String consumeMessage() {
        return redisTemplate.opsForList().rightPop(QUEUE_NAME);
    }
}
