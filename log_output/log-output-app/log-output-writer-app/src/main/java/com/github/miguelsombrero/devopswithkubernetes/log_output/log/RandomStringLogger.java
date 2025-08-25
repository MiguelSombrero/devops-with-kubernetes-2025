package com.github.miguelsombrero.devopswithkubernetes.log_output.log;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Slf4j
@Getter
@Component
public class RandomStringLogger {

    private final String randomString = Instant.now().toString() + ": " + UUID.randomUUID();

    private final LogOutputWriter writer;

    public RandomStringLogger(LogOutputWriter writer) {
        this.writer = writer;
    }

    @Scheduled(fixedRate = 5000)
    void logRandomString() {
        writer.write(randomString);
    }

}
