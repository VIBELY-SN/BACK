package com.metrica.vibely.service;

import java.util.UUID;

public interface AuthService {
    
    /**
     * @param username
     * @param password
     * @throws
     * @return
     */
    String usernameAuth(String username, String password);

    /**
     * @param email
     * @param password
     * @throws
     * @return
     */
    String emailAuth(String email, String password);
    
    /**
     * @param username
     * @param password
     * @throws
     * @return
     */
    String adminUsernameAuth(String username, String password);

    /**
     * @param email
     * @param password
     * @throws
     * @return
     */
    String adminEmailAuth(String email, String password);
    
    /**
     * 
     * @param id
     * @return
     */
    String getApikey(UUID id);
    
    String getAdminApikey(UUID id);

	UUID userId(String username, String password);

}
