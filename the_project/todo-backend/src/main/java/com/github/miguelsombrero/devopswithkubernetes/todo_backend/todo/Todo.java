package com.github.miguelsombrero.devopswithkubernetes.todo_backend.todo;

import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
@Builder
@AllArgsConstructor
class Todo {
    @Id
    String id;

    @Size(max = 140)
    String content;
}
