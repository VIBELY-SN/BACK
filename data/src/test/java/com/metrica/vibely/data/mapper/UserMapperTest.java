package com.metrica.vibely.data.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.metrica.vibely.data.entity.Chat;
import com.metrica.vibely.data.entity.Post;
import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.model.dto.UserDTO;
import com.metrica.vibely.data.model.enumerator.PrivacyType;
import com.metrica.vibely.data.model.enumerator.UserState;
import com.metrica.vibely.data.model.enumerator.UserStatus;
import com.metrica.vibely.data.model.mapper.UserMapper;

/**
 * <h1>User Mapper Test</h1>
 * 
 * @since 2023-11-23
 * @version 1.0
 * @author Adrian
 */
class UserMapperTest {
	
	// <<-CONSTANTS->>
    private static final String USERNAME = "jdoe";
    private static final String PASSWORD = "12345";
    private static final String NICKNAME = "John Doe";
    private static final String EMAIL    = "johndoe@email.com";
    private static final String APIKEY   = "randomApikey";
    private static final UserState   STATE   = UserState.ENABLED;
    private static final PrivacyType PRIVACY = PrivacyType.PUBLIC;
    private static final UserStatus  STATUS  = UserStatus.ONLINE;
    private static final Integer LOGINS = 0;
    private static final LocalDateTime LAST_CONN_DATE = LocalDateTime.now();
    private static final LocalDate     BLOCKED_DATE   = LocalDate.now();
    
    
    // <<-METHODS->>
    private UserDTO createUserDTO() {
        UserDTO userDTO = new UserDTO();
        
        userDTO.setUserId(UUID.randomUUID());
        userDTO.setUsername(USERNAME);
        userDTO.setPassword(PASSWORD);
        userDTO.setNickname(NICKNAME);
        userDTO.setEmail(EMAIL);
        userDTO.setApikey(APIKEY);
        userDTO.setState(STATE);
        userDTO.setPrivacy(PRIVACY);
        userDTO.setStatus(STATUS);
        userDTO.setLogins(LOGINS);
        userDTO.setLastConnDate(LAST_CONN_DATE);
        userDTO.setBlockedDate(BLOCKED_DATE);
        
        return userDTO;
    }
    
    public User createUser() {
        User user = new User();
        
        user.setUsername("jdoe");
        user.setPassword("password123");
        user.setNickname("John Doe");
        user.setEmail("johndoe@email.com");
        
        return user;
    }
    
    
