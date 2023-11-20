package com.tnh.messageservice.controller;

import com.tnh.messageservice.domain.FriendMessage;
import com.tnh.messageservice.dto.MessageDTO;
import com.tnh.messageservice.service.MessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/messages")
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @PostMapping("/save")
    public Mono<MessageDTO> save(@RequestBody MessageDTO messageDTO) {
        return messageService.saveMessage(new FriendMessage.Builder()
                .setContent(messageDTO.content())
                .setType(messageDTO.type())
                .setSendId("01")
                .setRecipientId("02")
                .build())
                .thenReturn(messageDTO);
    }
}
