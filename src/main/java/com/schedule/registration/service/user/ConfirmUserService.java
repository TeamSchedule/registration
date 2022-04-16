package com.schedule.registration.service.user;

import com.schedule.registration.model.entity.RegistrationToken;

public interface ConfirmUserService {
    void confirm(RegistrationToken token);
}
