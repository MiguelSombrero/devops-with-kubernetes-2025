package com.github.miguelsombrero.devopswithkubernetes.log_output.log;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class LogController {

    private final LogService logService;

    public LogController(LogService logService) {
        this.logService = logService;
    }

    @GetMapping(produces = "text/plain")
    public String getRandomString() {
        return logService.getLogs();
    }
}
