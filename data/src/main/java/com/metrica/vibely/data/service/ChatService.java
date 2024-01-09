package com.metrica.vibely.data.service;

import java.util.Set;
import java.util.UUID;

import com.metrica.vibely.data.entity.Message;
import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.model.dto.ChatDTO;


public interface ChatService extends CrudService<ChatDTO, UUID> {	
	
	ChatDTO addMembers(UUID chatId, Set<UUID> membersToAdd);
	
	
	ChatDTO removeMembers(UUID chatId, Set<UUID> membersToRemove);
	
	
	Set<User> getMembers(UUID chatId);
	
	
	Set<Message> getMessages(UUID chatId);
	
}
