package com.schedule.registration.service.user;

import com.schedule.registration.model.api_response.CreateUserResponse;
import com.schedule.registration.model.request.RegistrationRequest;

public interface CreateUserService {
    CreateUserResponse create(RegistrationRequest registrationRequest);
}
