package com.schedule.registration.service.registration;

import com.schedule.registration.model.entity.RegistrationToken;

public interface ConfirmRegistrationService {
    void confirm(RegistrationToken token);
}
