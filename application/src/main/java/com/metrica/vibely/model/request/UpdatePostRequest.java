package com.metrica.vibely.model.request;

import com.metrica.vibely.data.model.dto.PostDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UpdatePostRequest {
	
	// <<-FIELDS->>
	@NotNull
	@NotBlank
	private String content;
	
	// <<-CONSTRUCTOR->>
    public UpdatePostRequest() {
    }
    
    // <<-METHODS->>
    public PostDTO toDTO() {
    	PostDTO updateDTO = new PostDTO();
        
    	updateDTO.setContent(this.content);
        
        return updateDTO;
    }

    // <<-GETTERS & SETTERS->>
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
    
	
}
