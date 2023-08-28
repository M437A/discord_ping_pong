package com.discord.bot.mapper;

import com.discord.bot.dto.MessageDto;
import net.dv8tion.jda.api.entities.Message;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.FIELD,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MessageMapper {
    MessageDto toDto(Message message);
}
