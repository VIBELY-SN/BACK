package com.metrica.vibely.model.response.get;

import java.util.List;

import com.metrica.vibely.data.model.dto.FileDTO;

public class GetAllFilesByUserResponse {
//	<<--ATRIBUTEs-->>
	List<FileDTO> userFiles;
	
//	<<--CONSTRUCTOR-->>
	public GetAllFilesByUserResponse() {
	}
//	<<--METHODS-->>
	public GetAllFilesByUserResponse generateResponse(List<FileDTO> userFiles) {
		this.userFiles = userFiles;
		return this;
	}
//	<<--GETTERS & SETTERS-->>
	public List<FileDTO> getUserFiles() {
		return userFiles;
	}
	public void setUserFiles(List<FileDTO> userFiles) {
		this.userFiles = userFiles;
	}
	
}
