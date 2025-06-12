package com.item.study.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class RedisQueueConsumer {
    private static final String QUEUE_NAME = "messageQueue";
    private static final String DEAD_LETTER_QUEUE = "deadLetterQueue";
    @Autowired
    private StringRedisTemplate redisTemplate;

    public String consumeMessage() {
        try {
            String message = redisTemplate.opsForList().rightPop(QUEUE_NAME);
            if (message == null) {
                throw new RuntimeException("队列为空，未消费到消息");
            }
            // 处理消息逻辑
            return message;
        } catch (Exception e) {
            // 记录错误日志
            System.err.println("消费消息时发生错误: " + e.getMessage());
            // 可选择重试或其他处理逻辑
            return null;
        }
    }

    public void consumeMessageWithRetry() {
        try {
            String message = redisTemplate.opsForList().rightPop(QUEUE_NAME);
            if (message == null) {
                throw new RuntimeException("队列为空，未消费到消息");
            }
            // 处理消息逻辑
        } catch (Exception e) {
            System.err.println("消费消息失败，重试: " + e.getMessage());
            redisTemplate.opsForList().leftPush(QUEUE_NAME, "失败消息");
        }
    }

    public void consumeMessageWithTimeout() {
        try {
            String message = String.valueOf(redisTemplate.opsForList().rightPop(QUEUE_NAME, 5)); // 设置超时时间为5秒
            if (message == null) {
                throw new RuntimeException("队列为空，未消费到消息");
            }
            // 处理消息逻辑
        } catch (Exception e) {
            System.err.println("消费消息时发生错误: " + e.getMessage());
            // 可选择重试或其他处理逻辑
        }
    }

    public void consumeMessageWithBlocking() {
        try {
            String message = String.valueOf(redisTemplate.opsForList().rightPop(QUEUE_NAME, 0)); // 阻塞等待直到有消息
            if (message == null) {
                throw new RuntimeException("队列为空，未消费到消息");
            }
            // 处理消息逻辑
        } catch (Exception e) {
            System.err.println("消费消息时发生错误: " + e.getMessage());
            // 可选择重试或其他处理逻辑
        }
    }

    public void handleFailedMessage(String message) {
        redisTemplate.opsForList().leftPush(DEAD_LETTER_QUEUE, message);
    }

    public long getQueueLength() {
        return redisTemplate.opsForList().size(QUEUE_NAME);
    }

    public void logQueueMetrics() {
        long length = getQueueLength();
        System.out.println("当前队列长度: " + length);
    }
}