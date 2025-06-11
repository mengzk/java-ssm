package com.item.study.model.dto;

public class SseErrDTO {
    public ErrMsg error;

    public SseErrDTO(String code, String message) {
        ErrMsg msg = new ErrMsg(code, message);
        this.error = msg;
    }

    public static class ErrMsg {
        public String code;
        public String message;

        public ErrMsg(String code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
