package com.metrica.vibely.controller;

import com.metrica.vibely.controller.util.ResponseManager;
import com.metrica.vibely.data.model.dto.PostDTO;
import com.metrica.vibely.data.model.dto.UserDTO;
import com.metrica.vibely.model.request.CreatePostRequest;
import com.metrica.vibely.model.request.UpdateLikedByPostRequest;
import com.metrica.vibely.model.request.UpdatePostRequest;
import com.metrica.vibely.model.request.UpdateSavedByPostRequest;
import com.metrica.vibely.model.response.create.CreatePostResponse;
import com.metrica.vibely.model.response.get.GetPostResponse;
import com.metrica.vibely.model.response.update.UpdateLikedByPostResponse;
import com.metrica.vibely.model.response.update.UpdatePostResponse;
import com.metrica.vibely.model.response.update.UpdateSavedByPostResponse;
import com.metrica.vibely.service.PostService;
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
@RequestMapping("/api/v1/posts")
public class PostController {

    // <<-FIELDS->>
	private ResponseManager responseManager;
    private PostService postService;
    private UserService userService;

    // <<-CONSTRUCTOR->>
    @Autowired
    public PostController(final PostService postService,final UserService userService, final ResponseManager responseManager) {
    	this.responseManager = responseManager;
        this.postService = postService;
        this.userService = userService;
    }

    // <<-METHODS->>
    @GetMapping("/{id}")
    public ResponseEntity<GetPostResponse> getById(@PathVariable UUID id) {
        PostDTO postDTO = this.postService.getById(id);
        UserDTO userDTO= userService.getById(postDTO.getOwner());
        postDTO.setOwnerNickname(userDTO.getNickname());
        return this.responseManager.generateGetResponse(postDTO);
    }
    
    @GetMapping("/all")
    public List<ResponseEntity<GetPostResponse>> getAll(){
    	return this.postService.getAll()
    						.stream()
    						.peek(post -> {
    			                UserDTO userDTO = userService.getById(post.getOwner());
    			                post.setOwnerNickname(userDTO.getNickname());
    			            })
    						.map(m-> this.responseManager.generateGetResponse(m))
    						.collect(Collectors.toList());
    	
    }
	
	@PostMapping("/create")
    public ResponseEntity<CreatePostResponse> create(
            @RequestBody
            @Valid
            CreatePostRequest createPostRequest,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }
        PostDTO createdDTO = this.postService.create(createPostRequest.toPostDTO());
        return this.responseManager.generateCreateResponse(createdDTO);
    }
	
    @PutMapping("/{id}")
    public ResponseEntity<UpdatePostResponse> update(
            @PathVariable
            UUID id,
            @RequestBody
            @Valid
            UpdatePostRequest postRequest,
            BindingResult bindingResult
   ) {
       if (bindingResult.hasErrors()) {
           return ResponseEntity.badRequest().build();
       }
       PostDTO postDTO = postRequest.toDTO();
       postDTO.setPostId(id);
       PostDTO updatedDTO = this.postService.update(postDTO);
       return this.responseManager.generateUpdateResponse(updatedDTO);
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteById(@PathVariable UUID id) {
       this.postService.deleteById(id);
       return ResponseEntity.noContent().build();
   }
   
   @PutMapping("addLikedBy/{postId}")
   public ResponseEntity<UpdateLikedByPostResponse> addLikedBy(
		   @PathVariable 
		   UUID postId,
		   @RequestBody
           @Valid
           UpdateLikedByPostRequest postRequest,
           BindingResult bindingResult
	){
	   if (bindingResult.hasErrors()) {
           return ResponseEntity.badRequest().build();
       }
	   PostDTO postDTO = postRequest.toDTO();
       postDTO.setPostId(postId);
       PostDTO updatedDTO = this.postService.addLikedBy(postDTO);
       return this.responseManager.generateLikedByUpdateResponse(updatedDTO);
   }
   
   // DISLIKE
   @PutMapping("removeLikedBy/{postId}")
   public ResponseEntity<UpdateLikedByPostResponse> removeLikedBy(
		   @PathVariable 
		   UUID postId,
		   @RequestBody
           @Valid
           UpdateLikedByPostRequest postRequest,
           BindingResult bindingResult
	){
	   if (bindingResult.hasErrors()) {
           return ResponseEntity.badRequest().build();
       }
	   PostDTO postDTO = postRequest.toDTO();
       postDTO.setPostId(postId);
       PostDTO updatedDTO = this.postService.removeLikedBy(postDTO);
       return this.responseManager.generateLikedByUpdateResponse(updatedDTO);
   }
   
   // SAVE
   @PutMapping("addSavedBy/{postId}")
   public ResponseEntity<UpdateSavedByPostResponse> addTimesSavedBy(
		   @PathVariable 
		   UUID postId,
		   @RequestBody
           @Valid
           UpdateSavedByPostRequest postRequest,
           BindingResult bindingResult
	){
	   if (bindingResult.hasErrors()) {
           return ResponseEntity.badRequest().build();
       }
	   PostDTO postDTO = postRequest.toDTO();
       postDTO.setPostId(postId);
       PostDTO updatedDTO = this.postService.addSavedBy(postDTO);
       return this.responseManager.generateSavedByUpdateResponse(updatedDTO);
   }
   
   // SAVE
   @PutMapping("removeSavedBy/{postId}")
   public ResponseEntity<UpdateSavedByPostResponse> removeTimesSavedBy(
		   @PathVariable 
		   UUID postId,
		   @RequestBody
           @Valid
           UpdateSavedByPostRequest postRequest,
           BindingResult bindingResult
	){
	   if (bindingResult.hasErrors()) {
           return ResponseEntity.badRequest().build();
       }
	   PostDTO postDTO = postRequest.toDTO();
       postDTO.setPostId(postId);
       PostDTO updatedDTO = this.postService.removeSavedBy(postDTO);
       return this.responseManager.generateSavedByUpdateResponse(updatedDTO);
   }
 
}
