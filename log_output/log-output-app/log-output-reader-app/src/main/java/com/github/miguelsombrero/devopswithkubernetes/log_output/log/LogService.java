package com.github.miguelsombrero.devopswithkubernetes.log_output.log;

import com.github.miguelsombrero.devopswithkubernetes.log_output.reader.OutputReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private final PongService pongService;
    private final OutputReader reader;
    private final String logFilePath;
    private final String configFilePath;
    private final String message;

    public LogService(
            PongService pongService,
            OutputReader reader,
            @Value("${file.path.output}") String logFilePath,
            @Value("${file.path.config}") String configFilePath,
            @Value("${log.message}") String message) {
        this.pongService = pongService;
        this.reader = reader;
        this.logFilePath = logFilePath;
        this.configFilePath = configFilePath;
        this.message = message;
    }

    public String getLogs() {
        String logs = reader.readFileToString(logFilePath);
        String config = reader.readFileToString(configFilePath);
        String pongs = pongService.getPong();
        return config + "\n" + message + "\n" + logs + "\n" + pongs;
    }

}
