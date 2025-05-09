package com.metrica.vibely.data.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.time.LocalDateTime;
import java.util.UUID;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.metrica.vibely.data.model.dto.MessageDTO;
import com.metrica.vibely.data.model.enumerator.MessageState;
import com.metrica.vibely.data.model.enumerator.MessageStatus;

class MessageDTOTest {

    // <<-CONSTANTS->>
    private static final String CONTENT = "content";
    private static final MessageStatus STATUS = MessageStatus.PENDING;
    private static final MessageState STATE = MessageState.ENABLED;
    private static final LocalDateTime CREATION_TIMESTAMP = LocalDateTime.now();

    // <<-METHODS->>
    @Test
    @Tag("Constructors")
    void voidConstructorTest() {
        UUID messageId = UUID.randomUUID();
        UUID chat = UUID.randomUUID();
        UUID sender = UUID.randomUUID();

        MessageDTO message = new MessageDTO();

        message.setMessageId        (messageId);
        message.setCreationTimestamp(CREATION_TIMESTAMP);
        message.setStatus           (STATUS);
        message.setState			(STATE);
        message.setContent          (CONTENT);
        message.setChat             (chat);
        message.setSender           (sender);

        assertEquals(messageId,          message.getMessageId());
        assertEquals(CREATION_TIMESTAMP, message.getCreationTimestamp());
        assertEquals(STATUS,             message.getStatus());
        assertEquals(STATE,				 message.getState());
        assertEquals(CONTENT,            message.getContent());
        assertEquals(chat,               message.getChat());
        assertEquals(sender,             message.getSender());
    }

    @Test
    @Tag("Constructors")
    void fullArgsConstructorTest() {
        UUID messageId = UUID.randomUUID();
        UUID chat = UUID.randomUUID();
        UUID sender = UUID.randomUUID();

        MessageDTO message = new MessageDTO(
                messageId,
                CREATION_TIMESTAMP,
                STATUS,
                STATE,
                CONTENT,
                chat,
                sender);

        assertEquals(messageId,          message.getMessageId());
        assertEquals(CREATION_TIMESTAMP, message.getCreationTimestamp());
        assertEquals(STATUS,             message.getStatus());
        assertEquals(STATE,				 message.getState());
        assertEquals(CONTENT,            message.getContent());
        assertEquals(chat,               message.getChat());
        assertEquals(sender,             message.getSender());
    }

    @Test
    @Tag("Equality")
    void basicEqualityTest() {
        MessageDTO message = new MessageDTO();

        assertEquals   (message, message);
        assertNotEquals(message, null);
        assertNotEquals(message, "");
    }

    @Test
    @Tag("Equality")
    void equalityByIdAndHashCodeTest() {
        MessageDTO message1 = new MessageDTO();
        MessageDTO message2 = new MessageDTO();
        UUID uuid = UUID.randomUUID();

        // Both the same ID
        message1.setMessageId(uuid);
        message1.setCreationTimestamp(CREATION_TIMESTAMP);
        message1.setStatus(STATUS);
        message1.setState(STATE);
        message1.setContent(CONTENT);

        message2.setMessageId(uuid);
        message2.setCreationTimestamp(CREATION_TIMESTAMP);
        message2.setStatus(STATUS);
        message2.setState(STATE);
        message2.setContent(CONTENT);

        assertEquals(message1, message2);
        assertEquals(message1.hashCode(), message2.hashCode());
    }

    @Test
    void inequalityByFieldsTest() {
        MessageDTO message1 = new MessageDTO();
        MessageDTO message2 = new MessageDTO();

        message1.setMessageId(UUID.randomUUID());
        message1.setCreationTimestamp(CREATION_TIMESTAMP);
        message1.setStatus(STATUS);
        message1.setState(STATE);
        message1.setContent(CONTENT);

        message2.setMessageId(UUID.randomUUID());
        message2.setCreationTimestamp(CREATION_TIMESTAMP);
        message2.setStatus(STATUS);
        message2.setState(STATE);
        message2.setContent(CONTENT);

        assertNotEquals(message1, message2);
    }
}
