package com.pg5100_Reddit.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Constraint(validatedBy = UserClassConstraintValidator.class)
@Target({
        ElementType.TYPE,
        ElementType.ANNOTATION_TYPE}
)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface UserClassConstraints {
    String message() default "Invalid constraints";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}