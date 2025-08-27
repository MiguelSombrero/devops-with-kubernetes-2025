package com.github.miguelsombrero.devopswithkubernetes.log_output.log;

import com.github.miguelsombrero.devopswithkubernetes.log_output.reader.OutputReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LogService {

    private final PongService pongService;
    private final OutputReader reader;
    private final String logFilePath;

    public LogService(
            PongService pongService,
            OutputReader reader,
            @Value("${file.path.output}") String logFilePath) {
        this.pongService = pongService;
        this.reader = reader;
        this.logFilePath = logFilePath;
    }

    public String getLogs() {
        String logs = reader.readFileToString(logFilePath);
        String pongs = pongService.getPong();
        return logs + "\n" + pongs;
    }

}
