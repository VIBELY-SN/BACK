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
    
    // <<-CONSTRUCTOR->>
    public BasicInfoResponse() {
    }
	
}
