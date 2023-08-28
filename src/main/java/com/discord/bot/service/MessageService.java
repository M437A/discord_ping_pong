package com.discord.bot.service;

import com.discord.bot.dto.MessageDto;
import com.discord.bot.entity.MessageEntity;
import com.discord.bot.repository.MessageRepository;
import com.discord.bot.validator.MessageValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageValidator validator;
    private final MessageRepository messageRepository;
    @Value("${services.discord.answer}")
    private String answer;

    public void saveMessage(MessageDto message) {
        if (validator.hasWordInMessage(message.getContentRaw())) {
            messageRepository.save(new MessageEntity());
            message.getChannel()
                    .sendMessage(answer)
                    .queue();
        }
    }
}