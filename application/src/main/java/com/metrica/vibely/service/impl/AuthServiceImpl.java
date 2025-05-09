package com.metrica.vibely.service.impl;

import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.exception.InvalidCredentialsException;
import com.metrica.vibely.data.repository.AdminRepository;
import com.metrica.vibely.data.repository.UserRepository;
import com.metrica.vibely.data.util.ApiKeyManager;
import com.metrica.vibely.data.util.PasswordHasher;
import com.metrica.vibely.service.AuthService;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

	// <<-FIELD->>
	private UserRepository userRepository;
	private AdminRepository adminRepository;

	// <<-CONSTRUCTOR->>
	@Autowired 
	public AuthServiceImpl(UserRepository userRepository, AdminRepository adminRepository) {
		this.userRepository = userRepository;
		this.adminRepository = adminRepository;
		
	}

	// <<-METHODS->>
	@Override
	public String usernameAuth(final String username, final String password) {
		User user = this.userRepository.findByUsername(username)
		        		.orElseThrow(() -> new InvalidCredentialsException());
		
		if (PasswordHasher.matches(password, user.getPassword())) {
			return updateInfo(user);
		} else throw new InvalidCredentialsException();
	}  
	
	@Override
	public UUID userId(final String username, final String password) {
		User user = this.userRepository.findByUsername(username)
        		.orElseThrow(() -> new InvalidCredentialsException());
		if (PasswordHasher.matches(password, user.getPassword())) {
			return user.getUserId();
		} else throw new InvalidCredentialsException();
	}
	
	@Override
	public String emailAuth(final String email, final String password) {
		User user = this.userRepository.findByEmail(email)
						.orElseThrow(() -> new InvalidCredentialsException()); 
		if(PasswordHasher.matches(password, user.getPassword())) {
			return updateInfo(user);
		} else throw new InvalidCredentialsException();
	}
	@Override
	public String adminUsernameAuth(final String username, final String password) {
		User user = this.adminRepository.findByAdminUsername(username)
		        		.orElseThrow(() -> new InvalidCredentialsException());
		
		if (PasswordHasher.matches(password, user.getPassword())) {
			return updateInfo(user);
		} else throw new InvalidCredentialsException();
	}  
	
	@Override
	public String adminEmailAuth(final String email, final String password) {
		User user = this.adminRepository.findByEmail(email)
						.orElseThrow(() -> new InvalidCredentialsException()); 
		if(PasswordHasher.matches(password, user.getPassword())) {
			return updateInfo(user);
		} else throw new InvalidCredentialsException();  
	}
	

	@Override
	public String getApikey(UUID id) {
		return this.userRepository.findApikeyByUserId(id).orElseThrow();
	}
	
	private String updateInfo(User user) {
		user.setLogins(user.getLogins() + 1);
		String apiKey = ApiKeyManager.generate(user.getUserId());
		user.setApikey(apiKey);
		userRepository.save(user);
		return apiKey;
	}
	
	@Override
	public String getAdminApikey(UUID id) {
		return this.adminRepository.findApikeyByUserId(id).orElseThrow();
	}

}
