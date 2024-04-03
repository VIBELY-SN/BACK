package com.metrica.vibely.model.response.create;

import java.util.Set;
import java.util.UUID;

import com.metrica.vibely.data.model.dto.FileDTO;

public class CreateFileResponse {

	// <<-FIELDS->>
	private UUID 		fileId;
	private String 		fileName;
	private UUID 	uploader;
	
	// <<-CONSTRUCTOR->>
	public CreateFileResponse() {
	}
	// <<--METHODS-->>
	public CreateFileResponse generateResponse(FileDTO fileDto) {
    	this.setFileId		(fileDto.getFileId());
    	this.setFileName	(fileDto.getFileName());
    	this.setUploader	(fileDto.getUploader());
    	
    	return this;
    }
	// <<-GETTERS & SETTERS->>
	public UUID getFileId() {
		return fileId;
	}
	public void setFileId(UUID fileId) {
		this.fileId = fileId;
	}
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
