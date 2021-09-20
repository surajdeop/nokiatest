package com.event.consumer.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {
    @Bean
    public Gson getJsonConverter() {
        return new Gson();
    }
}
