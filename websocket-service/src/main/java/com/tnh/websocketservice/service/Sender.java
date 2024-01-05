package com.tnh.websocketservice.service;

import com.tnh.websocketservice.model.Message;

public interface Sender {
    void send(String topic, Message message);
}
