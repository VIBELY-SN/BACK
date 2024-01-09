package com.metrica.vibely.data.service;

import java.util.UUID;

import com.metrica.vibely.data.model.dto.ChatDTO;
import com.metrica.vibely.data.model.dto.MessageDTO;
import com.metrica.vibely.data.model.dto.UserDTO;


public interface MessageService extends CrudService<MessageDTO, UUID> {

	MessageDTO getByContent(String content);	

	
	UUID getSender(UUID messageId);
	
	
	UUID getChat(UUID messageId);	

} 
