package com.oxyl.coursepfback.controller.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

public class ZombieAnnotation {
    public @interface MapIdExists{
        String message() default "L'ID de la map doit correspondre à celui d'une map existante";
        Class<?>[] groups() default {};
        Class<? extends Payload>[] payload() default {};
    }
}
