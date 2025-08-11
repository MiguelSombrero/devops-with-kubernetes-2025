package com.github.miguelsombrero.devopswithkubernetes.todo_app.todo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/")
class TodoController {

    @GetMapping
    Todo getTodos() {
        return new Todo(UUID.randomUUID().toString(), "Sample Todo", "This is a sample todo item");
    }

    record Todo(String id, String title, String description) {
    }
}
