package com.item.study.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Meng
 * Date: 2024-12-20
 * Desc: 缓存配置类
 */

@Configuration
@EnableCaching
public class CacheConfig {
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager("tokens");
    }

    // 其他缓存配置可以在这里添加
    // 例如使用 Redis 缓存
    // @Bean
    // public RedisCacheManager redisCacheManager(RedisConnectionFactory redisConnectionFactory) {
    //     RedisCacheConfiguration cacheConfig = RedisCacheConfiguration.defaultCacheConfig()
    //             .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));
    //     return RedisCacheManager.builder(redisConnectionFactory)
    //             .cacheDefaults(cacheConfig)
    //             .transactionAware()
    //             .build();
    // }
}