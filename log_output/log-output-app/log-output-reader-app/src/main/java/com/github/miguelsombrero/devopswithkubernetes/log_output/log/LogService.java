package com.github.miguelsombrero.devopswithkubernetes.log_output.log;

import com.github.miguelsombrero.devopswithkubernetes.log_output.reader.OutputReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private final OutputReader reader;

    private final String logFilePath;
    private final String pongFilePath;

    public LogService(
            OutputReader reader,
            @Value("${file.path.output}") String logFilePath,
            @Value("${file.path.pong}") String pongFilePath) {
        this.reader = reader;
        this.logFilePath = logFilePath;
        this.pongFilePath = pongFilePath;
    }

    public String getLogs() {
        String logs = reader.readFileToString(logFilePath);
        String pong = reader.readFileToString(pongFilePath);
        return logs + "\n" + pong;
    }

}
