package com.schedule.registration.model.external;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendEmailRequest {
    private String login;
    private String email;
    private String link;
}
