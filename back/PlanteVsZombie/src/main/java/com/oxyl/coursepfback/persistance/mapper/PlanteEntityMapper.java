package com.oxyl.coursepfback.persistance.mapper;

import com.oxyl.coursepfback.persistance.entity.PlanteEntity;
import com.oxyl.coursepfback.service.model.PlanteModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlanteEntityMapper {

    public PlanteModel mapEntityToModel(PlanteEntity planteEntity){
        if (planteEntity==null){
            return null;
        }
        PlanteModel planteModel = new PlanteModel();
        planteModel.setId_plante(planteEntity.getId_plante());
        planteModel.setNom(planteEntity.getNom());
        planteModel.setPoint_de_vie(planteEntity.getPoint_de_vie());
        planteModel.setAttaque_par_seconde(planteEntity.getAttaque_par_seconde());
        planteModel.setDegat_attaque(planteEntity.getDegat_attaque());
        planteModel.setCout(planteEntity.getCout());
        planteModel.setSoleil_par_seconde(planteEntity.getSoleil_par_seconde());
        planteModel.setEffet(planteEntity.getEffet());
        planteModel.setChemin_image(planteEntity.getChemin_image());

        return planteModel;
    }

    public List<PlanteModel> mapListEntityToListModel(List<PlanteEntity> planteEntities){
        List<PlanteModel> planteModels = new ArrayList<>();
        for (PlanteEntity planteEntity : planteEntities){
            planteModels.add(this.mapEntityToModel(planteEntity));
        }
        return planteModels;
    }

    public PlanteEntity mapModelToEntity(PlanteModel planteModel){
        if (planteModel==null){
            return null;
        }
        PlanteEntity planteEntity = new PlanteEntity();
        planteEntity.setId_plante(planteModel.getId_plante());
        planteEntity.setNom(planteModel.getNom());
        planteEntity.setPoint_de_vie(planteModel.getPoint_de_vie());
        planteEntity.setAttaque_par_seconde(planteModel.getAttaque_par_seconde());
        planteEntity.setDegat_attaque(planteModel.getDegat_attaque());
        planteEntity.setCout(planteModel.getCout());
        planteEntity.setSoleil_par_seconde(planteModel.getSoleil_par_seconde());
        planteEntity.setEffet(planteModel.getEffet());
        planteEntity.setChemin_image(planteModel.getChemin_image());

        return planteEntity;
    }

    public List<PlanteEntity> mapListModelToListEntity(List<PlanteModel> planteModels){
        List<PlanteEntity> planteEntities = new ArrayList<>();
        for (PlanteModel planteModel : planteModels){
            planteEntities.add(this.mapModelToEntity(planteModel));
        }
        return planteEntities;
    }

}
