package com.oxyl.coursepfback.controller.controller;

import com.oxyl.coursepfback.service.service.ZombieService;
import com.oxyl.coursepfback.controller.DTO.ZombieDTO;
import com.oxyl.coursepfback.controller.mapper.ZombieDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/zombies")
public class ZombieController {
    private final ZombieService zombieService;
    private final ZombieDtoMapper zombieDtoMapper;
    @Autowired
    public ZombieController(ZombieService zombieService, ZombieDtoMapper zombieDtoMapper){
        this.zombieService = zombieService;
        this.zombieDtoMapper = zombieDtoMapper;
    }


    @GetMapping
    public List<ZombieDTO> getAllZombies(){
        return zombieDtoMapper.mapListModelToListDto(zombieService.findAll());
    }

    @GetMapping("/{id}")
    public ZombieDTO getZombieById(@PathVariable int id){
        return zombieDtoMapper.mapModelToDto(zombieService.findById(id));
    }

    @PostMapping
    public void addZombie(@Valid @RequestBody ZombieDTO zombieDTO){
        zombieService.add(zombieDtoMapper.mapDtoToModel(zombieDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteZombie(@PathVariable int id){
        zombieService.deleteZombie(id);
    }

    @PutMapping("/{id}")
    public void updateZombie(@PathVariable int id, @Valid @RequestBody ZombieDTO zombieDTO){
        zombieService.updateZombie(id, zombieDtoMapper.mapDtoToModel(zombieDTO));
    }

//    @GetMapping("/{mapId}")
//    public List<ZombieDTO> getZombieByMapId(@PathVariable int mapId){
//        return zombieDtoMapper.mapListModelToListDto(zombieService.findByMapId(mapId));
//    }
}
