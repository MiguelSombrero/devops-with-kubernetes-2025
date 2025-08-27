package com.github.miguelsombrero.devopswithkubernetes.todo_app.todo;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
class TodoController {

    private final ImageService imageService;

    TodoController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping
    public String getTodos(Model model) {
        model.addAttribute("message", "The Project - Todo App");
        model.addAttribute("imageEndpoint", "/random-image");

        return "index";
    }

    @GetMapping("/random-image")
    public ResponseEntity<byte[]> randomImage() {
        byte[] image = imageService.fetchImage();

        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(image);
    }
}
