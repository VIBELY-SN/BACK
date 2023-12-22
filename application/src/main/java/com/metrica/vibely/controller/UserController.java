package com.metrica.vibely.controller;

import com.metrica.vibely.controller.util.ResponseManager;
import com.metrica.vibely.data.model.dto.UserDTO;
import com.metrica.vibely.data.model.enumerator.PrivacyType;
import com.metrica.vibely.data.model.enumerator.UserState;
import com.metrica.vibely.model.request.CreateUserRequest;
import com.metrica.vibely.model.request.UpdateUserRequest;
import com.metrica.vibely.model.response.create.CreateUserResponse;
import com.metrica.vibely.model.response.get.BasicInfoResponse;
import com.metrica.vibely.model.response.update.UpdateUserResponse;
import com.metrica.vibely.service.UserService;

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

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    // <<-FIELDS->>
    private ResponseManager responseManager;
    private UserService userService;

    // <<-CONSTRUCTOR->>
    @Autowired
    public UserController(UserService userService, ResponseManager responseManager) {
        this.responseManager = responseManager;
        this.userService = userService;
    }


}
