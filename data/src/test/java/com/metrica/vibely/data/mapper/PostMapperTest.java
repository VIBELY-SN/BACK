package com.metrica.vibely.data.mapper;

import org.junit.jupiter.api.Test;

import com.metrica.vibely.data.entity.Post;
import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.model.dto.PostDTO;
import com.metrica.vibely.data.model.enumerator.PostStatus;
import com.metrica.vibely.data.model.enumerator.PostVisibility;
import com.metrica.vibely.data.model.mapper.PostMapper;

import org.junit.jupiter.api.Tag;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <h1>Post Mapper Test</h1>
 * 
 * @since 2023-11-23
 * @version 1.0
 * @author Adrian
 */
class PostMapperTest {

    // <<-CONSTANTS->>
	private static final UUID ID = UUID.randomUUID();
    private static final LocalDateTime POST_DATE = LocalDateTime.now();
    private static final PostStatus STATUS = PostStatus.ACTIVE;
    private static final PostVisibility VISIBILITY = PostVisibility.PUBLIC;
	private static final String CONTENT = "This is a test post content";
	private static final Integer LIKES = 0;
	private static final Integer TIMES_SAVED = 0;
    private static final UUID OWNER = UUID.randomUUID();

    // <<-METHODS->>
    private PostDTO createPostDTO() {
        PostDTO postDTO = new PostDTO();
        
        postDTO.setPostId(ID);
        postDTO.setPostDate(POST_DATE);
        postDTO.setStatus(STATUS);
        postDTO.setVisibility(VISIBILITY);
        postDTO.setContent(CONTENT);
        postDTO.setLikes(LIKES);
        postDTO.setTimesSaved(TIMES_SAVED);
        postDTO.setOwner(OWNER);
        
        return postDTO;
    }

    private Post createPost() {
        Post post = new Post();
        
        post.setPostId(ID);
        post.setPostDate(POST_DATE);
        post.setStatus(STATUS);
        post.setVisibility(VISIBILITY);
        post.setContent(CONTENT);
        post.setLikes(LIKES);
        post.setTimesSaved(TIMES_SAVED);

        return post;
    }
    
    private User createOwner() {
        User owner = new User();
        
        owner.setUserId(OWNER);
        
        return owner;
      
    }