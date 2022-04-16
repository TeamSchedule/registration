package com.schedule.registration.controller;

import com.schedule.registration.model.request.RegistrationRequest;
import com.schedule.registration.service.registration.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    @PostMapping
    public ResponseEntity<?> register(@RequestBody @Valid RegistrationRequest registrationRequest) {
        registrationService.register(registrationRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
