package com.schedule.registration.repository;

import com.schedule.registration.model.entity.RegistrationToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationTokenRepository extends CrudRepository<RegistrationToken, Long> {
}
