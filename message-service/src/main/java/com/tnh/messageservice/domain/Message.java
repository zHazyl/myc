package com.tnh.messageservice.domain;

public abstract class Message {
    private String content;

    public static abstract class Builder<T extends Builder<T>> {
        String content = "";
        public T fillContent(String content) {
            this.content = content;
            return self();
        }
        public abstract Message build();
        protected abstract T self();
    }

    Message(Builder<?> builder) {
        content = builder.content;
    }

}
