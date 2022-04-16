package com.schedule.registration.controller;

import com.schedule.registration.model.response.DefaultSuccessResponse;
import com.schedule.registration.service.registration.ConfirmRegistrationService;
import com.schedule.registration.service.token.GetTokenByIdService;
import com.schedule.registration.validator.TokenExpiredConstraint;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/token")
public class ConfirmTokenController {
    private final GetTokenByIdService getTokenByIdService;
    private final ConfirmRegistrationService confirmRegistrationService;

    @PatchMapping("/{tokenId}")
    public ResponseEntity<?> confirm(@PathVariable @TokenExpiredConstraint Long tokenId) {
        confirmRegistrationService.confirm(getTokenByIdService.get(tokenId));
        return ResponseEntity.ok().body(
                new DefaultSuccessResponse(
                        "Token has been successfully confirmed"
                )
        );
    }
}
