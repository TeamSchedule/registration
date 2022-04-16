package com.schedule.registration.service.token;

import com.schedule.registration.model.entity.RegistrationToken;

public interface GetTokenByIdService {
    RegistrationToken get(Long id);
}
