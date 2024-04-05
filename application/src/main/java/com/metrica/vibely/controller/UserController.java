package com.metrica.vibely.controller;

import com.metrica.vibely.controller.util.ResponseManager;
import com.metrica.vibely.data.model.dto.UserDTO;
import com.metrica.vibely.data.model.enumerator.PrivacyType;
import com.metrica.vibely.data.model.enumerator.UserState;
import com.metrica.vibely.model.request.CreateUserRequest;
import com.metrica.vibely.model.request.FollowUserRequest;
import com.metrica.vibely.model.request.UpdateUserRequest;
import com.metrica.vibely.model.response.create.CreateUserResponse;
import com.metrica.vibely.model.response.get.BasicInfoResponse;
import com.metrica.vibely.model.response.get.GetPostResponse;
import com.metrica.vibely.model.response.update.FollowUserResponse;
import com.metrica.vibely.model.response.update.UnfollowUserResponse;
import com.metrica.vibely.model.response.update.UpdateUserResponse;
import com.metrica.vibely.service.UserService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    // <<-FIELDS->>
	private ResponseManager responseManager;
    private UserService userService;

    // <<-CONSTRUCTOR->>
    @Autowired
    public UserController(UserService userService, ResponseManager responseManager) {
    	this.responseManager = responseManager;
        this.userService = userService;
    }

    // <<-METHODS->>
    @GetMapping("/{id}")
    public ResponseEntity<BasicInfoResponse> getById(@PathVariable UUID id) {
        UserDTO userDTO = this.userService.getById(id);
        
        if (userDTO.getState() != UserState.DISABLED) {
        	return this.responseManager.generateGetResponse(userDTO);
        }
        
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<BasicInfoResponse> getByUsername(@PathVariable String username) {
        UserDTO userDTO = this.userService.getByUsername(username);
        
        if (userDTO.getState()   != UserState.DISABLED &&
            userDTO.getPrivacy() == PrivacyType.PUBLIC) {
        	return this.responseManager.generateGetResponse(userDTO);
        }
        
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/email/{email}")
    public ResponseEntity<BasicInfoResponse> getByEmail(@PathVariable String email) {
        UserDTO userDTO = this.userService.getByEmail(email);
        
        if (userDTO.getState()   != UserState.DISABLED &&
            userDTO.getPrivacy() == PrivacyType.PUBLIC) {
        	return this.responseManager.generateGetResponse(userDTO);
        }
        
        return ResponseEntity.notFound().build();
    }
    
    @GetMapping("/all")
    public List<ResponseEntity<BasicInfoResponse>> getAll(){
    	return this.userService.getAll()
    						.stream()
    						.map(m-> this.responseManager.generateGetResponse(m))
    						.collect(Collectors.toList());
    	
    }

    @PostMapping("/signup")
    public ResponseEntity<CreateUserResponse> create(
            @RequestBody
            @Valid
            CreateUserRequest userRequest,
            BindingResult bindingResult
    ) {
        
        if (bindingResult.hasErrors()) {            
            return ResponseEntity.badRequest().build(); 
        }
        
        UserDTO userDTO = this.userService.create(userRequest.toUserDTO());
        return this.responseManager.generateCreateResponse(userDTO);
    }
    
    @PutMapping("/follow/{username}/{followedUsername}")
    public ResponseEntity<FollowUserResponse> followByUsername(
    		@PathVariable
    		String username,
    		@PathVariable
    		String followedUsername,
    		@RequestBody
    		@Valid
    		FollowUserRequest userRequest,
    		BindingResult bindingResult
    		) {
    	userService.followUser(username, followedUsername);
    	return this.responseManager.generateFollowUserResponse(username, followedUsername);
    }
    
    @PutMapping("/unfollow/{username}/{followedUsername}")
    public ResponseEntity<UnfollowUserResponse> unfollowByUsername(
    		@PathVariable
    		String username,
    		@PathVariable
    		String followedUsername,
    		@RequestBody
    		@Valid
    		FollowUserRequest userRequest,
    		BindingResult bindingResult
    		) {
    	userService.unfollowUser(username, followedUsername);
    	return this.responseManager.generateUnfollowUserResponse(username, followedUsername);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateUserResponse> updateById(
            @PathVariable
            UUID id,
            @RequestBody
            @Valid
            UpdateUserRequest userRequest,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        UserDTO userDTO = userRequest.toDTO();
        userDTO.setUserId(id);
        UserDTO updatedDTO = this.userService.update(userDTO);
        return this.responseManager.generateUpdateResponse(updatedDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
        this.userService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
