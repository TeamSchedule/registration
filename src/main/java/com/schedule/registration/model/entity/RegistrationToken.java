package com.schedule.registration.model.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "registration_token")
@Data
@NoArgsConstructor
public class RegistrationToken {
    @Id
    @Column(name = "id")
    @SequenceGenerator(
            name = "registration_token_sequence",
            sequenceName = "registration_token_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "registration_token_sequence"
    )
    private Long id;

    @Column(name = "user_id")
    private Long userId;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "expires_at")
    private LocalDateTime expiresAt;
    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;

    public RegistrationToken(
            Long userId,
            LocalDateTime createdAt,
            LocalDateTime expiresAt
    ) {
        this.userId = userId;
        this.createdAt = createdAt;
        this.expiresAt = expiresAt;
    }
}
