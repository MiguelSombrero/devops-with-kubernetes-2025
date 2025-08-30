package com.github.miguelsombrero.devopswithkubernetes.ping_pong_app.pong;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

@Service
class PongService {

    private final JdbcClient jdbcClient;

    PongService(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    int incrementAndGetPongs() {
        return jdbcClient.sql("SELECT nextval('counter_seq')").query(Integer.class).single();
    }

    int getPongs() {
        return jdbcClient.sql("SELECT last_value FROM counter_seq").query(Integer.class).single();
    }
}
