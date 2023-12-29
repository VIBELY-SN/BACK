package com.metrica.vibely.data.model.mapper;

public class MessageMapper {
	public static Message toEntity(MessageDTO messageDTO, Chat chat, User sender) {
        Message message = new Message();

        // Mapping Basics
        message.setMessageId		(messageDTO.getMessageId());
        message.setCreationTimestamp(messageDTO.getCreationTimestamp());
        message.setStatus			(messageDTO.getStatus());
        message.setState			(messageDTO.getState());
        message.setContent			(messageDTO.getContent());

        // Mapping Relations
        message.setChat				(chat);
        message.setSender			(sender);

        return message;
    }
}
