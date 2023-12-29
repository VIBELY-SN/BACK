package com.metrica.vibely.data.model.mapper;

import java.util.Set;
import java.util.stream.Collectors;

import com.metrica.vibely.data.entity.Chat;
import com.metrica.vibely.data.entity.Message;
import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.model.dto.ChatDTO;

public class ChatMapper {
	
	public static Chat toEntity(ChatDTO chatDTO, Set<User> participants, Set<Message> messages) {
        Chat chat = new Chat();

        // Mapping Basics
        chat.setChatId		(chatDTO.getChatId());
        chat.setCreationDate(chatDTO.getCreationDate());
        chat.setType		(chatDTO.getType());
        chat.setStatus		(chatDTO.getStatus());
        chat.setState		(chatDTO.getState());
        chat.setTitle		(chatDTO.getTitle());
        chat.setLastActivity(chatDTO.getLastActivity());

        // Mapping Relations
        chat.setParticipants(participants);
        chat.setMessages	(messages);

        return chat;
    }
}