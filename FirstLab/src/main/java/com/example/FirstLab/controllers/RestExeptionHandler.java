package com.example.FirstLab.controllers;

import com.example.FirstLab.core.SingleErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExeptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(RestExeptionHandler.class);

    @ExceptionHandler(value = {SingleErrorResponse.class})
    public ResponseEntity<SingleErrorResponse> illegalArgument(SingleErrorResponse e) {
        logger.error("Error");
        return ResponseEntity.status(400).body(e);
    }

    @ExceptionHandler(value = {Throwable.class})
    public ResponseEntity<SingleErrorResponse> all(Throwable e) {
        return ResponseEntity.status(500).body(
                new SingleErrorResponse("server error", e.getLocalizedMessage()));
    }
}
