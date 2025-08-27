package com.github.miguelsombrero.devopswithkubernetes.todo_backend.todo;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
class TodoService {

    private final TodoRepository repository;

    TodoService(TodoRepository repository) {
        this.repository = repository;
    }

    public List<Todo> getTodos() {
        return repository.findAll();
    }

    public Todo saveTodo(Todo todo) {
        todo.setId(UUID.randomUUID().toString());
        return repository.save(todo);
    }
}
