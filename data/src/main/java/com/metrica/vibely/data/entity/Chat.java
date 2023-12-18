package com.metrica.vibely.data.entity;

import com.metrica.vibely.data.model.enumerator.ChatType;
import jakarta.persistence.*;

    @Entity
    public class Chat implements Copyable<com.metrica.vibely.data.entity.Chat> {

        // <<-FIELDS->>

        // Basic
        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        @Column(name = "chat_id")
        private UUID chatId;
        @Column(name = "creation_date")
        private LocalDateTime creationDate;
        @Enumerated(value = EnumType.ORDINAL)
        private ChatType type;
        @Enumerated(value = EnumType.ORDINAL)
        private ChatStatus status;
        @Enumerated(value = EnumType.ORDINAL)
        private ChatState state;
        private String title;
        @Column(name = "last_activity")
        private LocalDateTime lastActivity;

        // Relations
        @ManyToMany
        @JoinTable(name = "user_chat",
                joinColumns = @JoinColumn(name = "chat_id"),
                inverseJoinColumns = @JoinColumn(name = "user_id"),
                foreignKey = @ForeignKey(name = "fk_user-chat_chat"),
                inverseForeignKey = @ForeignKey(name = "fk_user-chat_user"))
        private Set<User> participants;
        @OneToMany(mappedBy = "chat")
        private Set<Message> messages;

        // <<-CONSTRUCTORS->>
        public Chat() {
            this.setChatId(null);
            this.setParticipants(null);
            this.setMessages(null);
        }

        public Chat(
                UUID chatId,
                LocalDateTime lastActivity,
                ChatType type,
                ChatStatus status,
                ChatState state,
                String title,
                LocalDateTime creationDate,
                Set<User> participants,
                Set<Message> messages) {
            this.setChatId      (chatId);
            this.setLastActivity(lastActivity);
            this.setType        (type);
            this.setStatus      (status);
            this.setState		(state);
            this.setTitle       (title);
            this.setCreationDate(creationDate);
            this.setParticipants(participants);
            this.setMessages    (messages);
        }

}