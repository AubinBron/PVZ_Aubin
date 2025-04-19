package com.oxyl.coursepfback.persistance.DAO;

import com.oxyl.coursepfback.persistance.entity.ZombieEntity;
import com.oxyl.coursepfback.service.model.ZombieModel;

import java.util.List;

public interface ZombieInterfaceDAO {

    public List<ZombieEntity> getAllZombies();

    public ZombieEntity getZombieById(int id);

    public void addZombie(ZombieEntity zombieEntity);

    public void deleteZombie(int zombieId);

    public void updateZombie(int id, ZombieEntity zombieEntity);

    public void deleteZombiesByMapId(int mapId);

    public List<ZombieEntity> getZombiesByMapID(int mapID);
}

/*
Zombies
GET /zombies - Liste tous les zombies
GET /zombies/{id} - Récupère un zombie par son ID
POST /zombies - Crée un nouveau zombie
PUT /zombies/{id} - Modifie un zombie existant
DELETE /zombies/{id} - Supprime un zombie
 */
