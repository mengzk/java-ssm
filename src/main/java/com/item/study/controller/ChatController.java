package com.item.study.controller;

import com.item.study.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * Author: Meng
 * Date: 2024-07-23
 * Desc:
 */

@RestController
@RequestMapping("/robot")
public class ChatController {
    @Autowired
    private ChatService service;

    // 知识库
    @PostMapping(path = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter onChat(@RequestParam("msg") String msg) {
//        return service.chat(msg);

        // 设置超时时间为30秒
        SseEmitter emitter = new SseEmitter(30000L);
        // 处理连接断开
        emitter.onCompletion(() -> System.out.println("连接已完成"));
        emitter.onTimeout(() -> System.out.println("连接超时"));

        new Thread(() -> {
            try {
                for (int num = 0; num < 3; num++) {
                    emitter.send("data: 你好，" + msg + "，第" + (num + 1) + "次\n\n");
                    Thread.sleep(1000); // 模拟延迟
                }
                emitter.complete();
            } catch (Exception e) {
                emitter.completeWithError(e);
            }
        }).start();
        return emitter;
    }

}
