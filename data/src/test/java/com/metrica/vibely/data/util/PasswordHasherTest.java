package com.metrica.vibely.data.util;

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
}
