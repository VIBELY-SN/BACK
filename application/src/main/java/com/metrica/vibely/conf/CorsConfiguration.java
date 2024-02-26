package com.metrica.vibely.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    // <<-CONSTANTS->>
//    private static final String ORIGIN = "http://localhost:4200";
//	  private static final String ORIGINS = "prueba.oagueda.xyz:80" "https://vibely-api.oagueda.xyz", "https://vibely.oagueda.xyz","http://localhost:4200";

    // <<-METHODS->>
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins("*")
                .allowedMethods("*")
                .allowedHeaders("*")
                .exposedHeaders("*")
                .maxAge(3600);
    }

}
