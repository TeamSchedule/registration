package com.schedule.registration.service.rabbit;

import com.schedule.registration.model.external.SendEmailRequest;

public interface QueueSendMessageService {
    void send(SendEmailRequest sendEmailRequest);
}
