package com.github.miguelsombrero.devopswithkubernetes.log_output.reader;

public interface OutputReader {
    String readFileToString(String filePath);
}
