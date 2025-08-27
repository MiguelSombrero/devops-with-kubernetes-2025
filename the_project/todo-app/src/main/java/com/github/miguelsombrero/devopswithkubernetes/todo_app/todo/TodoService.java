package com.github.miguelsombrero.devopswithkubernetes.todo_app.todo;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
class TodoService {
    public static final String TODOS_PATH = "/todos";
    
    private final RestClient todoClient;

    TodoService(RestClient todoClient) {
        this.todoClient = todoClient;
    }

    public List<Todo> getTodos() {
        return todoClient
                .get()
                .uri(TODOS_PATH)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public Todo saveTodo(Todo todo) {
        return todoClient
                .post()
                .uri(TODOS_PATH)
                .body(todo)
                .retrieve()
                .body(Todo.class);
    }
}
