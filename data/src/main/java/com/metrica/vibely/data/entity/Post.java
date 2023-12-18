package com.metrica.vibely.data.entity;

import com.metrica.vibely.data.model.enumerator.PostStatus;
import com.metrica.vibely.data.model.enumerator.PostVisibility;
import com.metrica.vibely.data.util.Copyable;
import com.metrica.vibely.data.util.DeepCopyGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.ForeignKey;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

/**
 * <h1>Post Entity</h1>
 *
 * @since 2023-11-13
 * @version 1.0
 * @author Adrian, Alex
 */
@Entity
public class Post implements Copyable<Post> {

    // <<-FIELDS->>

    // Basics
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "post_id")
    private UUID postId;
    @Column(name = "post_date")
    private LocalDateTime postDate;
    @Enumerated(value = EnumType.ORDINAL)
    private PostStatus status;
    @Enumerated(value = EnumType.ORDINAL)
    private PostVisibility visibility;
    private String content;
    private Integer likes;
    @Column(name = "times_saved")
    private Integer timesSaved;

    // Relations
    @OneToOne(optional = false)
    @JoinColumn(name = "owner_id",
            unique = true,
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_post_user"))
    private User owner;
    @OneToMany
    @JoinColumn(name = "parent_id",
            updatable = false,
            foreignKey = @ForeignKey(name = "fk_post_comment"))
    private Set<Post> comments;
    @ManyToMany
    @JoinTable(name = "post_user_likes",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            foreignKey = @ForeignKey(name = "fk_post-user_likes_post"),
            inverseForeignKey = @ForeignKey(name = "fk_post-user_likes_user"))
    private Set<User> likedBy;
    @ManyToMany
    @JoinTable(name = "post_user_saves",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"),
            foreignKey = @ForeignKey(name = "fk_post-user_saves_post"),
            inverseForeignKey = @ForeignKey(name = "fk_post-user_saves_user"))
    private Set<User> savedBy;

    // <<-CONSTRUCTORS->>
    public Post() {
        this.setPostId  (null);
        this.setOwner   (null);
        this.setComments(null);
        this.setLikedBy (null);
        this.setSavedBy (null);
    }

    public Post(
            UUID postId,
            LocalDateTime postDate,
            PostStatus status,
            PostVisibility visibility,
            String content,
            Integer likes,
            Integer timesSaved,
            User owner,
            Set<Post> comments,
            Set<User> likedBy,
            Set<User> savedBy) {
        this.setPostId    (postId);
        this.setPostDate  (postDate);
        this.setStatus    (status);
        this.setVisibility(visibility);
        this.setContent   (content);
        this.setLikes     (likes);
        this.setTimesSaved(timesSaved);
        this.setOwner     (owner);
        this.setComments  (comments);
        this.setLikedBy   (likedBy);
        this.setSavedBy   (savedBy);
    }
}
