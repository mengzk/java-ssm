package com.item.study.model.body;

import java.util.List;

public class ChatSSE {
    public String id;
    public String device_id;
    public boolean stream;
    public List<Msg> messages;

    @Override
    public String toString() {
        return "ChatSSE{" +
                "id='" + id + '\'' +
                ", device_id='" + device_id + '\'' +
                ", stream=" + stream +
                ", messages=" + messages +
                '}';
    }

    public static class Msg {
        public String role;
        public String content;

        @Override
        public String toString() {
            return "{" +
                    "role='" + role + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }
}
