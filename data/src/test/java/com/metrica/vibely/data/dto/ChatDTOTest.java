package com.metrica.vibely.data.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.metrica.vibely.data.model.dto.ChatDTO;
import com.metrica.vibely.data.model.enumerator.ChatState;
import com.metrica.vibely.data.model.enumerator.ChatStatus;
import com.metrica.vibely.data.model.enumerator.ChatType;


class ChatDTOTest {

    // <<-CONSTANTS->>
    private static final String TITLE = "Title";
    private static final LocalDateTime CREATION_DATE = LocalDateTime.now();
    private static final LocalDateTime LAST_ACTIVITY = LocalDateTime.now();
    private static final ChatType TYPE = ChatType.DIRECT_MESSAGE;
    private static final ChatStatus STATUS = ChatStatus.ACTIVE;
    private static final ChatState STATE = ChatState.ENABLED;
}