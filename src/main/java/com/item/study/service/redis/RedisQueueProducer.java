package com.item.study.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisQueueProducer {
    @Autowired
    private StringRedisTemplate redisTemplate;

    private static final String QUEUE_NAME = "messageQueue";

    public void sendMessage(String message) {
        redisTemplate.opsForList().leftPush(QUEUE_NAME, message);
    }
}