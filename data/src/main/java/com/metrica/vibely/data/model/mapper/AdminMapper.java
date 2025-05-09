package com.metrica.vibely.data.model.mapper;

import com.metrica.vibely.data.entity.Admin;
import com.metrica.vibely.data.entity.Chat;
import com.metrica.vibely.data.entity.Post;
import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.model.dto.AdminDTO;

import java.util.stream.Collectors;

public class AdminMapper {

    /**
     * Convert a DTO into an entity
     *
     * @param adminDTO
     * @param followers
     * @param following
     * @param posts
     * @param chats
     * @param likes
     * @param saves
     * @return
     */
    public static Admin toEntity(AdminDTO adminDTO) {
        Admin admin = new Admin();

        // Mapping Basics
        admin.setUserId	 	 (adminDTO.getUserId());
        admin.setUsername	 (adminDTO.getUsername());
        admin.setPassword	 (adminDTO.getPassword());
        admin.setNickname    (adminDTO.getNickname());
        admin.setEmail		 (adminDTO.getEmail());
        admin.setApikey		 (adminDTO.getApikey());
        admin.setState		 (adminDTO.getState());
        admin.setPrivacy	 (adminDTO.getPrivacy());
        admin.setLogins		 (adminDTO.getLogins());
        admin.setStatus		 (adminDTO.getStatus());
        admin.setLastConnDate(adminDTO.getLastConnDate());
        admin.setBlockedDate (adminDTO.getBlockedDate());

        // Mapping Relations
        admin.setFollowers(null);
        admin.setFollowing(null);
        admin.setPosts	  (null);
        admin.setChats    (null);
        admin.setLikes    (null);
        admin.setSaves    (null);

        return admin;
    }

    /**
     * Convert an entity into a DTO
     *
     * @param admin entity
     * @return the admin DTO
     */
    public static AdminDTO toDTO(Admin admin) {
        AdminDTO adminDTO = new AdminDTO();

        // Mapping Basics
        adminDTO.setUserId		(admin.getUserId());
        adminDTO.setUsername	(admin.getUsername());
        adminDTO.setPassword	(admin.getPassword());
        adminDTO.setNickname	(admin.getNickname());
        adminDTO.setEmail		(admin.getEmail());
        adminDTO.setApikey		(admin.getApikey());
        adminDTO.setState		(admin.getState());
        adminDTO.setPrivacy		(admin.getPrivacy());
        adminDTO.setLogins		(admin.getLogins());
        adminDTO.setStatus		(admin.getStatus());
        adminDTO.setLastConnDate(admin.getLastConnDate());
        adminDTO.setBlockedDate (admin.getBlockedDate());

        // Mapping Relations
        adminDTO.setFollowers(admin.getFollowers()
                .stream()
                .map(User::getUserId)
                .collect(Collectors.toSet()));
        adminDTO.setFollowing(admin.getFollowing()
                .stream()
                .map(User::getUserId)
                .collect(Collectors.toSet()));
        adminDTO.setPosts(admin.getPosts()
                .stream()
                .map(Post::getPostId)
                .collect(Collectors.toSet()));
        adminDTO.setChats(admin.getChats()
                .stream()
                .map(Chat::getChatId)
                .collect(Collectors.toSet()));
        adminDTO.setLikes(admin.getLikes()
                .stream()
                .map(Post::getPostId)
                .collect(Collectors.toSet()));
        adminDTO.setSaves(admin.getSaves()
                .stream()
                .map(Post::getPostId)
                .collect(Collectors.toSet()));

        return adminDTO;
    }

}