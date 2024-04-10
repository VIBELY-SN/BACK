package com.metrica.vibely.model.response.get;

import java.util.UUID;

import com.metrica.vibely.data.model.dto.FileDTO;

public class GetFileResponse {
	
// <<-FIELDS->>
    
	private UUID 		fileId;
	private String 		fileName;
    private String 		contentType;
    private String 		absolutePath;
    private Long 		size;
    private UUID 		uploader;
    
 // <<-CONSTRUCTOR->>
    public GetFileResponse() {  	
    }
    
//	<<--METHODS-->>
    public GetFileResponse generateResponse(FileDTO fileDto) {
    	this.setFileId		(fileDto.getFileId());
    	this.setFileName	(fileDto.getFileName());
    	this.setContentType	(fileDto.getContentType());
    	this.setAbsolutePath(fileDto.getAbsolutePath());
    	this.setSize		(fileDto.getSize());
    	this.setUploader	(fileDto.getOwnerPostId());
    	
    	return this;
    }

//	<<--GETTERS & SETTERS-->>
    
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

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public String getAbsolutePath() {
		return absolutePath;
	}

	public void setAbsolutePath(String absolutePath) {
		this.absolutePath = absolutePath;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public UUID getUploader() {
		return uploader;
	}

	public void setUploader(UUID uploader) {
		this.uploader = uploader;
	}
    
    

    
    
}
