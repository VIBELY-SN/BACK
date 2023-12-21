package com.metrica.vibely.data.model.mapper;

import com.metrica.vibely.data.entity.Chat;
import com.metrica.vibely.data.entity.Post;
import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.model.dto.UserDTO;

import java.util.stream.Collectors;

public class UserMapper {

	// <<-METHODS->>
	/**
	 * Maps the information contained in the DTO into the Entity.
	 *
	 * This method is mainly used when you create a new entity
	 * so it's really not important the values you assign to the
	 * relations fields.
	 *
	 * @param userDTO the DTO to map
	 * @return the entity with the DTO info
	 */
	public static User toEntity(UserDTO userDTO) {
		User user = new User();

		// Mapping Basics
		user.setUserId		(userDTO.getUserId());
		user.setNickname	(userDTO.getNickname());
		user.setUsername	(userDTO.getUsername());
		user.setPassword	(userDTO.getPassword());
		user.setEmail		(userDTO.getEmail());
		user.setApikey		(userDTO.getApikey());
		user.setPrivacy		(userDTO.getPrivacy());
		user.setStatus		(userDTO.getStatus());
		user.setState		(userDTO.getState());
		user.setLogins		(userDTO.getLogins());
		user.setBlockedDate (userDTO.getBlockedDate());
		user.setLastConnDate(userDTO.getLastConnDate());

		// Mapping Relations
		user.setFollowers(null);
		user.setFollowing(null);
		user.setPosts    (null);
		user.setChats    (null);
		user.setLikes    (null);
		user.setSaves    (null);

		return user;
	}
}
