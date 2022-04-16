package com.schedule.registration.service.registration;

import com.schedule.registration.model.entity.RegistrationToken;
import com.schedule.registration.model.external.request.SendEmailRequest;
import com.schedule.registration.model.request.RegistrationRequest;
import com.schedule.registration.repository.RegistrationTokenRepository;
import com.schedule.registration.service.link.AccessLinkService;
import com.schedule.registration.service.rabbit.QueueSendMessageService;
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
    private final QueueSendMessageService queueSendMessageService;
    private final AccessLinkService accessLinkService;

    @Override
    public void register(RegistrationRequest registrationRequest) {
        Long userId = createUserService.create(registrationRequest).getUserId();
        LocalDateTime creationDate = LocalDateTime.now();

        RegistrationToken registrationToken = new RegistrationToken(
                userId, creationDate, creationDate.plus(Duration.ofMinutes(15))
        );
        registrationToken = registrationTokenRepository.save(registrationToken);

        queueSendMessageService.send(
                new SendEmailRequest(
                        registrationRequest.getLogin(),
                        registrationRequest.getEmail(),
                        accessLinkService.link() + "/token/" + registrationToken.getId()
                )
        );
    }
}
