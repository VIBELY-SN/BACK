package com.metrica.vibely.model.request;

import java.util.Set;
import java.util.UUID;

import com.metrica.vibely.data.model.dto.ChatDTO;
import com.metrica.vibely.data.model.enumerator.ChatType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

/**
 * @since 2023-11-20
 * @version 1.0
 */
public class CreateChatRequest {
//	<<--FIELDS-->>
	@NotNull
	@NotBlank
	private String title;
	private ChatType type;
	private Set<UUID> participants;
	
//	<<--CONSTRUCTOR-->>
	public CreateChatRequest() {
	}

//	<<--METHODS-->>
	public ChatDTO toChatDTO() {
		ChatDTO chatDto = new ChatDTO();
		
		chatDto.setTitle	   (this.getTitle());
		chatDto.setType		   (this.getType());
		chatDto.setParticipants(this.getParticipants());
		return chatDto;
	}
//	<<--GETTERS & SETTERS-->>

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<UUID> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<UUID> participants) {
		this.participants = participants;
	}

	public ChatType getType() {
		return type;
	}

	public void setType(ChatType type) {
		this.type = type;
	}

	
}
