package com.schedule.registration.service;

import com.schedule.registration.model.entity.RegistrationToken;
import com.schedule.registration.model.request.RegistrationRequest;
import com.schedule.registration.repository.RegistrationTokenRepository;
import com.schedule.registration.service.user.CreateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final RegistrationTokenRepository registrationTokenRepository;
    private final CreateUserService createUserService;

    @Override
    public void register(RegistrationRequest registrationRequest) {
        Long userId = createUserService.create(registrationRequest).getUserId();
        LocalDateTime creationDate = LocalDateTime.now();

        RegistrationToken registrationToken = new RegistrationToken(
                userId, creationDate, creationDate.plus(Duration.ofMinutes(15))
        );
        registrationTokenRepository.save(registrationToken);

        // TODO: call email service via rabbitmq
    }
}
