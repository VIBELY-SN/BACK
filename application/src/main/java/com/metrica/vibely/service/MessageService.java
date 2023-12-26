package com.metrica.vibely.service;

import com.metrica.vibely.data.model.dto.MessageDTO;

import java.util.UUID;

public interface MessageService extends CrudService<MessageDTO, UUID> {

    /**
     * gets message information by its content
     * @param content
     * @return MessageDTO
     * @throws NoSuchElementException
     */
    MessageDTO getByContent(String content);

    /**
     * gets Message sender
     * @param messageId
     * @return sender
     * @throws NoSuchElementException
     */
    UUID getSender(UUID messageId);

    /**
     * gets Message chat
     * @param messageId
     * @return chat
     * @throws NoSuchElementException
     */
    UUID getChat(UUID messageId);

}

