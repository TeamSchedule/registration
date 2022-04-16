package com.schedule.registration.service.user;

import com.schedule.registration.model.external.response.CreateUserResponse;
import com.schedule.registration.model.request.RegistrationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CreateUserServiceImpl implements CreateUserService {
    private final HttpHeaders headers;
    private final RestTemplate restTemplate;
    @Value("${app.external.user.address}")
    private String userServiceAddress;

    @Override
    public CreateUserResponse create(RegistrationRequest registrationRequest) {
        HttpEntity<RegistrationRequest> requestEntity = new HttpEntity<>(registrationRequest, headers);
        ResponseEntity<CreateUserResponse> response = restTemplate.postForEntity(
                userServiceAddress + "/user",
                requestEntity,
                CreateUserResponse.class
        );

        return response.getBody();
    }
}
