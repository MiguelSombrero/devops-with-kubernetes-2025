package com.github.miguelsombrero.devopswithkubernetes.log_output.log;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class PongService {

    private final RestClient client;

    public PongService(RestClient client) {
        this.client = client;
    }

    public String getPong() {
        return client
                .get()
                .uri("/pings")
                .retrieve()
                .body(String.class);
    }
}
