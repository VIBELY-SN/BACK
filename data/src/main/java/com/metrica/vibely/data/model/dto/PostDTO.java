package com.metrica.vibely.data.model.dto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import com.metrica.vibely.data.entity.Post;
import com.metrica.vibely.data.entity.User;
import com.metrica.vibely.data.model.enumerator.PostStatus;
import com.metrica.vibely.data.model.enumerator.PostVisibility;

public class PostDTO {

    // <<-FIELDS->>

    // Basics
    private UUID postId;
    private LocalDateTime postDate;
    private PostStatus status;
    private PostVisibility visibility;
    private String content;
    private Integer likes;
    private Integer timesSaved;

    // Relations
    private UUID owner;
    private Set<UUID> comments;
    private Set<UUID> likedBy;
    private Set<UUID> savedBy;


    // <<-CONSTRUCTORS->>
    public PostDTO() {
    }

    public PostDTO(
            UUID postId,
            LocalDateTime postDate,
            PostStatus status,
            PostVisibility visibility,
            String content,
            Integer likes,
            Integer timesSaved,
            UUID owner,
            Set<UUID> comments,
            Set<UUID> likedBy,
            Set<UUID> savedBy) {
        this.postId = postId;
        this.postDate = postDate;
        this.status = status;
        this.visibility = visibility;
        this.content = content;
        this.likes = likes;
        this.timesSaved = timesSaved;
        this.owner = owner;
        this.comments = comments;
        this.likedBy = likedBy;
        this.savedBy = savedBy;
    }
}