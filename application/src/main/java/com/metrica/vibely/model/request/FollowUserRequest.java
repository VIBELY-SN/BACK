package com.metrica.vibely.model.request;

public class FollowUserRequest {
	
	private String username;
	private String followedUsername;
	
	public FollowUserRequest() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFollowedUsername() {
		return followedUsername;
	}

	public void setFollowedUsername(String followedUsername) {
		this.followedUsername = followedUsername;
	}
	
	
}
