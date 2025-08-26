package com.github.miguelsombrero.devopswithkubernetes.ping_pong_app.pong;

import com.github.miguelsombrero.devopswithkubernetes.ping_pong_app.writer.OutputWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pingpong")
public class PongController {

    private final OutputWriter writer;

    private int count = 0;

    public PongController(OutputWriter writer) {
        this.writer = writer;
    }

    @GetMapping
    public String pong() {
        String result = "Ping / Pongs: " + count++;
        writer.write(result);
        return result;
    }
}
