package com.item.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * 单体服务在高并发场景下常用的处理方式有：
 * 数据库优化：使用索引、分区、分表等方式提升查询性能。
 * 连接池：为数据库、Redis等中间件配置连接池，避免频繁创建销毁连接。
 * 缓存：使用本地缓存（如Guava、Caffeine）或分布式缓存（如Redis）减轻数据库压力。
 * 异步处理：通过消息队列（如RabbitMQ、Kafka）或线程池异步处理耗时任务，提升响应速度。
 * 限流与降级：使用限流（如令牌桶、漏桶算法）和服务降级（如返回默认值）保护系统。
 * 批量操作：合并多次请求为一次批量操作，减少资源消耗。
 * 读写分离：数据库主从分离，读写分担压力。
 * 合理配置JVM参数：优化GC、线程数等，提升并发能力。
 * 无锁/少锁编程：减少锁竞争，采用并发集合、CAS等方式
 */

@EnableCaching
@EnableScheduling
@SpringBootApplication
public class StudyApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyApplication.class, args);
	}

}
