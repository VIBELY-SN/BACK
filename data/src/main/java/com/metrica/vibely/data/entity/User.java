package com.metrica.vibely.data.entity;

import com.metrica.vibely.data.model.enumerator.PrivacyType;
import com.metrica.vibely.data.model.enumerator.UserState;
import com.metrica.vibely.data.model.enumerator.UserStatus;
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
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.UUID;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "Users")
public class User implements Copyable<User> {

    // <<-FIELDS->>

    // Basic
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    private String nickname;
    @Column(unique = true)
    private String email;
    private String apikey;
    @Enumerated(value = EnumType.ORDINAL)
    private UserState state;
    @Enumerated(value = EnumType.ORDINAL)
    private PrivacyType privacy;
    private Integer logins;
    @Enumerated(value = EnumType.ORDINAL)
    private UserStatus status;
    @Column(name = "last_connection_date")
    private LocalDateTime lastConnDate;
    @Column(name = "blocked_date")
    private LocalDate blockedDate;

    // Relations
    @ManyToMany
    @JoinTable(name = "user_follower",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "follower_id"),
            foreignKey = @ForeignKey(name = "fk_user-follower_user"),
            inverseForeignKey = @ForeignKey(name = "fk_user-follower_follower"))
    private Set<User> followers;
    @ManyToMany(mappedBy = "followers")
    private Set<User> following;
    @OneToMany(mappedBy = "owner")
    private Set<Post> posts;
    @ManyToMany(mappedBy = "participants")
    private Set<Chat> chats;
    @ManyToMany(mappedBy = "likedBy")
    private Set<Post> likes;
    @ManyToMany(mappedBy = "savedBy")
    private Set<Post> saves;
}