package com.tnh.messageservice.controller;

import com.tnh.messageservice.domain.FriendMessage;
import com.tnh.messageservice.domain.Message;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/message-service")
public class MessageController {
    @GetMapping("/demo")
    public Mono<Message> demo() {
        return Mono.just(new FriendMessage.Builder()
            .fillContent("Hello")
            .setSendId("01")
            .setRecipientId("02")
            .build());
    }
}
