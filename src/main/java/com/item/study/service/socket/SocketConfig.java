package com.item.study.service.socket;

import com.item.study.config.Configs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc: websocket接口配置
 * ws://192.168.8.107:9736/xxx?xxx=xxx
 */

@Configuration
@EnableWebSocket
public class SocketConfig implements WebSocketConfigurer {
//  @Autowired
//  private SocketHandler socketHandler;

  @Autowired
  private SocketInterceptor socketInterceptor;

  /**
   * 设置连接的路由、处理相关类
   * addHandler：设置websocket的处理类和相应接口URL："/xxx"
   * setAllowedOrigins：设置链接允许，*代码允许所有情况，需要进行此设置，不然可能导致连接失败
   */
  @Override
  public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
    registry.addHandler(customHandler(), Configs.WS_PATH).addInterceptors(socketInterceptor).setAllowedOrigins("*");
  }

  // 自定义handler
  private SocketHandler customHandler() {
    return new SocketHandler();
  }
}
