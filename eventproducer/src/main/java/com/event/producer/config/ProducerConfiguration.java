package com.event.producer.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProducerConfiguration {
    @Bean
    public Gson getJsonConverter() {
        return new Gson();
    }
}
