package com.schedule.registration.service.external.user;

import com.schedule.registration.model.entity.RegistrationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class ConfirmUserServiceImpl implements ConfirmUserService {
    private final HttpHeaders headers;
    private final RestTemplate restTemplate;
    @Value("${app.external.user.address}")
    private String userServiceAddress;

    @Override
    public void confirm(RegistrationToken token) {
        restTemplate.patchForObject(
                userServiceAddress + "/user/" + token.getUserId(),
                new HttpEntity<>(headers),
                Object.class
        );
    }
}
