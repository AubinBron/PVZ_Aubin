package com.oxyl.coursepfback.controller.controller;

import com.oxyl.coursepfback.controller.DTO.MapDTO;
import com.oxyl.coursepfback.controller.mapper.MapDtoMapper;
import com.oxyl.coursepfback.service.service.MapService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maps")
public class MapController {
    private final MapService mapService;
    private final MapDtoMapper mapDtoMapper;

    @Autowired
    public MapController(MapService mapService, MapDtoMapper mapDtoMapper) {
        this.mapService = mapService;
        this.mapDtoMapper = mapDtoMapper;
    }

    @GetMapping
    public List<MapDTO> getAllMaps() {
        return mapDtoMapper.mapListModelToListDto(mapService.findAll());
    }

    @GetMapping("/{id}")
    public MapDTO getMapById(@PathVariable int id) {
        return mapDtoMapper.mapModelToDto(mapService.findById(id));
    }

    @PostMapping
    public void addMap(@Valid @RequestBody MapDTO mapDTO) {
        mapService.add(mapDtoMapper.mapDtoToModel(mapDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteMap(@PathVariable int id) {
        mapService.deleteMap(id);
    }

    @PutMapping("/{id}")
    public void updateMap(@PathVariable int id, @Valid @RequestBody MapDTO mapDTO) {
        mapService.updateMap(id, mapDtoMapper.mapDtoToModel(mapDTO));
    }
}
