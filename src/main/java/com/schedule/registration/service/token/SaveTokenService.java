package com.schedule.registration.service.token;

import com.schedule.registration.model.entity.RegistrationToken;

public interface SaveTokenService {
    RegistrationToken save(RegistrationToken registrationToken);
}
