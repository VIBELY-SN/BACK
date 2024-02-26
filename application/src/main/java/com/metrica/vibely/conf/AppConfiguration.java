package com.metrica.vibely.conf;

import com.metrica.vibely.interceptor.AdminAuthInterceptor;
import com.metrica.vibely.interceptor.AuthInterceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfiguration implements WebMvcConfigurer {

    // <<-FIELDS->>
    private AuthInterceptor authInterceptor;
    private AdminAuthInterceptor adminAuthInterceptor;

    // <<-CONSTRUCTOR->>
    @Autowired
    public AppConfiguration(
            AuthInterceptor      authInterceptor,
            AdminAuthInterceptor adminAuthInterceptor
    ) {
        this.authInterceptor      = authInterceptor;
        this.adminAuthInterceptor = adminAuthInterceptor;
    }

    // <<-METHOD->>
    
    @Override 
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(this.authInterceptor)
            .addPathPatterns("/api/v1/**")
            .excludePathPatterns("/api/v1/auth/**")
            .excludePathPatterns("/api/v1/users/signup")
            .excludePathPatterns("/api/v1/admin/**");

        registry.addInterceptor(this.adminAuthInterceptor)
        	.addPathPatterns("/api/v1/admin/**")
        	.excludePathPatterns("/api/v1/admin/auth/**")
            .excludePathPatterns("/api/v1/admin/users/signup");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("https://vibely-api.oagueda.xyz", "https://vibely.oagueda.xyz","http://localhost:4200")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("x-api-key")
                .allowCredentials(true)
                .maxAge(3600);
    }

}
