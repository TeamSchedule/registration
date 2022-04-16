package com.schedule.registration.model.external.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SendEmailRequest {
    private String login;
    private String email;
    private String link;
}
