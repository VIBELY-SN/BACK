package com.metrica.vibely.model.request;

public class UnfollowUserRequest {
	
	private String username;
	private String followedUsername;
	
	public UnfollowUserRequest() {
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
