package com.github.miguelsombrero.devopswithkubernetes.log_output.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

@Slf4j
@Component
public class FilesystemLogOutputWriter implements LogOutputWriter {

    private final String filePath;

    public FilesystemLogOutputWriter(@Value("${file.path}") String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void write(String content) {
        try {
            Files.writeString(
                    Path.of(filePath),
                    content,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );
        } catch (IOException e) {
            log.error("Exception during writing to file", e);
        }
    }
}
