package com.discord.bot.validator;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MessageValidatorTest {
    private MessageValidator messageValidator=new MessageValidator();
    @Value("${services.discord.targetWord}")
    private String targetWord;
    @CsvSource({
            "!ping",
            "123 !ping",
            "!ping !ping",
            "!ping 123"
    })
    @ParameterizedTest
    public void testHasWordInMessage_True(String message) {
        assertTrue(messageValidator.hasWordInMessage(message));
    }

    @CsvSource({
            "!pingfin",
            "!!!!!ping",
            "!ping!png",
    })
    @ParameterizedTest
    public void testHasWordInMessage_False(String message) {
        assertFalse(messageValidator.hasWordInMessage(message));
    }

    @Test
    public void testHasWordInMessage_False2() {
        assertFalse(messageValidator.hasWordInMessage(""));
        assertFalse(messageValidator.hasWordInMessage(null));
        assertFalse(messageValidator.hasWordInMessage("   "));
    }
}