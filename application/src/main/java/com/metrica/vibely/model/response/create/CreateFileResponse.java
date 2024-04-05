package com.metrica.vibely.model.response.create;

import java.util.UUID;

import com.metrica.vibely.data.model.dto.FileDTO;

public class CreateFileResponse {

	// <<-FIELDS->>
	private String 		fileName;
	private UUID 	uploader;
	
	// <<-CONSTRUCTOR->>
	public CreateFileResponse() {
	}
	// <<--METHODS-->>
	public CreateFileResponse generateResponse(FileDTO fileDto) {
    	this.setFileName	(fileDto.getFileName());
    	this.setUploader	(fileDto.getUploader());
    	
    	return this;
    }
	// <<-GETTERS & SETTERS->>

	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public UUID getUploader() {
		return uploader;
	}
	public void setUploader(UUID uploader) {
		this.uploader = uploader;
	}
	
}
