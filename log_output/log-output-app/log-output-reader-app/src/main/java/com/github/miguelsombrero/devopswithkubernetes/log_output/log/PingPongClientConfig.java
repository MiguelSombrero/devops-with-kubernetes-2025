package com.github.miguelsombrero.devopswithkubernetes.log_output.log;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class PingPongClientConfig {

    private final String pongServiceUrl;

    public PingPongClientConfig(@Value("${pong.service.host}") String pongServiceUrl) {
        this.pongServiceUrl = pongServiceUrl;
    }

    @Bean
    public RestClient imageClient() {
        return RestClient.builder().baseUrl(pongServiceUrl).build();
    }
}
