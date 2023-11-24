package com.tnh.messageservice.dto;

public record MessageDTO(
        String content,
        String type,
        String recipient,
        String sender,
        String emoji
) {
}
