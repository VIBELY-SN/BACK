package com.metrica.vibely.controller;

import com.metrica.vibely.controller.util.ResponseManager;
import com.metrica.vibely.data.model.dto.ChatDTO;
import com.metrica.vibely.data.model.enumerator.ChatState;
import com.metrica.vibely.model.request.AddRemoveChatRequest;
import com.metrica.vibely.model.request.CreateChatRequest;
import com.metrica.vibely.model.request.UpdateChatRequest;
import com.metrica.vibely.model.response.create.CreateChatResponse;
import com.metrica.vibely.model.response.get.GetChatResponse;
import com.metrica.vibely.model.response.update.UpdateChatResponse;
import com.metrica.vibely.service.ChatService;

import jakarta.validation.Valid;

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

public class AdminController {
		// ATRIBUTEs
		ResponseManager responseManager;
	    private ChatService chatService;

	    // CONSTRUCTOR
	    @Autowired
	    public ChatController(ChatService chatService, ResponseManager responseManager) {
	    	this.responseManager = responseManager;
	        this.chatService = chatService;
	    }
	    // METHODS
	    @GetMapping("/{id}")
	    public ResponseEntity<GetChatResponse> getById(@PathVariable UUID id) {
	    	ChatDTO chatDto = chatService.getById(id); 
	    	
	    	if (chatDto.getState()   != ChatState.DISABLED) {
	    		return this.responseManager.generateGetResponse(chatDto);
	    	}
	    	return ResponseEntity.notFound().build();
	    }
}
