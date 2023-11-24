package com.tnh.messageservice.domain.emoji;

import java.util.Arrays;

public enum EmojiFactory {
    SIMPLE("/simple"),
    CHRISTMAS("/christmas"),
    THANK_GIVING("/thank-giving");
    final String path;
    EmojiFactory(String path) {
        this.path = path;
    }
    public static Emoji getEmoji(String type, String special) {
        return new Emoji(type, Arrays.stream(values()).filter(e -> e.name().toLowerCase().equals(special))
                .findFirst().orElse(SIMPLE).path + "/");
    }
}
