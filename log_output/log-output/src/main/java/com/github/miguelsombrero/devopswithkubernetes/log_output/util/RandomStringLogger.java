package com.github.miguelsombrero.devopswithkubernetes.log_output.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class RandomStringLogger {

    private final String randomString;

    public RandomStringLogger() {
        randomString = UUID.randomUUID().toString().substring(0, 20);
        log.info("Generated random string: {}", randomString);
    }

    @Scheduled(fixedRate = 5000)
    public void print() {
        log.info(randomString);
    }
}
