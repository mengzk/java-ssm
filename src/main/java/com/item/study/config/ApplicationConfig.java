package com.item.study.config;

/**
 * Author: Meng
 * Date: 2024-12-20
 * Desc: 配置类
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationConfig implements WebMvcConfigurer {

    private final AuthInterceptor authInterceptor = new AuthInterceptor();
    private final RateLimitInterceptor rateLimitInterceptor = new RateLimitInterceptor();

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(rateLimitInterceptor)
                .addPathPatterns("/**");
        registry.addInterceptor(authInterceptor)
                .addPathPatterns("/**") // Apply to all endpoints
                .excludePathPatterns("/account/login", "/account/register"); // Exclude login and register endpoints
    }
}
