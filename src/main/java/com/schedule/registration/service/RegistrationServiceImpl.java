package com.schedule.registration.service;

import com.schedule.registration.model.entity.User;
import com.schedule.registration.model.request.RegistrationRequest;
import com.schedule.registration.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void register(RegistrationRequest registrationRequest) {
        String encodedPassword = passwordEncoder.encode(registrationRequest.getPassword());

        User user = new User(
                registrationRequest.getLogin(),
                encodedPassword,
                LocalDate.now(),
                registrationRequest.getEmail()
        );
        userRepository.save(user);

        // TODO: call team service
        /*Team team = new Team(registrationRequest.getLogin(), LocalDate.now());
        team.getUsers().add(user);
        teamRepository.save(team);*/
    }
}
