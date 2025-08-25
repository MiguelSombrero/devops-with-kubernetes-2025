package com.github.miguelsombrero.devopswithkubernetes.ping_pong_app.pong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pingpong")
public class PongController {

    private int count = 0;

    @GetMapping
    public String pong() {
        return "pong " + count++;
    }
}
