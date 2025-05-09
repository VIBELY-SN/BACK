package com.metrica.vibely.model.response.get;

import java.util.Set;
import java.util.UUID;

public class GetFriendNetworkResponse {
	
//	<<--ATRIBUTES-->>
	private Set<UUID> followers;
	
// <<--CONSTRUCTOR-->>
	public GetFriendNetworkResponse() {
	}
	
// <<--METHODS-->>
	public GetFriendNetworkResponse generateResponse(Set<UUID> participantIds) {
		this.setFollowers(participantIds);
		return this;
	}
// <<--GETTERS & SETTERS-->>

	public Set<UUID> getFollowers() {
		return followers;
	}

	public void setFollowers(Set<UUID> followers) {
		this.followers = followers;
	}
	
}
