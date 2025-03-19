package com.example.DesafioItau.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CurrentTimeValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentTime {

    String message() default "A data/hora da transação deve ser exatamente o momento atual.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}