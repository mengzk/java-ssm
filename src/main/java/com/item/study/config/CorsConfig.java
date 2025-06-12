package com.item.study.config;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CorsConfig implements WebMvcConfigurer {

    // 这里可以添加跨域配置方法
    @Override
    public void addCorsMappings(org.springframework.web.servlet.config.annotation.CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*") // 允许所有域名进行跨域调用
//                .allowedOriginPatterns("*") // 允许所有域名进行跨域调用（Spring 5.2+）
                .maxAge(3600) // 预检请求的缓存时间，单位为秒
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 允许的请求方法
                .allowedHeaders("*") // 允许所有请求头
                .allowCredentials(true); // 允许发送cookie
    }
}
