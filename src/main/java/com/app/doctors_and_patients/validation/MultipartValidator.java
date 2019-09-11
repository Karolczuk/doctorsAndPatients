package com.app.doctors_and_patients.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MultipartValidation.class)
public @interface MultipartValidator {

    String message() default "File is not valid";
    String extension() default "jpg";
    int maxSize() default 0;

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
