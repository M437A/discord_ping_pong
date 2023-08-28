package com.discord.bot.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.dv8tion.jda.api.entities.channel.unions.MessageChannelUnion;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDto {
    private long id;
    private String effectiveName;
    private String contentRaw;
    private MessageChannelUnion channel;
}
