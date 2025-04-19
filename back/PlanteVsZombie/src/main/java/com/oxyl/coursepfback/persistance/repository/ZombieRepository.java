package com.oxyl.coursepfback.persistance.repository;

import com.oxyl.coursepfback.persistance.DAO.ZombieDAO;
import com.oxyl.coursepfback.persistance.mapper.ZombieEntityMapper;
import com.oxyl.coursepfback.service.model.ZombieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ZombieRepository {
    private final ZombieDAO zombieDAO;
    private final ZombieEntityMapper zombieEntityMapper;

    @Autowired
    public ZombieRepository(ZombieDAO zombieDAO, ZombieEntityMapper zombieEntityMapper){
        this.zombieDAO=zombieDAO;
        this.zombieEntityMapper=zombieEntityMapper;
    }


    // GET

     public List<ZombieModel> findAll(){
        return zombieEntityMapper.mapListEntityToListModel(zombieDAO.getAllZombies());
    }

    public ZombieModel findById(int id){
        return zombieEntityMapper.mapEntityToModel(zombieDAO.getZombieById(id));
    }

    public List<ZombieModel> findByMapId(int mapId){
        return zombieEntityMapper.mapListEntityToListModel(zombieDAO.getZombiesByMapID(mapId));
    }


    // CREATE
    public void addZombie(ZombieModel zombieModel){
        zombieDAO.addZombie(zombieEntityMapper.mapModelToEntity(zombieModel));
    }

    // DELETE

    public void deleteZombie(int id){
        zombieDAO.deleteZombie(id);
    }

    public void deleteZombieByMapId(int mapId){
        zombieDAO.deleteZombiesByMapId(mapId);
    }

    // UPDATE

    public void updateZombie(int id, ZombieModel zombieModel){
        zombieDAO.updateZombie(id, zombieEntityMapper.mapModelToEntity(zombieModel));
    }

}
