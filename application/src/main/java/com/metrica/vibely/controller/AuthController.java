package com.metrica.vibely.controller;

import com.metrica.vibely.model.request.AdminAuthEmailRequest;
import com.metrica.vibely.model.request.AdminAuthUserRequest;
import com.metrica.vibely.model.request.AuthEmailRequest;
import com.metrica.vibely.model.request.AuthUserRequest;
import com.metrica.vibely.service.AuthService;

import jakarta.validation.Valid;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    // <<-FIELD->>
    private AuthService authService;

    // <<-CONSTRUCTOR->>
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    // <<-METHOD->>
    @PostMapping("/auth/username")
    public ResponseEntity<?> login(
            @RequestBody
            @Valid
            AuthUserRequest authRequest,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) { return ResponseEntity.badRequest().build(); }

        String apiKey = this.authService.usernameAuth(authRequest.getUsername(), authRequest.getPassword());
        String id = this.authService.userId(authRequest.getUsername(), authRequest.getPassword()).toString();
        Map<String, Object> responseBody = new java.util.HashMap<>();
        responseBody.put("apiKey", apiKey);
        responseBody.put("UserId", id);
        return ResponseEntity.ok()
                .body(responseBody); 
    } 
    
    @PostMapping("/auth/email")
    public ResponseEntity<?> login(
    		@RequestBody
    		@Valid
    		AuthEmailRequest authRequest,
    		BindingResult bindingResult
    ) {
    	if(bindingResult.hasErrors()) { return ResponseEntity.badRequest().build(); }
    	
    	String apiKey = this.authService.emailAuth(authRequest.getEmail(), authRequest.getPassword());
    	return ResponseEntity.ok().body(Map.of("apiKey", apiKey));
    }
    
 // <<-METHOD->>
    @PostMapping("/admin/auth/username")
    public ResponseEntity<?> login(
            @RequestBody
            @Valid
            AdminAuthUserRequest authRequest,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) { return ResponseEntity.badRequest().build(); } 

        String apiKey = this.authService.adminUsernameAuth(authRequest.getUsername(), authRequest.getPassword());
        return ResponseEntity.ok()
                .body(java.util.Map.of("apiKey", apiKey));
    } 
    
    @PostMapping("/admin/auth/email") 
    public ResponseEntity<?> login(
    		@RequestBody
    		@Valid
    		AdminAuthEmailRequest authRequest,
    		BindingResult bindingResult
    		) {
    	if (bindingResult.hasErrors()) { return ResponseEntity.badRequest().build(); } 
    	
    	String apiKey = this.authService.adminEmailAuth(authRequest.getEmail(), authRequest.getPassword());
    	return ResponseEntity.ok()
    			.body(java.util.Map.of("apiKey", apiKey));
    } 

}