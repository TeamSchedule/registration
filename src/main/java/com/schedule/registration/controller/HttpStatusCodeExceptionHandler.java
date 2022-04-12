package com.schedule.registration.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.schedule.registration.model.response.DefaultErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
@RequiredArgsConstructor
public class HttpStatusCodeExceptionHandler {
    private final ObjectMapper objectMapper;

    @ExceptionHandler({
            HttpClientErrorException.class
    })
    public ResponseEntity<?> handleCreateUserErrors(
            HttpClientErrorException exception
    ) throws JsonProcessingException {
        DefaultErrorResponse response = objectMapper.readValue(
                exception.getResponseBodyAsString(),
                DefaultErrorResponse.class
        );
        return ResponseEntity
                .badRequest()
                .body(response);
    }
}
