package com.metrica.vibely.data.mapper;

import org.junit.jupiter.api.Test;

import com.metrica.vibely.data.entity.Chat;
import com.metrica.vibely.data.entity.Message;
import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.model.dto.ChatDTO;
import com.metrica.vibely.data.model.enumerator.ChatState;
import com.metrica.vibely.data.model.enumerator.ChatStatus;
import com.metrica.vibely.data.model.enumerator.ChatType;
import com.metrica.vibely.data.model.mapper.ChatMapper;

import org.junit.jupiter.api.Tag;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


class ChatMapperTest {

    // <<-CONSTANTS->>
    private static final UUID CHAT_ID = UUID.randomUUID();
    private static final LocalDateTime CREATION_DATE = LocalDateTime.now();
    private static final ChatType TYPE = ChatType.GROUP;
    private static final ChatStatus STATUS = ChatStatus.ACTIVE;
    private static final ChatState STATE = ChatState.ENABLED;
    private static final String TITLE = "Test Chat";
    private static final LocalDateTime LAST_ACTIVITY = LocalDateTime.now();
    

    // <<-METHODS->>
    private ChatDTO createChatDTO() {
        ChatDTO chatDTO = new ChatDTO();
        
        chatDTO.setChatId(CHAT_ID);
        chatDTO.setCreationDate(CREATION_DATE);
        chatDTO.setType(TYPE);
        chatDTO.setStatus(STATUS);
        chatDTO.setState(STATE);
        chatDTO.setTitle(TITLE);
        chatDTO.setLastActivity(LAST_ACTIVITY);

        return chatDTO;
    }
    
    private Chat createChat() {
        Chat chat = new Chat();
        
        chat.setChatId(CHAT_ID);
        chat.setCreationDate(CREATION_DATE);
        chat.setType(TYPE);
        chat.setStatus(STATUS);
        chat.setState(STATE);
        chat.setTitle(TITLE);
        chat.setLastActivity(LAST_ACTIVITY);

        return chat;
    }
