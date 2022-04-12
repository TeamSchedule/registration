package com.schedule.registration.service.user;

import com.schedule.registration.model.api_response.CreateUserResponse;
import com.schedule.registration.model.request.RegistrationRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class CreateUserServiceImpl implements CreateUserService {
    @Value("${app.external.user.address}")
    private String userServiceAddress;

    @Override
    public CreateUserResponse create(RegistrationRequest registrationRequest) {
        // TODO: extract bean
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<RegistrationRequest> requestEntity = new HttpEntity<>(registrationRequest, headers);
        ResponseEntity<CreateUserResponse> response = new RestTemplate().postForEntity(
                userServiceAddress + "/user",
                requestEntity,
                CreateUserResponse.class
        );

        return response.getBody();
    }
}
