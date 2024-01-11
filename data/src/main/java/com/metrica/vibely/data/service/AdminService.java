package com.metrica.vibely.data.service;

import com.metrica.vibely.data.model.dto.AdminDTO;

import java.util.UUID;


public interface AdminService extends CrudService<AdminDTO, UUID> {
	
	
	AdminDTO getByUsername(String username);	
    
    
    AdminDTO getByEmail(String email);
	
    
    void deleteByUsername(String username);
	
	
	AdminDTO followUser(UUID adminId, UUID followedUserId);
	
	
	AdminDTO unfollowUser(UUID adminId, UUID followedUserId);
	
}