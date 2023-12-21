package com.metrica.vibely.service.impl;

import com.metrica.vibely.data.entity.Chat;
import com.metrica.vibely.data.entity.Message;
import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.model.dto.MessageDTO;
import com.metrica.vibely.data.model.enumerator.MessageState;
import com.metrica.vibely.data.model.enumerator.MessageStatus;
import com.metrica.vibely.data.model.mapper.MessageMapper;
import com.metrica.vibely.data.repository.ChatRepository;
import com.metrica.vibely.data.repository.MessageRepository;
import com.metrica.vibely.data.repository.UserRepository;
import com.metrica.vibely.service.MessageService;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {

//  <<--FIELDS-->>
    private MessageRepository messageRepository;
    private ChatRepository chatRepository;
    private UserRepository userRepository;

//  <<--CONSTRUCTOR-->>
    @Autowired
    public MessageServiceImpl(final MessageRepository messageRepository, final ChatRepository chatRepository, final UserRepository userRepository) {
        this.messageRepository = messageRepository;
        this.chatRepository = chatRepository;
        this.userRepository = userRepository;
    }
}