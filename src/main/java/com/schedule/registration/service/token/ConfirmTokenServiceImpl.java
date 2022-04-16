package com.schedule.registration.service.token;

import com.schedule.registration.model.entity.RegistrationToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ConfirmTokenServiceImpl implements ConfirmTokenService {
    @Override
    @Transactional
    public void confirm(RegistrationToken token) {
        token.setConfirmedAt(LocalDateTime.now());
    }
}
