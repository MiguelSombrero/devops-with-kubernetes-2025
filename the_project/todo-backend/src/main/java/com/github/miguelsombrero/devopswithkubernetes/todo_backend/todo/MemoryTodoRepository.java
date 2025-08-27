package com.github.miguelsombrero.devopswithkubernetes.todo_backend.todo;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
class MemoryTodoRepository implements TodoRepository {

    private Map<String, Todo> store = new HashMap<>();

    @Override
    public List<Todo> findAll() {
        return store.values().stream().toList();
    }

    @Override
    public <S extends Todo> S save(S entity) {
        store.put(entity.getId(), entity);
        return entity;
    }

    // Rest of the methods can be left unimplemented for brevity
    
    @Override
    public <S extends Todo> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Todo> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Todo> findAllById(Iterable<String> strings) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Todo entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Todo> entities) {

    }

    @Override
    public void deleteAll() {

    }
}
