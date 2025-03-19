package com.example.DesafioItau.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;

public class CurrentTimeValidator implements ConstraintValidator<CurrentTime, OffsetDateTime> {

    @Override
    public boolean isValid(OffsetDateTime value, ConstraintValidatorContext context) {
        if (value == null) {
            return true; // Deixe a validação de @NotNull cuidar disso
        }

        OffsetDateTime now = OffsetDateTime.now();
        // Verifica se o valor é igual ao momento atual (com precisão de segundos)
        return value.truncatedTo(ChronoUnit.SECONDS).equals(now.truncatedTo(ChronoUnit.SECONDS));
    }
}