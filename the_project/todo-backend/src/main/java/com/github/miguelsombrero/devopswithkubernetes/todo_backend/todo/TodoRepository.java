package com.github.miguelsombrero.devopswithkubernetes.todo_backend.todo;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
interface TodoRepository extends ListCrudRepository<Todo, String> {
}