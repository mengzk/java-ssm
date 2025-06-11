package com.item.study.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.item.study.model.result.ResultBody;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.Refill;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * Author: Meng
 * Date: 2024-12-20
 * Desc: 限流拦截器
 */

@Component
public class RateLimitInterceptor implements HandlerInterceptor {
    private final ConcurrentMap<String, Bucket> buckets = new ConcurrentHashMap<>();
    private long count = 0;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = request.getRemoteAddr();
        Bucket bucket = buckets.computeIfAbsent(ip, k -> createNewBucket());
        if (bucket.tryConsume(1)) {
            count = 0;
            return true;
        } else {
            count++; // 根据不同次数，返回不同的提示
            writeResponse(response, 429, "Warning Please stop immediately");
            return false;
        }
    }

    private Bucket createNewBucket() {
        // capacity:表示桶的容量，即最多允许10000个请求，tokens:表示每分钟以贪婪的方式填充100个令牌
        Bandwidth limit = Bandwidth.classic(5000, Refill.greedy(100, Duration.ofMinutes(1)));
        return Bucket.builder().addLimit(limit).build();
    }

    /**
     * 包装返回结果
     */
    private void writeResponse(HttpServletResponse response, int status, String message) throws IOException {
        ResultBody body = ResultBody.fail(status, message);
        response.setStatus(status);
        response.setContentType("application/json;charset=utf-8");
        ObjectMapper mapper = new ObjectMapper();
        response.getWriter().write(mapper.writeValueAsString(body));
    }
}
