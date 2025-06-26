package com.item.study.modules.network.sse;

public class SseResult {
    public String id;
    public String msg;
    public String model;
    public Long created;


    public SseResult(String msg, String id) {
        this.id = id;
        this.msg = msg;
    }

    public static SseResult start(String id, String msg) {
        SseResult dto = new SseResult(msg, id);
        dto.model = "start";
        dto.created = System.currentTimeMillis();
        return dto;
    }

    public static SseResult stop(String id, String msg) {
        SseResult dto = new SseResult(msg, id);
        dto.model = "stop";
        dto.created = System.currentTimeMillis();
        return dto;
    }
}
