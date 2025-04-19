package com.oxyl.coursepfback.service.service;

import com.oxyl.coursepfback.persistance.repository.MapRepository;
import com.oxyl.coursepfback.persistance.repository.ZombieRepository;
import com.oxyl.coursepfback.service.model.MapModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService {
    private final MapRepository mapRepository;
    private final ZombieRepository zombieRepository;

    @Autowired
    public MapService(MapRepository mapRepository, ZombieRepository zombieRepository) {
        this.mapRepository = mapRepository;
        this.zombieRepository = zombieRepository;
    }

    public MapModel findById(int id) {
        return mapRepository.findById(id);
    }

    public List<MapModel> findAll() {
        return mapRepository.findAll();
    }

    public void add(MapModel mapModel) {
        mapRepository.addMap(mapModel);
    }

    public void deleteMap(int id) {
        zombieRepository.deleteZombieByMapId(id);
        mapRepository.deleteMap(id);
    }

    public void updateMap(int id, MapModel mapModel) {
        mapRepository.updateMap(id, mapModel);
    }

    public List<Integer> getAllMapIds() {
        return mapRepository.getAllMapIds();
    }
}
