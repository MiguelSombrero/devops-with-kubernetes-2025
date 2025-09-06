package com.github.miguelsombrero.devopswithkubernetes.todo_backend.todo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.test.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.client.RestTestClient;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TodoControllerIT {

    @Container
    static PostgreSQLContainer<?> postgres = new PostgreSQLContainer<>("postgres:16-alpine");

    @DynamicPropertySource
    static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgres::getJdbcUrl);
        registry.add("spring.datasource.username", postgres::getUsername);
        registry.add("spring.datasource.password", postgres::getPassword);
    }

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        this.client = RestTestClient.bindToServer()
                .baseUrl("http://localhost:" + port)
                .build();
    }

    private RestTestClient client;

    @Test
    void testSavingTodoWithValidContent() {
        Todo body = Todo.builder().content("any short string").build();

        client.post().uri("/todos").body(body).exchange().expectStatus().isOk();
    }

    @Test
    void testSavingTodoWithTooLongContent() {
        String stringWith141characters = "LoremipsumdolorsitametconsecteturadipiscingelitSeddoeiusmodtemporincididuntutlaboreetdoloremagnaaliquautenimadminimveniamsasdfsdfasdfasdsdfsf";

        Todo body = Todo.builder().content(stringWith141characters).build();

        client.post().uri("/todos").body(body).exchange().expectStatus().isBadRequest();
    }
}
