package com.schedule.registration.service.registration;

import com.schedule.registration.model.entity.RegistrationToken;
import com.schedule.registration.service.token.ConfirmTokenService;
import com.schedule.registration.service.user.ConfirmUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmRegistrationServiceImpl implements ConfirmRegistrationService {
    private final ConfirmUserService confirmUserService;
    private final ConfirmTokenService confirmTokenService;

    @Override
    public void confirm(RegistrationToken token) {
        confirmUserService.confirm(token);
        confirmTokenService.confirm(token);
    }
}
