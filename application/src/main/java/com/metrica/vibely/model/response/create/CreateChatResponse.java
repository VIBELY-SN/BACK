package com.metrica.vibely.model.response.create;

import java.util.Set;
import java.util.UUID;

import com.metrica.vibely.data.model.dto.ChatDTO;
import com.metrica.vibely.data.model.enumerator.ChatType;

public class CreateChatResponse {
//	<<-FIELDS->>
	
	private UUID chatId;
	private String title;
	private ChatType type;
	private Set<UUID> participants;
	
//	<<-CONSTRUCTOR->>
	public CreateChatResponse() {
	}
	
//	<<-METHODS->>
	public CreateChatResponse generateResponse(ChatDTO chatDto) {
		this.setChatId(chatDto.getChatId());
		this.setTitle(chatDto.getTitle());
		this.setParticipants(chatDto.getParticipants());
		this.setType(chatDto.getType());
		return this;
	}

//	<<-GETTERS & SETTERS ->>
	public UUID getChatId() {
		return chatId;
	}

	public void setChatId(UUID chatId) {
		this.chatId = chatId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<UUID> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<UUID> set) {
		this.participants = set;
	}

	public ChatType getType() {
		return type;
	}

	public void setType(ChatType type) {
		this.type = type;
	}
	
}
