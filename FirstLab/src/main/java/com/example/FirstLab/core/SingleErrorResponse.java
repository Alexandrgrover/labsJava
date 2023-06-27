package com.example.FirstLab.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"logref", "message"})
@JsonIgnoreProperties({"cause","stackTrace","suppressed","localizedMessage"})
public class SingleErrorResponse extends RuntimeException {
    private String logref;
    private String message;

    public SingleErrorResponse(String logref, String message) {
        this.logref = logref;
        this.message = message;
    }

    public String getLogref() {
        return logref;
    }

    public String getMessage() {
        return message;
    }
}

