package com.oxyl.coursepfback.controller.validation;

import com.oxyl.coursepfback.service.service.MapService;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.validation.ConstraintValidator;

public class ZombieValidation implements ConstraintValidator<ZombieAnnotation.MapIdExists, Integer> {
    @Autowired
    private MapService mapService;

    @Override
    public boolean isValid(Integer mapId, ConstraintValidatorContext context) {
        if (mapId == null) {
            return false;
        }
        return mapService.getAllMapIds().contains(mapId);
    }
}
