package com.schedule.registration.controller;

import com.schedule.registration.model.response.DefaultSuccessResponse;
import com.schedule.registration.service.registration.ConfirmRegistrationService;
import com.schedule.registration.service.token.GetTokenByIdService;
import com.schedule.registration.validator.TokenExpiredConstraint;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/registration")
public class ConfirmTokenController {
    private final GetTokenByIdService getTokenByIdService;
    private final ConfirmRegistrationService confirmRegistrationService;

    @GetMapping("/confirm/{tokenId}")
    public ResponseEntity<DefaultSuccessResponse> confirm(
            @PathVariable @TokenExpiredConstraint Long tokenId
    ) {
        // TODO: generate redirect link
        confirmRegistrationService.confirm(getTokenByIdService.get(tokenId));
        return ResponseEntity
                .status(HttpStatus.PERMANENT_REDIRECT)
                .header("Location", "http://localhost:3000/login")
                .body(
                        new DefaultSuccessResponse(
                                "Token has been successfully confirmed"
                        )
                );
    }
}
