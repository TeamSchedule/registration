package com.schedule.registration.model.request;

import com.schedule.registration.validator.LoginAlreadyTakenConstraint;
import lombok.Data;

@Data
@LoginAlreadyTakenConstraint
public class RegistrationRequest {
    private String login;
    private String password;
    private String email;
}
