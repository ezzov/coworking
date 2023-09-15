package com.example.coworking.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class CustomNotAcceptableException extends RuntimeException {

    public CustomNotAcceptableException(String message) {
    super(message);
    }
}