package com.github.miguelsombrero.devopswithkubernetes.log_output.util;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Slf4j
@Getter
@Component
public class RandomStringLogger {

    private String randomString;

    public RandomStringLogger() {
        randomString = Instant.now().toString() + ": " + UUID.randomUUID();
        log.info("Generated random string: {}", randomString);
    }

}
