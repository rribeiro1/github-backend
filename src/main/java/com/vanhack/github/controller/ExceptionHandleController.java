package com.vanhack.github.controller;

import com.vanhack.github.domain.Error;
import com.vanhack.github.controller.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.sql.Timestamp;
import java.time.Instant;

@ControllerAdvice
public class ExceptionHandleController {

    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<Error> notFoundException(Exception e, WebRequest request) {

        return new ResponseEntity<>(Error
                .builder()
                .withMessage(e.getMessage())
                .withDetails(request.getDescription(true))
                .withTimestamp(Timestamp.from(Instant.now()))
                .build(),
                HttpStatus.NOT_FOUND);
    }

}
