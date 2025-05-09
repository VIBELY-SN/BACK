package com.metrica.vibely.controller.util;

import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.metrica.vibely.data.model.dto.AdminDTO;
import com.metrica.vibely.data.model.dto.ChatDTO;
import com.metrica.vibely.data.model.dto.FileDTO;
import com.metrica.vibely.data.model.dto.MessageDTO;
import com.metrica.vibely.data.model.dto.PostDTO;
import com.metrica.vibely.data.model.dto.UserDTO;
import com.metrica.vibely.model.response.create.CreateAdminResponse;
import com.metrica.vibely.model.response.create.CreateChatResponse;
import com.metrica.vibely.model.response.create.CreateFileResponse;
import com.metrica.vibely.model.response.create.CreateMessageResponse;
import com.metrica.vibely.model.response.create.CreatePostResponse;
import com.metrica.vibely.model.response.create.CreateUserResponse;
import com.metrica.vibely.model.response.get.BasicInfoResponse;
import com.metrica.vibely.model.response.get.GetAdminResponse;
import com.metrica.vibely.model.response.get.GetAllFilesByOwnerResponse;
import com.metrica.vibely.model.response.get.GetChatResponse;
import com.metrica.vibely.model.response.get.GetFileResponse;
import com.metrica.vibely.model.response.get.GetFriendNetworkResponse;
import com.metrica.vibely.model.response.get.GetMessageResponse;
import com.metrica.vibely.model.response.get.GetPostResponse;
import com.metrica.vibely.model.response.update.FollowUserResponse;
import com.metrica.vibely.model.response.update.UnfollowUserResponse;
import com.metrica.vibely.model.response.update.UpdateAdminResponse;
import com.metrica.vibely.model.response.update.UpdateChatResponse;
import com.metrica.vibely.model.response.update.UpdateLikedByPostResponse;
import com.metrica.vibely.model.response.update.UpdateMessageResponse;
import com.metrica.vibely.model.response.update.UpdatePostResponse;
import com.metrica.vibely.model.response.update.UpdateSavedByPostResponse;
import com.metrica.vibely.model.response.update.UpdateUserResponse;

@Component
public class ResponseManager {

    // <<-GET RESPONSE->>
    public ResponseEntity<BasicInfoResponse> generateGetResponse(UserDTO userDto) {
        BasicInfoResponse basicResponse = new BasicInfoResponse();
        return ResponseEntity.ok().body(basicResponse.generateResponse(userDto));
    }
    
    public ResponseEntity<GetAdminResponse> generateGetResponse(AdminDTO adminDto) {
        GetAdminResponse adminResponse = new GetAdminResponse();
        return ResponseEntity.ok().body(adminResponse.generateResponse(adminDto));
    }
    
    public ResponseEntity<GetFileResponse> generateGetResponse(FileDTO fileDto){
    	GetFileResponse fileResponse = new GetFileResponse();
    	 return ResponseEntity.ok().body(fileResponse.generateResponse(fileDto));
    }
    
    public ResponseEntity<GetAllFilesByOwnerResponse> generateGetResponse(List<FileDTO> userFiles){
    	GetAllFilesByOwnerResponse allfilesByUserResponse = new GetAllFilesByOwnerResponse();
    	 return ResponseEntity.ok().body(allfilesByUserResponse.generateResponse(userFiles));
    }
    
    public ResponseEntity<GetPostResponse> generateGetResponse(PostDTO postDto) {
    	GetPostResponse postResponse = new GetPostResponse();
        return ResponseEntity.ok().body(postResponse.generateResponse(postDto));
    }
    
    public ResponseEntity<GetChatResponse> generateGetResponse(ChatDTO chatDto) {
    	GetChatResponse chatResponse = new GetChatResponse();
    	return ResponseEntity.ok().body(chatResponse.generateResponse(chatDto));
    }
    
    public ResponseEntity<GetMessageResponse> generateGetResponse(MessageDTO messageDto) {
    	GetMessageResponse messageResponse = new GetMessageResponse();
    	return ResponseEntity.ok().body(messageResponse.generateResponse(messageDto));
    }
    
    public ResponseEntity<GetFriendNetworkResponse> generateGetNetworkResponse(Set<UUID> participantIds){
    	GetFriendNetworkResponse friendNetworkResponse = new GetFriendNetworkResponse();
    	return ResponseEntity.ok().body(friendNetworkResponse.generateResponse(participantIds));
    }

    // <<-CREATE RESPONSE->>
    public ResponseEntity<CreateUserResponse> generateCreateResponse(UserDTO userDto) {
    	CreateUserResponse userResponse = new CreateUserResponse();
    	return ResponseEntity.status(HttpStatus.CREATED).body(userResponse.generateResponse(userDto));
    }
    
