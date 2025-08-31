package com.github.miguelsombrero.devopswithkubernetes.todo_backend.todo;

import org.springframework.data.repository.ListCrudRepository;

interface TodoRepository extends ListCrudRepository<Todo, String> {
}