package com.tnh.websocketservice.service.impl;

import com.tnh.websocketservice.model.Message;
import com.tnh.websocketservice.service.Sender;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SenderImpl implements Sender {
    private final KafkaTemplate<String, Message> kafkaTemplate;

    @Override
    public void send(String topic, Message message) {
        kafkaTemplate.send(topic, message);
    }
}
