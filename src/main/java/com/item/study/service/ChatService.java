package com.item.study.service;

import com.item.study.modules.network.sse.ChatSseEmitter;
import com.item.study.modules.network.sse.SseResult;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 服务
 */
@Service
public class ChatService {

    //
    public SseEmitter chat(String msg) {
        ChatSseEmitter sseEmitter = new ChatSseEmitter();

        System.out.println(msg);
        if (msg == null) {
            sseEmitter.error("1011", "数据异常");
        } else {
            sseEmitter.sendMsg(SseResult.start("1", "start"));
            sseEmitter.sendMsg(new SseResult("2", "body: " + msg));
            sseEmitter.sendMsg(SseResult.stop("3", "stop"));
        }
        sseEmitter.complete();
        return sseEmitter.getEmitter();
    }

}
