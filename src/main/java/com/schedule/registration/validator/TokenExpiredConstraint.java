package com.schedule.registration.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = TokenExpiredValidator.class)
@Target({ ElementType.PARAMETER })
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenExpiredConstraint {
    String message() default "Token expired";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };
}
