package com.item.study.service.socket;

import java.io.IOException;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 * <p>
 * const socket = new WebSocket('ws://192.168.253.110:9736/xxx?xxx=' + Date.now());
 * socket.onopen = () => {
 * console.log('------>open')
 * }
 * socket.onmessage = (e) => {
 * const msg = JSON.parse(e.data);
 * console.log(msg)
 * }
 * socket.onerror = (e) => {
 * console.log(e)
 * }
 * socket.onclose = () => {
 * console.log('------>close')
 * }
 * const msg = {
 * toUser: 1231231231231,
 * message: '啥哈哈哈哈'
 * }
 * socket.send(JSON.stringify(msg))
 */

@Component
public class SocketHandler extends TextWebSocketHandler {
    public SocketHandler() {
        createPing();
    }

    // 建立连接成功 -连接成功后的操作
    @Override
    public void afterConnectionEstablished(WebSocketSession session) {
//         Object token = session.getAttributes().get("token"); session.getId();
//         session.getRemoteAddress()/.getHostName()/.getUri();
    }

    // 收到消息后的处理
//    @Override
//    public void handleMessage(WebSocketSession session, WebSocketMessage message) throws Exception {
//        super.handleMessage(session, message);
//    }

    // 接收消息
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        // 获得客户端传来的消息
        String payload = message.getPayload();
        parseMessage(session, payload);
    }

    // 断开连接
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) {
    }

    // 发生错误后的处理
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

//    @Override
//    public boolean supportsPartialMessages() {
//        return super.supportsPartialMessages();
//    }

    // 处理接收到的消息
    private void parseMessage(WebSocketSession session, String data) {
        System.out.println("SHandler ---> msg:" + data);

    }

    // 发送消息
    private void sendMessageById(int id, String data) {

    }

    // 发送消息
    private void sendMessage(WebSocketSession session, String data) {
        try {
            TextMessage msg = new TextMessage(data);
//            System.out.println("SHandler ---> sendMsg ！" + data);
            session.sendMessage(msg);
        } catch (IOException e) {
            System.out.println("SocketHandler ---> sendMsg Err ！" + e.getMessage());
        }
    }

    // 启动心跳扫描-设备连接状态 -5分钟一次
    private void createPing() {
//        System.out.println("SHandler ---> createPing：" + Thread.currentThread().getId());
    }

    /**
     * 客户端连续3次，无响应即认为连接断开
     */
    private void runPing() {
//        System.out.println("SHandler ---> runPing：" + Thread.currentThread().getId());
    }

    // 更新时间 -
    private void updatePing(int id) {
    }
}
