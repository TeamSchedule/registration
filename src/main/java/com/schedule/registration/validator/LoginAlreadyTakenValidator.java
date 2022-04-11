package com.schedule.registration.validator;

import com.schedule.registration.model.request.RegistrationRequest;
import com.schedule.registration.service.UserExistsByLoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
@RequiredArgsConstructor
public class LoginAlreadyTakenValidator
        implements ConstraintValidator<LoginAlreadyTakenConstraint, RegistrationRequest> {
    private final UserExistsByLoginService userExistsByLoginService;

    @Override
    public boolean isValid(RegistrationRequest request, ConstraintValidatorContext context) {
        return !userExistsByLoginService.exists(request.getLogin());
    }
}
