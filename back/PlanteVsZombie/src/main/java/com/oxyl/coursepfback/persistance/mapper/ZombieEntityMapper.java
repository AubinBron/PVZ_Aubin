package com.oxyl.coursepfback.persistance.mapper;

import com.oxyl.coursepfback.persistance.entity.ZombieEntity;
import com.oxyl.coursepfback.service.model.ZombieModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ZombieEntityMapper {

    public ZombieModel mapEntityToModel(ZombieEntity zombieEntity){
        if (zombieEntity==null){
            return null;
        }
        ZombieModel zombieModel = new ZombieModel();
        zombieModel.setId_zombie(zombieEntity.getId_zombie());
        zombieModel.setNom(zombieEntity.getNom());
        zombieModel.setPoint_de_vie(zombieEntity.getPoint_de_vie());
        zombieModel.setAttaque_par_seconde(zombieEntity.getAttaque_par_seconde());
        zombieModel.setDegat_attaque(zombieEntity.getDegat_attaque());
        zombieModel.setVitesse_de_deplacement(zombieEntity.getVitesse_de_deplacement());
        zombieModel.setChemin_image(zombieEntity.getChemin_image());
        zombieModel.setId_map(zombieEntity.getId_map());
        return zombieModel;
    }

    public List<ZombieModel> mapListEntityToListModel(List<ZombieEntity> zombieEntities){
        List<ZombieModel> zombieModels = new ArrayList<>();
        for (ZombieEntity zombieEntity : zombieEntities){
            zombieModels.add(this.mapEntityToModel(zombieEntity));
        }
        return zombieModels;
    }

    public ZombieEntity mapModelToEntity(ZombieModel zombieModel){
        if (zombieModel==null){
            return null;
        }
        ZombieEntity zombieEntity = new ZombieEntity();
        zombieEntity.setId_zombie(zombieModel.getId_zombie());
        zombieEntity.setNom(zombieModel.getNom());
        zombieEntity.setPoint_de_vie(zombieModel.getPoint_de_vie());
        zombieEntity.setAttaque_par_seconde(zombieModel.getAttaque_par_seconde());
        zombieEntity.setDegat_attaque(zombieModel.getDegat_attaque());
        zombieEntity.setVitesse_de_deplacement(zombieModel.getVitesse_de_deplacement());
        zombieEntity.setChemin_image(zombieModel.getChemin_image());
        zombieEntity.setId_map(zombieModel.getId_map());

        return zombieEntity;
    }

    public List<ZombieEntity> mapListModelToListEntity(List<ZombieModel> zombieModels){
        List<ZombieEntity> zombieEntities = new ArrayList<>();
        for (ZombieModel zombieModel : zombieModels){
            zombieEntities.add(this.mapModelToEntity(zombieModel));
        }
        return zombieEntities;
    }
}
