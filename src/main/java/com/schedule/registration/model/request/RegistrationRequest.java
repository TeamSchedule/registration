package com.schedule.registration.model.request;

import com.schedule.registration.validator.LoginAlreadyTakenConstraint;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@LoginAlreadyTakenConstraint
public class RegistrationRequest {
    @NotEmpty(message = "Login is mandatory")
    @Size(min = 3, max = 30, message = "Login length must be in range between 3 and 30")
    private String login;

    @NotEmpty(message = "Password is mandatory")
    @Size(min = 3, max = 30, message = "Password length must be in range between 3 and 30")
    private String password;

    @Email(message = "Email is not valid")
    @NotEmpty(message = "Email is mandatory")
    private String email;
}
