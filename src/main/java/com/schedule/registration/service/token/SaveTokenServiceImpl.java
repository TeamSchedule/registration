package com.schedule.registration.service.token;

import com.schedule.registration.model.entity.RegistrationToken;
import com.schedule.registration.repository.RegistrationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveTokenServiceImpl implements SaveTokenService {
    private final RegistrationTokenRepository registrationTokenRepository;

    @Override
    public RegistrationToken save(RegistrationToken registrationToken) {
        return registrationTokenRepository.save(registrationToken);
    }
}
