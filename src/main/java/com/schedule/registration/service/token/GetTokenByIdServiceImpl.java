package com.schedule.registration.service.token;

import com.schedule.registration.model.entity.RegistrationToken;
import com.schedule.registration.repository.RegistrationTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetTokenByIdServiceImpl implements GetTokenByIdService {
    private final RegistrationTokenRepository registrationTokenRepository;

    @Override
    public RegistrationToken get(Long id) {
        return registrationTokenRepository.getById(id);
    }
}
