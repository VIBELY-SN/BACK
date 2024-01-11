package com.metrica.vibely.data.service;

import java.util.UUID;

import com.metrica.vibely.data.model.dto.PostDTO;
import com.metrica.vibely.data.model.enumerator.PostStatus;
import com.metrica.vibely.data.model.enumerator.PostVisibility;


public interface PostService extends CrudService<PostDTO, UUID> {
	
	PostDTO getByContentandCreator(String content, String username);
	
	
	PostDTO changeStatus(PostStatus status); 
	
	
	PostDTO changeVisibility(PostVisibility visibility); 

	void deleteById(UUID postId);
}
