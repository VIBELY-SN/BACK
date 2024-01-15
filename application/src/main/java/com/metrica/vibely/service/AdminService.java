package com.metrica.vibely.service;

import com.metrica.vibely.data.model.dto.AdminDTO;
import java.util.UUID;

import org.springframework.stereotype.Service;

public interface AdminService extends CrudService<AdminDTO, UUID> {
	
	/**
	 * Gets an Admininistrator by its username.
	 * 
	 * @param username the username to search
	 * @return the admin DTO
	 * @throws NoSuchElementException in case the admin does not exist
	 */
	AdminDTO getByUsername(String username);	
    
    /**
     * Gets an Admininistrator by its email.
     * 
     * @param username the username to search
     * @return the admin DTO
     * @throws NoSuchElementException in case the admin does not exist
     */
    AdminDTO getByEmail(String email);
	
    /**
     * Deletes an admin given its username
     * 
     * @param username the username to delete
     * @throws NoSuchElementException
     */
    void deleteByUsername(String username);
	
	/**
	 * 
	 * @param adminId 
	 * @param follwedUserId
	 * @param username
	 * @return
	 * @throws NoSuchElementException
	 */
	AdminDTO followUser(UUID adminId, UUID followedUserId);
	
	/**
	 * 
	 * @param adminId
	 * @param follwedUserId
	 * @return
	 * @throws NoSuchElementException
	 */
	AdminDTO unfollowUser(UUID adminId, UUID followedUserId);
	
}
