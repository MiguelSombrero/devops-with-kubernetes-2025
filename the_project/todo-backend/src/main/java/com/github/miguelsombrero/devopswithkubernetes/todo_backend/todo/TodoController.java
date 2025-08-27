package com.github.miguelsombrero.devopswithkubernetes.todo_backend.todo;

import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public Todo saveTodo(@RequestBody Todo todo) {
        return service.saveTodo(todo);
    }
}
