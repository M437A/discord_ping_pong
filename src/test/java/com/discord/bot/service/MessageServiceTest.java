package com.discord.bot.service;

import com.discord.bot.dto.MessageDto;
import com.discord.bot.repository.MessageRepository;
import com.discord.bot.validator.MessageValidator;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;
import net.dv8tion.jda.api.requests.restaction.MessageCreateAction;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
class MessageServiceTest {
    @InjectMocks
    private MessageService messageService;
    @Mock
    private MessageValidator messageValidator;
    @Mock
    private MessageRepository messageRepository;
    @Mock
    private MessageChannelUnion messageChannelUnion;
    @Mock
    private MessageCreateAction messageCreateAction;

    @Test
    public void testSaveMessage_true() {
        MessageDto message = MessageDto.builder()
                .contentRaw("!ping")
                .channel(messageChannelUnion)
                .build();

        Mockito.when(messageValidator.hasWordInMessage(anyString()))
                .thenReturn(true);
        Mockito.when(messageChannelUnion.sendMessage(anyString()))
                        .thenReturn(messageCreateAction);

        messageService.saveMessage(message);

        Mockito.verify(messageValidator, Mockito.times(1))
                .hasWordInMessage(any());
        Mockito.verify(messageRepository, Mockito.times(1))
                .save(any());
        Mockito.verify(messageChannelUnion, Mockito.times(1))
                .sendMessage((CharSequence) any());
    }

    @Test
    public void testSaveMessage_false() {
        MessageDto message = MessageDto.builder()
                .contentRaw("!ping")
                .channel(messageChannelUnion)
                .build();

        Mockito.when(messageValidator.hasWordInMessage(anyString()))
                .thenReturn(false);

        messageService.saveMessage(message);

        Mockito.verify(messageValidator, Mockito.times(1))
                .hasWordInMessage(any());
        Mockito.verify(messageRepository, Mockito.times(0))
                .save(any());
        Mockito.verify(messageChannelUnion, Mockito.times(0))
                .sendMessage((CharSequence) any());
    }
}