package com.metrica.vibely.data.model.dto;

import com.metrica.vibely.data.model.enumerator.MessageState;

public class MessageDTO {

    package com.metrica.vibely.data.model.dto;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import com.metrica.vibely.data.model.enumerator.MessageState;
import com.metrica.vibely.data.model.enumerator.MessageStatus;
    public class MessageDTO {


        // <<-FIELDS->>

        // Basic
        private UUID messageId;
        private LocalDateTime creationTimestamp;
        private MessageStatus status;
        private MessageState state;
        private String content;

        // Relations
        private UUID chat;
        private UUID sender;

        // <<-CONSTRUCTORS->>
        public MessageDTO() {
        }

        public MessageDTO(
                UUID messageId,
                LocalDateTime creationTimestamp,
                MessageStatus status,
                MessageState state,
                String content,
                UUID chat,
                UUID sender) {
            this.setMessageId        (messageId);
            this.setCreationTimestamp(creationTimestamp);
            this.setStatus           (status);
            this.setState			 (state);
            this.setContent          (content);
            this.setChat             (chat);
            this.setSender           (sender);
        }

    }
