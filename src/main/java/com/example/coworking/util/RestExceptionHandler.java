package com.example.coworking.util;

import com.example.coworking.util.exception.CustomBadRequestException;
import com.example.coworking.util.exception.CustomConflictException;
import com.example.coworking.util.exception.CustomForbiddenException;
import com.example.coworking.util.exception.CustomInternalServerErrorException;
import com.example.coworking.util.exception.CustomLockedException;
import com.example.coworking.util.exception.CustomNoContentException;
import com.example.coworking.util.exception.CustomNotAcceptableException;
import com.example.coworking.util.exception.CustomNotFoundException;
import com.example.coworking.util.exception.CustomUnauthorizedException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {
    
    @ExceptionHandler(CustomNoContentException.class)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Map<String, String> handleException(CustomNoContentException ex) {
        return Collections.singletonMap("message", ex.getMessage());
    }

    @ExceptionHandler(CustomNotAcceptableException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public Map<String, String> handleException(CustomNotAcceptableException ex) {
        return Collections.singletonMap("message", ex.getMessage());
    }

    @ExceptionHandler(CustomNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handleException(CustomNotFoundException ex) {
        return Collections.singletonMap("message", ex.getMessage());
    }

    @ExceptionHandler(CustomConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public Map<String, String> handleException(CustomConflictException ex) {
        return Collections.singletonMap("message", ex.getMessage());
    }

    @ExceptionHandler(CustomForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Map<String, String> handleException(CustomForbiddenException ex) {
        return Collections.singletonMap("message", ex.getMessage());
    }

    @ExceptionHandler(CustomBadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleException(CustomBadRequestException ex) {
        return Collections.singletonMap("message", ex.getMessage());
    }

    @ExceptionHandler(CustomInternalServerErrorException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, String> handleException(CustomInternalServerErrorException ex) {
        return Collections.singletonMap("message", ex.getMessage());
    }

    @ExceptionHandler(CustomLockedException.class)
    @ResponseStatus(HttpStatus.LOCKED)
    public Map<String, String> handleException(CustomLockedException ex) {
        return Collections.singletonMap("message", ex.getMessage());
    }

    @ExceptionHandler(CustomUnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, String> handleException(CustomUnauthorizedException ex) {
        return Collections.singletonMap("message", ex.getMessage());
    }
}