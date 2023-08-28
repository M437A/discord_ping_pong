package com.discord.bot.message;

import com.discord.bot.dto.MessageDto;
import com.discord.bot.mapper.MessageMapper;
import com.discord.bot.service.MessageService;
import discord4j.core.object.entity.Message;
import lombok.RequiredArgsConstructor;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class MessageHandler extends ListenerAdapter {
    private final MessageService messageService;
    private final MessageMapper messageMapper;

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        MessageDto message = messageMapper.toDto(event.getMessage());
        messageService.saveMessage(message);
    }
}