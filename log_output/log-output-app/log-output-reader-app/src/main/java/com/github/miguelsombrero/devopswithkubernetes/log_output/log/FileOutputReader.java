package com.github.miguelsombrero.devopswithkubernetes.log_output.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;

@Slf4j
@Service
public class FileOutputReader implements LogOutputReader {
    private final ResourceLoader resourceLoader;

    public FileOutputReader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Override
    public String readFileToString(String filePath) {
        Resource resource = resourceLoader.getResource(filePath);
        try {
            return new String(Files.readAllBytes(resource.getFile().toPath()));
        } catch (IOException e) {
            log.error("Exception during writing to file", e);
            throw new RuntimeException("");
        }
    }
}
