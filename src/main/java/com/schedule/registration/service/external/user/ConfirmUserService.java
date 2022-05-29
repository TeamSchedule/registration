package com.schedule.registration.service.external.user;

import com.schedule.registration.model.entity.RegistrationToken;

public interface ConfirmUserService {
    void confirm(RegistrationToken token);
}
