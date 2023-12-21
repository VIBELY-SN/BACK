package com.metrica.vibely.data.model.mapper;

import com.metrica.vibely.data.entity.Post;
import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.model.dto.PostDTO;

import java.util.Set;
import java.util.stream.Collectors;

public class PostMapper {

    public static Post toEntity(PostDTO postDTO, User owner, Set<Post> comments, Set<User> likedBy, Set<User> savedBy) {
        Post post = new Post();

        // Mapping Basics
        post.setPostId(postDTO.getPostId());
        post.setPostDate(postDTO.getPostDate());
        post.setStatus(postDTO.getStatus());
        post.setVisibility(postDTO.getVisibility());
        post.setContent(postDTO.getContent());
        post.setLikes(postDTO.getLikes());
        post.setTimesSaved(postDTO.getTimesSaved());

        // Mapping Relations
        post.setOwner(owner);
        post.setComments(comments);
        post.setLikedBy(likedBy);
        post.setSavedBy(savedBy);

        return post;
    }
}