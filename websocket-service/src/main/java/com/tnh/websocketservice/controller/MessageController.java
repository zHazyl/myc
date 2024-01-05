package com.tnh.websocketservice.controller;

import com.tnh.websocketservice.model.Message;
import com.tnh.websocketservice.service.Sender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class MessageController {
    private final Sender sender;
    private final ModelMapper mapper;
    private final SimpMessageSendingOperations messagingTemplate;

    @MessageMapping("/chat.send-message")
    public void sendMessage(@Payload Message chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        chatMessage.setSessionId(headerAccessor.getSessionId());
        sender.send("messaging", chatMessage);
        log.info("Sending message to /topic/public: " + chatMessage);
        messagingTemplate.convertAndSend("/topic/public", chatMessage);
        log.info("Message sent to /topic/public: " + chatMessage);
    }

    @MessageMapping("/chat.add-user")
    @SendTo("/topic/public")
    public Message addUser(
            @Payload Message chatMessage,
            SimpMessageHeaderAccessor headerAccessor
    ) {
        if (headerAccessor.getSessionAttributes() != null) {
            headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        }

        return chatMessage;
    }
}
