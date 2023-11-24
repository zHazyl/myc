package com.tnh.messageservice.domain;

import com.mongodb.lang.NonNull;
import com.tnh.messageservice.domain.emoji.Emoji;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "messages")
public record MessageDocument(
        @Id String id,
        @NonNull String content,
        @NonNull String type,
        Emoji emoji
) {}
