package com.metrica.vibely.data.repository;

import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.metrica.vibely.data.entity.Chat;
import com.metrica.vibely.data.entity.Message;
import com.metrica.vibely.data.entity.User;

@Repository
public interface ChatRepository extends JpaRepository<Chat, java.util.UUID> {

    /**
     * @params participants
     * @return Chat
     * @throws NoSuchElementException
     */
//	Optional<Chat> findByParticipants(Set<User> participants);

    /**
     * @params Chat id
     * @return Set Messages
     * @throws NoSuchElementException
     */
//	Set<Message> getMessages(UUID id);



}