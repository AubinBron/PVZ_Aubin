package com.oxyl.coursepfback.service.service;

import com.oxyl.coursepfback.persistance.repository.ZombieRepository;
import com.oxyl.coursepfback.persistance.DAO.ZombieDAO;
import com.oxyl.coursepfback.service.model.ZombieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZombieService {

    private final ZombieRepository zombieRepository;

    @Autowired
    public ZombieService(ZombieRepository zombieRepository , ZombieDAO zombieDAO){
        this.zombieRepository = zombieRepository;
    }


    public List<ZombieModel> findAll(){
        return (zombieRepository.findAll());
    }

    public ZombieModel findById(int id){
        return (zombieRepository.findById(id));
    }

    public List<ZombieModel> findByMapId(int mapId){
        return (zombieRepository.findByMapId(mapId));
    }

    public void add(ZombieModel zombieModel){
        zombieRepository.addZombie(zombieModel);
    }

    public void deleteZombie(int id){
        zombieRepository.deleteZombie(id);
    }

    public void updateZombie(int id, ZombieModel zombieModel){
        zombieRepository.updateZombie(id, zombieModel);
    }
}
