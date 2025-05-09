package com.metrica.vibely.service;

import com.metrica.vibely.data.model.dto.UserDTO;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserService extends CrudService<UserDTO, UUID>{
    
    /**
     * gets user information by its username
     * @param username 
     * @return UserDTO
     * @throws NoSuchElementException
     */
    UserDTO getByUsername(String username);
    
    /**
     * gets user information by its email
     * @param email 
     * @return UserDTO
     * @throws NoSuchElementException
     */
    UserDTO getByEmail(String email);
    
    /**
     * deletes an user given its username
     * @throws NoSuchElementException
     */
    void deleteByUsername(String username);
	
	UserDTO followUser(String username, String followedUsername);
	
	/**
	 * 
	 * @param userId
	 * @param follwedUserId
	 * @return
	 * @throws NoSuchElementException
	 */
	UserDTO unfollowUser(String username, String followedUsername);

	/**
	 * 
	 * @param userId
	 * @return Set<UUID>
	 * @throws NoSuchElementException
	 */
	Set<UUID> getFriendNetwork(UUID id);

	List<UserDTO> getAll();
	
}
