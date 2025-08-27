package com.github.miguelsombrero.devopswithkubernetes.todo_app.todo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class WebClientConfig {

    private final String todoServiceUrl;

    public WebClientConfig(@Value("${todo.api.url}") String todoServiceUrl) {
        this.todoServiceUrl = todoServiceUrl;
    }

    @Bean
    public RestClient imageClient() {
        return RestClient.builder()
                .baseUrl("https://picsum.photos/200")
                .build();
    }

    @Bean
    public RestClient todoClient() {
        return RestClient.builder()
                .baseUrl(todoServiceUrl)
                .build();
    }
}
