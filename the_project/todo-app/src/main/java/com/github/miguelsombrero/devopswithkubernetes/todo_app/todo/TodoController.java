package com.github.miguelsombrero.devopswithkubernetes.todo_app.todo;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
class TodoController {

    private final ImageService imageService;
    private final TodoService todoService;

    TodoController(ImageService imageService, TodoService todoService) {
        this.imageService = imageService;
        this.todoService = todoService;
    }

    @GetMapping
    public String getTodos(Model model) {
        model.addAttribute("imageEndpoint", "/random-image");
        model.addAttribute("todos", todoService.getTodos());
        return "index";
    }

    @PostMapping
    public String addTodo(Todo todo) {
        todoService.saveTodo(todo);
        return "redirect:/";
    }

    @GetMapping("/random-image")
    public ResponseEntity<byte[]> randomImage() {
        byte[] image = imageService.fetchImage();

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image);
    }
}
