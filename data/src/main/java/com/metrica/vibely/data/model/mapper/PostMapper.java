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

    public static PostDTO toDTO(Post post) {
        PostDTO postDTO = new PostDTO();

        // Mapping Basics
        postDTO.setPostId    (post.getPostId());
        postDTO.setPostDate  (post.getPostDate());
        postDTO.setStatus    (post.getStatus());
        postDTO.setVisibility(post.getVisibility());
        postDTO.setContent   (post.getContent());
        postDTO.setLikes     (post.getLikes());
        postDTO.setTimesSaved(post.getTimesSaved());

        // Mapping Relations
        postDTO.setOwner(post.getOwner().getUserId()); // Getting only the id
        postDTO.setComments(post.getComments() // Mapping to get only the id
                .stream()
                .map(Post::getPostId)
                .collect(Collectors.toSet()));
        postDTO.setLikedBy (post.getLikedBy()
                .stream()
                .map(User::getUserId)
                .collect(Collectors.toSet()));
        postDTO.setSavedBy (post.getSavedBy()
                .stream()
                .map(User::getUserId)
                .collect(Collectors.toSet()));

        return postDTO;
    }

}