package com.github.miguelsombrero.devopswithkubernetes.todo_backend.todo;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
class Todo {
    @Id
    String id;
    String content;
}
