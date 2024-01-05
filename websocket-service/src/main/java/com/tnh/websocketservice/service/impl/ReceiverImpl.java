package com.tnh.websocketservice.service.impl;

import com.tnh.websocketservice.model.Message;
import com.tnh.websocketservice.service.Receiver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ReceiverImpl implements Receiver {
    private final SimpMessageSendingOperations messagingTemplate;
    private final SimpUserRegistry userRegistry;
    @Override
    @KafkaListener(topics = "messaging", groupId = "chat")
    public void consume(Message message) {
        log.info("Received message from Kafka: " + message);
        for (var user: userRegistry.getUsers()) {
            for (var session: user.getSessions()) {
                if (!session.getId().equals(message.getSessionId())) {
                    messagingTemplate.convertAndSendToUser(session.getId(), "/topic/public", message);
                }
            }
        }
    }
}
