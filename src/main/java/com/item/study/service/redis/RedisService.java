package com.item.study.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * 如果需要用作缓存，可在启动类加上 @EnableCaching 注解，
 * 并在业务方法上使用 @Cacheable、@CachePut、@CacheEvict 等注解。
 * 这样即可实现 Redis 的基本功能，如缓存、分布式锁、消息队列等。
 *
 * 优化 Redis 性能可以从以下几个方面入手：
 * - 合理设置过期时间
 * 为存储的键设置过期时间，避免无用数据长期占用内存。
 * - 使用批量操作
 * 尽量使用 pipeline 批量执行命令，减少网络开销。
 * - 选择合适的数据结构
 * 根据场景选择合适的数据结构（如 Hash、Set、SortedSet），减少内存占用。
 * - 开启持久化
 * 根据需求选择 RDB 或 AOF 持久化方式，确保数据安全。
 * - 使用连接池
 * 配置连接池（如 Lettuce 或 Jedis），提高连接效率。
 * - 优化内存配置
 * 调整 Redis 的 maxmemory 和 maxmemory-policy，避免内存溢出。
 * - 使用分片或集群
 * 对大规模数据使用 Redis Cluster 或分片，提升读写性能。
 * - 监控和调优
 * 使用工具（如 redis-cli 或 RedisInsight）监控 Redis 性能，及时发现瓶颈。
 * - 减少阻塞操作
 * 避免使用耗时的命令（如 keys），改用 scan 等非阻塞操作。
 * - 开启压缩
 * 对传输的数据进行压缩，减少网络带宽占用。
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
