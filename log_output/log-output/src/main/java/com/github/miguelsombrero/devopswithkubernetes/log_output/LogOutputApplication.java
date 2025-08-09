package com.github.miguelsombrero.devopswithkubernetes.log_output;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LogOutputApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogOutputApplication.class, args);
    }
}
