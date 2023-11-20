package com.tnh.messageservice.service;

import com.tnh.messageservice.domain.Message;
import com.tnh.messageservice.domain.MessageDocument;
import reactor.core.publisher.Mono;

public interface MessageService {
    Mono<MessageDocument> saveMessage(Message message);
}
