package com.discord.bot.validator;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessageValidator {
    @Value("${services.discord.targetWord}")
    private String targetWord = "!ping";

    public boolean hasWordInMessage(String message) {
        if (message == null || message.isBlank()) {
            return false;
        }

        String[] words = message.split("\\s+");
        for (String w : words) {
            if (w.equals(targetWord)) {
                return true;
            }
        }
        return false;
    }
}