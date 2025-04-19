package com.oxyl.coursepfback.controller.controller;

import com.oxyl.coursepfback.controller.DTO.PlanteDTO;
import com.oxyl.coursepfback.controller.mapper.PlanteDtoMapper;
import com.oxyl.coursepfback.service.service.PlanteService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plantes")
public class PlanteController {
    private final PlanteService planteService;
    private final PlanteDtoMapper planteDtoMapper;

    @Autowired
    public PlanteController(PlanteService planteService, PlanteDtoMapper planteDtoMapper) {
        this.planteService = planteService;
        this.planteDtoMapper = planteDtoMapper;
    }

    @GetMapping
    public List<PlanteDTO> getAllPlantes() {
        return planteDtoMapper.mapListModelToListDto(planteService.findAll());
    }

    @GetMapping("/{id}")
    public PlanteDTO getPlanteById(@PathVariable int id) {
        return planteDtoMapper.mapModelToDto(planteService.findById(id));
    }

    @PostMapping
    public void addPlante(@Valid @RequestBody PlanteDTO planteDTO) {
        planteService.add(planteDtoMapper.mapDtoToModel(planteDTO));
    }

    @DeleteMapping("/{id}")
    public void deletePlante(@PathVariable int id) {
        planteService.deletePlante(id);
    }

    @PutMapping("/{id}")
    public void updatePlante(@PathVariable int id, @Valid @RequestBody PlanteDTO planteDTO) {
        planteService.updatePlante(id, planteDtoMapper.mapDtoToModel(planteDTO));
    }
}