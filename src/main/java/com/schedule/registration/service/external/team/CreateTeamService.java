package com.schedule.registration.service.external.team;

import com.schedule.registration.model.external.request.CreateTeamRequest;
import com.schedule.registration.model.external.response.CreateTeamResponse;

public interface CreateTeamService {
    void create(CreateTeamRequest createTeamRequest);
}
