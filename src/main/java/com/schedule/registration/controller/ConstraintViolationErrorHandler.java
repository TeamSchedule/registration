package com.schedule.registration.controller;

import com.schedule.registration.model.response.DefaultErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ConstraintViolationErrorHandler {
    @ExceptionHandler({
            MethodArgumentNotValidException.class
    })
    public ResponseEntity<?> handleDefaultErrorResponseErrors(
            MethodArgumentNotValidException exception
    ) {
        return ResponseEntity
                .badRequest()
                .body(
                        new DefaultErrorResponse(
                                exception
                                        .getBindingResult()
                                        .getAllErrors()
                                        .get(0)
                                        .getDefaultMessage()
                        )
                );
    }
}
