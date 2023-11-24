package com.tnh.messageservice.service.impl;

import com.tnh.messageservice.domain.Message;
import com.tnh.messageservice.domain.MessageDocument;
import com.tnh.messageservice.domain.emoji.EmojiFactory;
import com.tnh.messageservice.repository.MessageRepository;
import com.tnh.messageservice.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {
    private final MessageRepository messageRepository;
    @Value("special")
    String special;

    @Override
    public Mono<MessageDocument> saveMessage(Message message) {
        UUID id = UUID.randomUUID();
        return messageRepository.save(new MessageDocument(id.toString(),
                message.getContent(),
                message.getType(),
                EmojiFactory.getEmoji(message.getEmoji(), special)));
    }
}
