package com.github.miguelsombrero.devopswithkubernetes.todo_backend.todo;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/todos")
class TodoController {

    private final TodoService service;

    TodoController(TodoService todoService) {
        this.service = todoService;
    }

    @GetMapping
    public List<Todo> getTodos() {
        return service.getTodos();
    }

    @PostMapping
    public Todo saveTodo(@Valid @RequestBody Todo todo) {
        log.info("Saving todo: {}", todo);
        return service.saveTodo(todo);
    }
}
