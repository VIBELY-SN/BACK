package com.metrica.vibely.data.entity;

import com.metrica.vibely.data.model.enumerator.MessageState;
import com.metrica.vibely.data.model.enumerator.MessageStatus;
import com.metrica.vibely.data.util.Copyable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * <h1>Message Entity</h1>
 *
 * @since 2023-11-13
 * @version 1.0
 * @author Adrian, Alex, Gonzalo
 */
@Entity
public class Message implements Copyable<Message> {

    // <<-FIELDS->>

    // Basic
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "message_id")
    private UUID messageId;
    @Column(name = "creation_timestamp")
    private LocalDateTime creationTimestamp;
    private MessageStatus status;
    private MessageState state;
    private String content;

    // Relations
    @OneToOne(optional = false)
    @JoinColumn(name = "chat_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_message_chat"))
    private Chat chat;
    @OneToOne(optional = false)
    @JoinColumn(name = "sender_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_message_user"))
    private User sender;

    // <<-CONSTRUCTORS->>
    public Message() {
        this.setMessageId(null);
        this.setChat(null);
        this.setSender(null);
    }
}