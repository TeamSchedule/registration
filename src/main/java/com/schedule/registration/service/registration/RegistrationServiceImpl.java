package com.schedule.registration.service.registration;

import com.schedule.registration.model.entity.RegistrationToken;
import com.schedule.registration.model.external.request.SendEmailRequest;
import com.schedule.registration.model.request.RegistrationRequest;
import com.schedule.registration.service.link.AccessLinkService;
import com.schedule.registration.service.external.rabbit.QueueSendMessageService;
import com.schedule.registration.service.token.SaveTokenService;
import com.schedule.registration.service.external.user.CreateUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final SaveTokenService saveTokenService;
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
        registrationToken = saveTokenService.save(registrationToken);

        queueSendMessageService.send(
                new SendEmailRequest(
                        registrationRequest.getLogin(),
                        registrationRequest.getEmail(),
                        accessLinkService.link() + "/registration/confirm/" + registrationToken.getId()
                )
        );
    }
}
