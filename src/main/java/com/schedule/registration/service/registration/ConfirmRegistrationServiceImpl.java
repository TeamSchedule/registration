package com.schedule.registration.service.registration;

import com.schedule.registration.model.entity.RegistrationToken;
import com.schedule.registration.service.token.ConfirmTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ConfirmRegistrationServiceImpl implements ConfirmRegistrationService {
    private final ConfirmTokenService confirmTokenService;
    private final HttpHeaders headers;
    @Value("${app.external.user.address}")
    private String userServiceAddress;

    @Override
    public void confirm(RegistrationToken token) {
        new RestTemplate().patchForObject(
                userServiceAddress + "/user/" + token.getUserId(),
                new HttpEntity<>(headers),
                Object.class
        );

        confirmTokenService.confirm(token);
    }
}
