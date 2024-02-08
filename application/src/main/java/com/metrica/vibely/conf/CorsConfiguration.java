package com.metrica.vibely.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    // <<-CONSTANTS->>
//    private static final String ORIGIN = "http://localhost:4200";
//	  private static final String ORIGIN = "prueba.oagueda.xyz:80";

    // <<-METHODS->>
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("http://prueba.oagueda.xyz", "https://vibely.oagueda.xyz")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("x-api-key")
                .allowCredentials(true)
                .maxAge(3600);
    }

}
