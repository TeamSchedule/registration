package com.schedule.registration.service.external.user;

import com.schedule.registration.model.external.response.CreateUserResponse;
import com.schedule.registration.model.request.RegistrationRequest;

public interface CreateUserService {
    CreateUserResponse create(RegistrationRequest registrationRequest);
}
