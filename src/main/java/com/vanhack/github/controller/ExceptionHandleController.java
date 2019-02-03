package com.vanhack.github.controller;

import com.vanhack.github.domain.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.NoSuchElementException;

@RestController
@ControllerAdvice
public class ExceptionHandleController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public final ResponseEntity<Error> notFoundException(NoSuchElementException e, WebRequest request) {

        return new ResponseEntity<>(Error
                .builder()
                .withMessage(e.getMessage())
                .withDetails(request.getDescription(true))
                .withTimestamp(Timestamp.from(Instant.now()))
                .build(),
                HttpStatus.NOT_FOUND);
    }

}
