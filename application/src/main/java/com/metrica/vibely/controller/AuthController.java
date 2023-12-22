package com.metrica.vibely.controller;

import com.metrica.vibely.model.request.AdminAuthEmailRequest;
import com.metrica.vibely.model.request.AdminAuthUserRequest;
import com.metrica.vibely.model.request.AuthEmailRequest;
import com.metrica.vibely.model.request.AuthUserRequest;
import com.metrica.vibely.service.AuthService;

import jakarta.validation.Valid;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class AuthController {

    // <<-FIELD->>
    private AuthService authService;

    // <<-CONSTRUCTOR->>
    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }


}
