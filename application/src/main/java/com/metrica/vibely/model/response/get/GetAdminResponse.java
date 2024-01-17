package com.metrica.vibely.model.response.get;

import java.util.UUID;

import com.metrica.vibely.data.model.dto.AdminDTO;

public class GetAdminResponse {
    
    // <<-FIELDS->>
    private UUID adminId;
    private String nickname;
    
    
    // <<-CONSTRUCTOR->>
    public GetAdminResponse() {
    }
    
    // <<-METHOD->>
    public GetAdminResponse generateResponse(AdminDTO adminDto) {
    	
    	this.setAdminId(adminDto.getUserId());
    	this.setNickname(adminDto.getUsername());
    	
    	return this;
    }

	public UUID getAdminId() {
		return adminId;
	}

	public void setAdminId(UUID adminId) {
		this.adminId = adminId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
    
    // <<-GETTERS & SETTERS->>
     
}