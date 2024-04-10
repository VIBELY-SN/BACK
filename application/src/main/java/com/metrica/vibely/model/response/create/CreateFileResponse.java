package com.metrica.vibely.model.response.create;

import java.util.UUID;

import com.metrica.vibely.data.model.dto.FileDTO;

public class CreateFileResponse {

	// <<-FIELDS->>
	private String 		fileName;
	private UUID 		ownerPostId;
	
	// <<-CONSTRUCTOR->>
	public CreateFileResponse() {
	}
	// <<--METHODS-->>
	public CreateFileResponse generateResponse(FileDTO fileDto) {
    	this.setFileName	(fileDto.getFileName());
    	this.setOwnerPostId	(fileDto.getOwnerPostId());
    	
    	return this;
    }
	// <<-GETTERS & SETTERS->>

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public UUID getOwnerPostId() {
		return ownerPostId;
	}
	public void setOwnerPostId(UUID ownerPostId) {
		this.ownerPostId = ownerPostId;
	}
	
}
