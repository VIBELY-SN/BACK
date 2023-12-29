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
		
		@Override
	    public ChatDTO create(ChatDTO ChatDto) {
	    	Set<User> participants = ChatDto.getParticipants().stream()
	    													  .map(p -> userRepository.findById(p).get())
	    													  .collect(Collectors.toSet());
	    	
	        Chat chat = ChatMapper.toEntity(ChatDto, participants, null);
	        
	        chat.setCreationDate(LocalDateTime.now());
	        chat.setLastActivity(null);
	        chat.setStatus		(ChatStatus.ACTIVE);
	        chat.setState 		(ChatState.ENABLED);
	        chat.setTitle 		(ChatDto.getTitle());
	        chat.setType		(ChatDto.getType());       
	        return ChatMapper.toDTO(this.chatRepository.save(chat)); 
	    }
}
