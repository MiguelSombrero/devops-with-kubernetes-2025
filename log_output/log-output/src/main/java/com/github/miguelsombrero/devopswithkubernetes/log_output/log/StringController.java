package com.github.miguelsombrero.devopswithkubernetes.log_output.log;

import com.github.miguelsombrero.devopswithkubernetes.log_output.util.RandomStringLogger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class StringController {

    private final RandomStringLogger stringLogger;

    public StringController(RandomStringLogger stringLogger) {
        this.stringLogger = stringLogger;
    }

    @GetMapping
    public String getRandomString() {
        return stringLogger.getRandomString();
    }
}
