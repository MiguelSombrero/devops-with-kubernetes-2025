package com.github.miguelsombrero.devopswithkubernetes.log_output.log;

public interface LogOutputReader {
    String readFileToString(String filePath);
}
