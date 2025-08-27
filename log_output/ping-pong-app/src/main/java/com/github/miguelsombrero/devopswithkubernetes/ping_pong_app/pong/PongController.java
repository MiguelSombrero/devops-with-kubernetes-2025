package com.github.miguelsombrero.devopswithkubernetes.ping_pong_app.pong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class PongController {
    private static final String text = "Ping / Pongs: ";

    private int count = 0;

    @GetMapping("/pingpong")
    public String pong() {
        return text + count++;
    }

    @GetMapping("/pings")
    public String getPings() {
        return text + count;
    }
}
