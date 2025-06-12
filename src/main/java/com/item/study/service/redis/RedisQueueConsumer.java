package com.item.study.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisQueueConsumer {
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String QUEUE_NAME = "messageQueue";

    public String consumeMessage() {
        return redisTemplate.opsForList().rightPop(QUEUE_NAME);
    }
}