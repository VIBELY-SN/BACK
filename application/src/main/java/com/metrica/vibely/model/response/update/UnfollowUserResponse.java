package com.metrica.vibely.model.response.update;

public class UnfollowUserResponse {

		// <<-FIELDS->>
		private String username;
		private String followedUsername;
	    
	    // <<-CONSTRUCTOR->>
	    public UnfollowUserResponse() {
	    }
	    
	    // <<-METHODS->>
	    public UnfollowUserResponse generateResponse(String username, String followedUsername) {
	    	UnfollowUserResponse unfollowUserResponse = new UnfollowUserResponse();

	    	unfollowUserResponse.setUsername(username);
	    	unfollowUserResponse.setFollowedUsername(followedUsername);
	       

	        return unfollowUserResponse;
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