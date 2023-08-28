package com.discord.bot.message;

import com.discord.bot.dto.MessageDto;
import com.discord.bot.mapper.MessageMapper;
import com.discord.bot.service.MessageService;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class MessageHandlerTest {
    @InjectMocks
    private MessageHandler messageHandler;
    @Mock
    private MessageService messageService;
    @Mock
    private MessageMapper messageMapper;
    @Mock
    private MessageReceivedEvent event;

    @Test
    public void testOnMessageReceived() {
        MessageDto message = new MessageDto();
        Mockito.when(messageMapper.toDto(any()))
                .thenReturn(message);

        messageHandler.onMessageReceived(event);
        Mockito.verify(messageMapper).toDto(any());
        Mockito.verify(messageService).saveMessage(message);
        return;
    }
}