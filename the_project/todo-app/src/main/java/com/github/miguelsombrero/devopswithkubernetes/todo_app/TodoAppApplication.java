package com.github.miguelsombrero.devopswithkubernetes.todo_app;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Slf4j
@SpringBootApplication
public class TodoAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoAppApplication.class, args);
	}

    @Component
    static class ServerPortLogger implements ApplicationListener<ApplicationReadyEvent> {

        private final String serverPort;

        ServerPortLogger(@Value("${server.port}") String serverPort) {
            this.serverPort = serverPort;
        }

        @Override
        public void onApplicationEvent(ApplicationReadyEvent event) {
            log.info("Server is running on port: {}", serverPort);
        }
    }

}