    public ResponseEntity<CreateAdminResponse> generateCreateResponse(AdminDTO adminDto) {
    	CreateAdminResponse adminResponse = new CreateAdminResponse();
    	return ResponseEntity.status(HttpStatus.CREATED).body(adminResponse.generateResponse(adminDto));
    }
    
    public ResponseEntity<CreateFileResponse> generateCreateResponse(FileDTO fileDto){
    	CreateFileResponse fileResponse = new CreateFileResponse();
    	return ResponseEntity.status(HttpStatus.CREATED).body(fileResponse.generateResponse(fileDto));
    }
    
    public ResponseEntity<CreatePostResponse> generateCreateResponse(PostDTO postDto) {
    	CreatePostResponse postResponse = new CreatePostResponse();
    	return ResponseEntity.status(HttpStatus.CREATED).body(postResponse.generateResponse(postDto));
    }
    
    public ResponseEntity<CreateChatResponse> generateCreateResponse(ChatDTO chatDto) {
    	CreateChatResponse chatResponse = new CreateChatResponse();
    	return ResponseEntity.status(HttpStatus.CREATED).body(chatResponse.generateResponse(chatDto));
    }
    
    public ResponseEntity<CreateMessageResponse> generateCreateResponse(MessageDTO messageDto) {
    	CreateMessageResponse messageResponse = new CreateMessageResponse();
    	return ResponseEntity.status(HttpStatus.CREATED).body(messageResponse.generateResponse(messageDto));
    }

    // <<-UPDATE RESPONSE->>
    public ResponseEntity<UpdateUserResponse> generateUpdateResponse(UserDTO userDto) {
    	UpdateUserResponse userResponse = new UpdateUserResponse();
    	return ResponseEntity.ok().body(userResponse.generateResponse(userDto));
    }
    
    public ResponseEntity<UpdateAdminResponse> generateUpdateResponse(AdminDTO adminDto) {
    	UpdateAdminResponse adminResponse = new UpdateAdminResponse();
    	return ResponseEntity.ok().body(adminResponse.generateResponse(adminDto));
    }
    
    public ResponseEntity<UpdatePostResponse> generateUpdateResponse(PostDTO postDto) {
    	UpdatePostResponse postResponse = new UpdatePostResponse();
    	return ResponseEntity.ok().body(postResponse.generateResponse(postDto));
    }
    
    public ResponseEntity<UpdateChatResponse> generateUpdateResponse(ChatDTO chatDto) {
    	UpdateChatResponse chatResponse = new UpdateChatResponse();
    	return ResponseEntity.ok().body(chatResponse.generateResponse(chatDto));
    }
    
    public ResponseEntity<UpdateMessageResponse> generateUpdateResponse(MessageDTO messageDto) {
    	UpdateMessageResponse messageResponse = new UpdateMessageResponse();
    	return ResponseEntity.ok().body(messageResponse.generateResponse(messageDto));
    }
    /**
     * Generates a ResponseEntity for updating the 'likedBy' property of a Post.
     * @param postDTO The PostDTO containing the updated 'likedBy' information.
     * @return ResponseEntity with the updated 'likedBy' response.
     */
    public ResponseEntity<UpdateLikedByPostResponse> generateLikedByUpdateResponse(PostDTO postDTO) {
    	UpdateLikedByPostResponse postResponse = new UpdateLikedByPostResponse();
    	return ResponseEntity.ok().body(postResponse.generateResponse(postDTO));
    }
    /**
     * Generates a ResponseEntity for updating the 'savedBy' property of a Post.
     * @param postDTO The PostDTO containing the updated 'savedBy' information.
     * @return ResponseEntity with the updated 'savedBy' response.
     */
    public ResponseEntity<UpdateSavedByPostResponse> generateSavedByUpdateResponse(PostDTO postDTO) {
    	UpdateSavedByPostResponse postResponse = new UpdateSavedByPostResponse();
    	return ResponseEntity.ok().body(postResponse.generateResponse(postDTO));
    }
 
    public ResponseEntity<FollowUserResponse> generateFollowUserResponse(String username, String followedUsername) {
    	FollowUserResponse followResponse = new FollowUserResponse();
    	return ResponseEntity.ok().body(followResponse.generateResponse(username, followedUsername));
    }
    
    public ResponseEntity<UnfollowUserResponse> generateUnfollowUserResponse(String username, String followedUsername) {
    	UnfollowUserResponse unfollowResponse = new UnfollowUserResponse();
    	return ResponseEntity.ok().body(unfollowResponse.generateResponse(username, followedUsername));
    }
}
