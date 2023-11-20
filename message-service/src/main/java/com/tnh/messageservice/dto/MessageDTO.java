package com.tnh.messageservice.dto;

import java.io.Serializable;

public record MessageDTO(
        String content,
        String type,
        String recipient,
        String sender
) implements Serializable {
}
