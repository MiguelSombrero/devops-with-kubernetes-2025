package com.github.miguelsombrero.devopswithkubernetes.todo_backend.todo;

import org.springframework.stereotype.Service;

import java.util.List;

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
        return repository.save(todo);
    }
}
