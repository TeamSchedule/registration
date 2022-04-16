package com.schedule.registration.controller;

import com.schedule.registration.model.response.DefaultErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

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
                                exception.getErrorCount(),
                                exception
                                        .getBindingResult()
                                        .getAllErrors()
                                        .stream()
                                        .map(ObjectError::getDefaultMessage)
                                        .toList()
                        )
                );
    }
    @ExceptionHandler({
            ConstraintViolationException.class
    })
    public ResponseEntity<?> handleDefaultErrorResponseErrors(
            ConstraintViolationException exception
    ) {
        List<ConstraintViolation<?>> list = exception.getConstraintViolations().stream().toList();
        return ResponseEntity
                .badRequest()
                .body(
                        new DefaultErrorResponse(
                                list.size(),
                                list.stream().map(ConstraintViolation::getMessage).toList()
                        )
                );
    }
}
