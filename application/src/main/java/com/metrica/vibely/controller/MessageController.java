package com.metrica.vibely.controller;

import com.metrica.vibely.controller.util.ResponseManager;
import com.metrica.vibely.data.model.dto.MessageDTO;
import com.metrica.vibely.data.model.enumerator.MessageState;
import com.metrica.vibely.model.request.CreateMessageRequest;
import com.metrica.vibely.model.response.create.CreateMessageResponse;
import com.metrica.vibely.model.response.get.GetMessageResponse;
import com.metrica.vibely.model.response.update.UpdateMessageResponse;
import com.metrica.vibely.service.MessageService;

import java.util.NoSuchElementException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {

    // <<-FIELDS->>
    private ResponseManager responseManager;
    private MessageService messageService;

    // <<-CONSTRUCTOR->>
    @Autowired
    public MessageController(MessageService messageService, ResponseManager responseManager) {
        this.responseManager = responseManager;
        this.messageService = messageService;
    }
}
