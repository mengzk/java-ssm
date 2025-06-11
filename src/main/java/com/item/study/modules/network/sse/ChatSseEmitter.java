package com.item.study.modules.network.sse;

import com.google.gson.Gson;
import com.item.study.model.dto.SseErrDTO;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc: 服务器推送事件
 *
 @PostMapping(path = "/chat", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
 public SseEmitter onChat(@RequestBody() ChatBody body, HttpServletResponse res) {
     ChatSseEmitter sseEmitter = new ChatSseEmitter();
     String data = service.sse(body.msg);
     if (data == null) {
        sseEmitter.error("1011", "数据异常");
     } else {
         sseEmitter.sendMsg(SseChatDTO.start(body.id, data, System.currentTimeMillis()));
         sseEmitter.sendMsg(new SseChatDTO(data, body.id));
         sseEmitter.sendMsg(SseChatDTO.stop(body.id, data, System.currentTimeMillis()));
         sseEmitter.complete();
     }
     return sseEmitter.getEmitter();
 }
 */
public class ChatSseEmitter {

    private SseEmitter emitter;

    public ChatSseEmitter() {
        emitter = new SseEmitter(10000L);

        emitter.onCompletion(() -> {
            System.out.println("ChatSseEmitter ------> onCompletion: ");
        });

        emitter.onTimeout(() -> {
            System.out.println("ChatSseEmitter ------> onTimeout: ");
        });

        emitter.onError((e) -> {
            System.out.println("ChatSseEmitter ------> onError: "+e.getMessage());
        });
    }

    public void sendMsg(Object body) {
        Gson gson = new Gson();
        try {
            SseEmitter.SseEventBuilder msg = SseEmitter.event().name("data").data(gson.toJson(body));
            emitter.send(msg);
//            msg = SseEmitter.event().name("msg").data(gson.toJson(body));
//            emitter.send(msg);
        } catch (Exception e) {
            System.out.println("ChatSseEmitter ------> sendMsg: "+e.getMessage());
        }
        // 数据发送完成后，关闭连接
//        emitter.complete();
    }

    public void error(String code, String text) {
        Gson gson = new Gson();
        try {
            SseEmitter.SseEventBuilder msg = SseEmitter.event().name("error").data(gson.toJson(new SseErrDTO(code, text)));
            emitter.send(msg);
        } catch (Exception e) {
            System.out.println("ChatSseEmitter ------> error: "+e.getMessage());
        }
        complete();
    }

    // 数据发送完成后，关闭连接
    public void complete() {
        emitter.complete();
    }

    public SseEmitter getEmitter() {
        return emitter;
    }
}
