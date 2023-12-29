package com.metrica.vibely.service.impl;

import com.metrica.vibely.data.entity.Chat;
import com.metrica.vibely.data.entity.Message;
import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.model.dto.ChatDTO;
import com.metrica.vibely.data.model.enumerator.ChatState;
import com.metrica.vibely.data.model.enumerator.ChatStatus;
import com.metrica.vibely.data.model.enumerator.ChatType;
import com.metrica.vibely.data.model.mapper.ChatMapper;
import com.metrica.vibely.data.repository.ChatRepository;
import com.metrica.vibely.data.repository.UserRepository;
import com.metrica.vibely.service.ChatService;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

public class ChatServiceImpl implements ChatService {
	
	    // ATRIBUTES
		UserRepository userRepository;
		ChatRepository chatRepository;
		
		// CONSTRUCTOR
		public ChatServiceImpl(UserRepository userRepository, ChatRepository chatRepository) {
			this.userRepository = userRepository;
			this.chatRepository = chatRepository;
		}
}
