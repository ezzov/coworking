package com.example.coworking.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NO_CONTENT)
public class CustomNoContentException extends RuntimeException {

    public CustomNoContentException(String message) {
    super(message);
    }
}