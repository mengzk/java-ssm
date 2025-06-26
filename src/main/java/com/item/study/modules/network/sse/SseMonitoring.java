package com.item.study.modules.network.sse;

import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 可以通过以下方式监控 SSE 连接的性能：
 * <p>
 * 连接数统计：记录当前活跃的 SSE 连接数。
 * 消息发送统计：统计每个连接发送的消息数量和频率。
 * 延迟监控：测量消息从服务端发送到客户端接收的时间。
 * 错误监控：记录连接超时、异常等错误信息。
 * 资源使用监控：监控线程池、内存等资源的使用情况。
 */
public class SseMonitoring {

    private static final ExecutorService executor = Executors.newCachedThreadPool();
    private static final AtomicInteger activeConnections = new AtomicInteger(0);
    private static final AtomicInteger totalMessagesSent = new AtomicInteger(0);

    public SseEmitter createEmitter(String msg) {
        SseEmitter emitter = new SseEmitter(30000L);

        activeConnections.incrementAndGet();
        System.out.println("当前活跃连接数: " + activeConnections.get());

        emitter.onCompletion(() -> {
            activeConnections.decrementAndGet();
            System.out.println("连接已完成，当前活跃连接数: " + activeConnections.get());
        });

        emitter.onTimeout(() -> {
            activeConnections.decrementAndGet();
            System.out.println("连接超时，当前活跃连接数: " + activeConnections.get());
        });

        executor.submit(() -> {
            try {
                for (int num = 0; num < 3; num++) {
                    emitter.send("data: 你好，" + msg + "，第" + (num + 1) + "次\n\n");
                    totalMessagesSent.incrementAndGet();
                    System.out.println("消息已发送，总发送消息数: " + totalMessagesSent.get());
                    Thread.sleep(1000); // 模拟延迟
                }
                emitter.complete();
            } catch (Exception e) {
                emitter.completeWithError(e);
            }
        });

        return emitter;
    }
}