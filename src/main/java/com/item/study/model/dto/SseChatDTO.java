package com.item.study.model.dto;

public class SseChatDTO {
    public String id;
    public String msg;
    public String model;
    public Long created;

    public SseChatDTO(String msg, String id) {
        this.id = id;
        this.msg = msg;
    }

    public static SseChatDTO start(String id, String msg, Long created) {
        SseChatDTO dto = new SseChatDTO(msg, id);
        dto.created = created;
        dto.model = "start";
        return dto;
    }

    public static SseChatDTO stop(String id, String msg, Long created) {
        SseChatDTO dto = new SseChatDTO(msg, id);
        dto.created = created;
        dto.model = "stop";
        return dto;
    }

}
