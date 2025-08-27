package com.github.miguelsombrero.devopswithkubernetes.todo_app.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Slf4j
@Component
public class ImageUtil {
    private static final long TEN_MINUTES = 10 * 60 * 1000;

    private final Path filePath;

    public ImageUtil(@Value("${file.path}") String filePath) {
        this.filePath = Paths.get(filePath);
    }

    public void write(byte[] content) {
        try {
            Files.write(filePath, content);
        } catch (IOException e) {
            log.error("Exception during writing to file", e);
        }
    }

    public byte[] read() {
        try {
            return Files.readAllBytes(filePath);
        } catch (IOException e) {
            log.error("Exception during reading from file", e);
            throw new RuntimeException("");
        }
    }

    public boolean exists() {
        return Files.exists(filePath);
    }

    public boolean isExpired() {
        Path timestampPath = getTimestampPath();
        if (!Files.exists(timestampPath)) {
            return true;
        }
        
        try {
            long lastModified = Files.getLastModifiedTime(timestampPath).toMillis();
            return System.currentTimeMillis() - lastModified > TEN_MINUTES;
        } catch (IOException e) {
            return true;
        }
    }

    public void updateTimestamp() {
        try {
            Files.write(getTimestampPath(), new byte[0]);
        } catch (IOException e) {
            log.error("Exception during updating timestamp to file", e);
        }
    }

    private Path getTimestampPath() {
        return Paths.get(filePath.toString() + ".timestamp");
    }
}
