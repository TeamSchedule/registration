package com.schedule.registration.validator;

import com.schedule.registration.model.entity.RegistrationToken;
import com.schedule.registration.service.token.GetTokenByIdService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class TokenExpiredValidator
        implements ConstraintValidator<TokenExpiredConstraint, Long> {
    private final GetTokenByIdService getTokenByIdService;

    @Override
    public boolean isValid(Long tokenId, ConstraintValidatorContext context) {
        RegistrationToken token = getTokenByIdService.get(tokenId);
        return LocalDateTime.now().isBefore(token.getExpiresAt());
    }
}
