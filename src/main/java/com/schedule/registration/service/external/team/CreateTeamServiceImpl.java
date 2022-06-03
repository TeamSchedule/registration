package com.schedule.registration.service.external.team;

import com.schedule.registration.model.external.request.CreateTeamRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class CreateTeamServiceImpl implements CreateTeamService {
    private final HttpHeaders headers;
    private final RestTemplate restTemplate;
    @Value("${app.external.schedule.address}")
    private String teamServiceAddress;

    @Override
    public void create(CreateTeamRequest createTeamRequest) {
        HttpEntity<CreateTeamRequest> requestEntity = new HttpEntity<>(createTeamRequest, headers);
        restTemplate.postForEntity(
                teamServiceAddress + "/schedule/team/default",
                requestEntity,
                Object.class
        );
    }
}
