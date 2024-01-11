package com.metrica.vibely.conf;

import com.metrica.vibely.interceptor.AdminAuthInterceptor;
import com.metrica.vibely.interceptor.AuthInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <h1>App Configuration</h1>
 *
 * @since 2023-11-29
 * @version 1.0
 * @author Alex, Gonzalo
 */
@Configuration
public class AppConfiguration implements WebMvcConfigurer {

    // <<-FIELDS->>
    private AuthInterceptor authInterceptor;
    private AdminAuthInterceptor adminAuthInterceptor;

    // <<-CONSTRUCTOR->>
    @Autowired
    public AppConfiguration(
            AuthInterceptor authInterceptor,
            AdminAuthInterceptor adminAuthInterceptor
    ) {
        this.authInterceptor = authInterceptor;
        this.adminAuthInterceptor = adminAuthInterceptor;
    }
}