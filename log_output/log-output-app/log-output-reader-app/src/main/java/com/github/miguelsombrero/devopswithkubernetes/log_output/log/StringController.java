package com.github.miguelsombrero.devopswithkubernetes.log_output.log;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StringController {

    private final LogOutputReader reader;
    private final String filePath;

    public StringController(LogOutputReader reader, @Value("${file.path}") String filePath) {
        this.reader = reader;
        this.filePath = filePath;
    }

    @GetMapping
    public String getRandomString() {
        return reader.readFileToString(filePath);
    }
}
