package com.tnh.messageservice.domain;

public class FriendMessage extends Message {
    String sendId;
    String recipientId;
    public static class Builder extends Message.Builder<Builder> {
        String sendId;
        String recipientId;
        public Builder setSendId(String id) {
            this.sendId = id;
            return self();
        }
        public Builder setRecipientId(String id) {
            this.recipientId = id;
            return self();
        }
        @Override
        public FriendMessage build() {
            return new FriendMessage(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

    }
    private FriendMessage(Builder builder) {
        super(builder);
        this.sendId = builder.sendId;
        this.recipientId = builder.recipientId;
    }
}
