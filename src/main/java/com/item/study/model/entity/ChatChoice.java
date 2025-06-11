package com.item.study.model.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ChatChoice {

    public List<ChoicesDTO> choices;
    public Integer created;
    public String id;
    public String model;
    public String request_id;
//    public UsageDTO usage;

    public List<ChoicesDTO> getChoices() {
        return choices;
    }

    public static class UsageDTO {
        @JsonProperty("completion_tokens")
        public Integer completionTokens;
        @JsonProperty("prompt_tokens")
        public Integer promptTokens;
        @JsonProperty("total_tokens")
        public Integer totalTokens;
    }

    public static class ChoicesDTO {
        @JsonProperty("finish_reason")
        public String finishReason;
        @JsonProperty("index")
        public Integer index;
        @JsonProperty("message")
        public MessageDTO message;

        public static class MessageDTO {
            @JsonProperty("content")
            public String content;
            @JsonProperty("role")
            public String role;

            @Override
            public String toString() {
                return "{" +
                        "content='" + content + '\'' +
                        ", role='" + role + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "{" +
                    "finishReason='" + finishReason + '\'' +
                    ", index=" + index +
                    ", message=" + message +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ChatChoice{" +
                "choices=" + choices +
                ", created=" + created +
                ", id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", request_id='" + request_id + '\'' +
                '}';
    }
}
