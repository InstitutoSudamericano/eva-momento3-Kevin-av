package com.example.evam3.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer


@Configuration
@EnableWebMvc

class Cors : WebMvcConfigurer{
    override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/")
            .allowedOrigins(
                "http://localhost:8082")
            .allowedMethods("POST", "GET", "PUT", "DELETE", "post")
            .allowCredentials(true)
    }
}