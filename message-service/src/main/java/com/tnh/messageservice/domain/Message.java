package com.tnh.messageservice.domain;

import com.tnh.messageservice.domain.emoji.Emoji;
import lombok.Getter;

@Getter
public abstract class Message {
    private String content;
    private String type;
    private String emoji;

    public static abstract class Builder<T extends Builder<T>> {
        String content = "";
        String type = "";
        public T setContent(String content) {
            this.content = content;
            return self();
        }
        public T setType(String type) {
            this.type = type;
            return self();
        }
        public abstract Message build();
        protected abstract T self();
    }

    Message(Builder<?> builder) {
        content = builder.content;
        type = builder.type;
    }
}
