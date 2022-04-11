package com.schedule.registration.model.request;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class RegistrationRequest {
    private String login;
    private String password;
    private String email;
}
