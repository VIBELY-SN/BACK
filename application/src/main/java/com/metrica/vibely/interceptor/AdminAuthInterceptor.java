package com.metrica.vibely.interceptor;

import com.metrica.vibely.data.model.enumerator.HttpStatusEnum;
import com.metrica.vibely.data.repository.AdminRepository;
import com.metrica.vibely.data.util.ApiKeyManager;
import com.metrica.vibely.service.AuthService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * <h1>Authentication Interceptor</h1>
 *
 * @since 2023-11-29
 * @version 1.0
 * @author Alex, Gonzalo
 */
@Component
public class AdminAuthInterceptor implements HandlerInterceptor {

    // <<-FIELD->>
    private AuthService authService;

    // <<-CONSTRUCTOR->>
    @Autowired
    public AdminAuthInterceptor(AdminRepository adminRepository, AuthService authService) {
        this.authService = authService;
    }

}
