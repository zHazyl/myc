package com.tnh.messageservice.repository;

import com.tnh.messageservice.domain.MessageDocument;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MessageRepository extends ReactiveCrudRepository<MessageDocument, String> {
}
