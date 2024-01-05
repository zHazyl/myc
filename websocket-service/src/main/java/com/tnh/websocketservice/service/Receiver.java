package com.tnh.websocketservice.service;

import com.tnh.websocketservice.model.Message;

public interface Receiver {
    public void consume(Message message);
}
