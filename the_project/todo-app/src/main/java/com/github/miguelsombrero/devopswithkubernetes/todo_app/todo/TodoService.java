package com.github.miguelsombrero.devopswithkubernetes.todo_app.todo;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
class TodoService {

    public List<Todo> getTodos() {
        return List.of(
                new Todo(1, "Learn Kubernetes"),
                new Todo(2, "Build a Todo App"),
                new Todo(3, "Deploy to the Cloud")
        );
    }
}
