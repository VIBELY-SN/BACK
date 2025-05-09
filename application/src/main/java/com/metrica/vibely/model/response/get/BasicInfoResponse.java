package com.metrica.vibely.model.response.get;

import com.metrica.vibely.data.model.dto.UserDTO;
import com.metrica.vibely.data.model.enumerator.PrivacyType;
import com.metrica.vibely.data.model.enumerator.UserState;

import java.util.Set;
import java.util.UUID;

public class BasicInfoResponse {
    
    // <<-FIELDS->>
    private UUID userId;
    private String username;
    private String nickname;
    private String email;
    private UserState state;
    private PrivacyType privacy;
    private Set<UUID> followers;
    private Set<UUID> following;
    private Set<UUID> posts;
    private Set<UUID> chats;
    
    // <<-CONSTRUCTOR->>
    public BasicInfoResponse() {
    }
    
    // <<-METHOD->>
    public <T extends UserDTO> BasicInfoResponse generateResponse(T dto) {
        this.setUserId   (dto.getUserId());
        this.setUsername (dto.getUsername());
        this.setNickname (dto.getNickname());
        this.setEmail    (dto.getEmail());
        this.setState    (dto.getState());
        this.setPrivacy  (dto.getPrivacy());
        this.setFollowers(dto.getFollowers());
        this.setFollowing(dto.getFollowing());
        this.setPosts    (dto.getPosts());
        this.setChats    (dto.getChats());
        
        return this;
    }
    
    // <<-GETTERS & SETTERS->>
    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    
    public Set<UUID> getChats() {
		return chats;
	}

	public void setChats(Set<UUID> chats) {
		this.chats = chats;
	}

	public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserState getState() {
        return state;
    }

    public void setState(UserState state) {
        this.state = state;
    }

    public PrivacyType getPrivacy() {
        return privacy;
    }

    public void setPrivacy(PrivacyType privacy) {
        this.privacy = privacy;
    }

    public Set<UUID> getFollowers() {
        return followers;
    }

    public void setFollowers(Set<UUID> followers) {
        this.followers = followers;
    }

    public Set<UUID> getFollowing() {
        return following;
    }

    public void setFollowing(Set<UUID> following) {
        this.following = following;
    }

    public Set<UUID> getPosts() {
        return posts;
    }

    public void setPosts(Set<UUID> posts) {
        this.posts = posts;
    }
    
}