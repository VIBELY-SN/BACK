package com.metrica.vibely.model.response.update;

public class FollowUserResponse {

		// <<-FIELDS->>
		private String username;
		private String followedUsername;
	    
	    // <<-CONSTRUCTOR->>
	    public FollowUserResponse() {
	    }
	    
	    // <<-METHODS->>
	    public FollowUserResponse generateResponse(String username, String followedUsername) {
	    	FollowUserResponse followUserResponse = new FollowUserResponse();

	    	followUserResponse.setUsername(username);
	    	followUserResponse.setFollowedUsername(followedUsername);
	       

	        return followUserResponse;
	    }

	    // <<-GETTERS & SETTERS->>
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