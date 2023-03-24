package com.example.gp.Configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * this class is used for providing configuration for the spring framework application
 * */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
    *  is used to configure CORS to allow any origin to make GET, POST, PUT, and DELETE requests to the application,
     *  and to allow the Content-Type and Authorization headers in requests.
    * */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE")
                .allowedHeaders("Content-Type", "Authorization");
    }

}
