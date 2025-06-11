package com.item.study.service.socket;

import java.util.Map;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */
@Component
public class SocketInterceptor implements HandshakeInterceptor {

    // 在握手之前调用
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler,
                                   Map<String, Object> attributes) throws Exception {
        // 获得请求参数
        String query = request.getURI().getQuery();
        System.out.println("SInterceptor ---> beforeHandshake：" + query);
        if (query == null || query.isEmpty()) {
            System.out.println("SInterceptor ---> 参数缺失");
            return false;
        }
//        boolean right = query.matches("(id|room)=[0-9]+&(id|room)=[0-9]+");
//        if(!right) {
//            System.out.println("地址不合规范 ws://xxx.xxx.xxx.xxx:xxx/xxx?xxx=xxx&xxx=xxx");
//            return false;
//        }
        return true;
    }

    // 在握手完成后调用
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler handler,
                               Exception exception) {
        System.out.println("SInterceptor ---> afterHandshake：");
    }
}
