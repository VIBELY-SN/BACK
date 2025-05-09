package com.metrica.vibely.data.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

import com.metrica.vibely.data.model.enumerator.PostStatus;
import com.metrica.vibely.data.model.enumerator.PostVisibility;
import com.metrica.vibely.data.util.Copyable;
import com.metrica.vibely.data.util.DeepCopyGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

/**
 * <h1>Post Entity</h1>
 * 
 * @since 2023-11-13
 * @version 1.0
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
    @ManyToOne
    @JoinColumn(name = "owner_id",
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
    
    @OneToMany(mappedBy = "ownerPost")
    private Set<File> files;
    

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
    
    // <<-METHODS->>
    @Override
    public Post deepCopy() {
        Post copy = new Post();

        copy.setPostId    (this.postId);
        copy.setPostDate  (this.postDate);
        copy.setStatus    (this.status);
        copy.setVisibility(this.visibility);
        copy.setContent   (this.content);
        copy.setLikes     (this.likes);
        copy.setTimesSaved(this.timesSaved);
//        copy.setOwner     (this.owner);
//        copy.setComments  (this.comments);
//        copy.setLikedBy   (this.likedBy);
//        copy.setSavedBy   (this.savedBy);

        return copy;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.postId);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass())
            return false;
        Post other = (Post) obj;
        return Objects.equals(this.postId, other.postId);
    }

    // <<-GETTERS & SETTERS->>
    public UUID getPostId() {
        return this.postId;
    }

    public void setPostId(final UUID postId) {
        if (postId == null) {
            this.postId = UUID.randomUUID();
        } else {
            this.postId = postId;
        }
    }

    public LocalDateTime getPostDate() {
        return this.postDate;
    }

    public void setPostDate(final LocalDateTime postDate) {
        if (postDate == null) {
            this.postDate = LocalDateTime.now();
        } else {
            this.postDate = postDate;
        }
    }

    public PostStatus getStatus() {
        return this.status;
    }

    public void setStatus(final PostStatus status) {
        if (status == null) {
            this.status = PostStatus.ACTIVE;
        } else {
            this.status = status;
        }
    }

    public PostVisibility getVisibility() {
        return this.visibility;
    }

    public void setVisibility(final PostVisibility visibility) {
        if (visibility == null) {
            this.visibility = PostVisibility.PUBLIC;
        } else {
            this.visibility = visibility;
        }
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(final String content) {
        if (content == null) {
            this.content = "";
        } else {
            this.content = content;
        }
    }

    public Integer getLikes() {
        return this.likes;
    }

    public void setLikes(final Integer likes) {
        if (likes == null) {
            this.likes = 0;
        } else {
            this.likes = likes;
        }
    }

    public Integer getTimesSaved() {
        return this.timesSaved;
    }

    public void setTimesSaved(final Integer timesSaved) {
        if (timesSaved == null) {
            this.timesSaved = 0;
        } else {
            this.timesSaved = timesSaved;
        }
    }

    public User getOwner() {
        return this.owner.deepCopy();
    }

    public void setOwner(final User owner) {
        if (owner == null) {
            this.owner = new User();
        } else {
            this.owner = owner.deepCopy();
        }
    }

    public Set<Post> getComments() {
        return DeepCopyGenerator.generateCopy(this.comments);
    }

    public void setComments(final Set<Post> comments) {
        this.comments = new TreePost();
        if (comments != null) {
            this.comments.addAll(DeepCopyGenerator.generateCopy(comments));
        }
    }

    public Set<User> getLikedBy() {
        return DeepCopyGenerator.generateCopy(this.likedBy);
    }

    public void setLikedBy(final Set<User> likedBy) {
        this.likedBy = new HashSet<>();
        if (likedBy != null) {
            this.likedBy.addAll(DeepCopyGenerator.generateCopy(likedBy));
        }
    }

    public Set<User> getSavedBy() {
        return DeepCopyGenerator.generateCopy(this.savedBy);
    }

    public void setSavedBy(final Set<User> savedBy) {
        this.savedBy = new HashSet<>();
        if (savedBy != null) {
            this.savedBy.addAll(DeepCopyGenerator.generateCopy(savedBy));
        }
    }

    // <<-CLASS->>
    static class TreePost extends java.util.TreeSet<Post> {

        // <<-CONSTANT->>
        private static final long serialVersionUID = 1L;

        // <<-CONSTRUCTOR->>
        public TreePost() {
            // The argument is a Comparator
            super((p1, p2) -> p1.getPostDate().compareTo(p2.getPostDate()));
        }

    }
}
