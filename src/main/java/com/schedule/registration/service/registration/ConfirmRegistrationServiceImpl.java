package com.schedule.registration.service.registration;

import com.schedule.registration.model.entity.RegistrationToken;
import com.schedule.registration.model.external.request.CreateTeamRequest;
import com.schedule.registration.service.external.team.CreateTeamService;
import com.schedule.registration.service.token.ConfirmTokenService;
import com.schedule.registration.service.external.user.ConfirmUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConfirmRegistrationServiceImpl implements ConfirmRegistrationService {
    private final ConfirmUserService confirmUserService;
    private final ConfirmTokenService confirmTokenService;
    private final CreateTeamService createTeamService;

    @Override
    public void confirm(RegistrationToken token) {
        confirmUserService.confirm(token);
        confirmTokenService.confirm(token);
        createTeamService.create(new CreateTeamRequest(token.getUserId()));
    }
}
