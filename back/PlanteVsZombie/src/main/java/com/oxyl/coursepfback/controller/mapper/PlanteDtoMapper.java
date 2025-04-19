package com.oxyl.coursepfback.controller.mapper;

import com.oxyl.coursepfback.controller.DTO.PlanteDTO;
import com.oxyl.coursepfback.service.model.PlanteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlanteDtoMapper {

    public PlanteDTO mapModelToDto(PlanteModel planteModel){
        if (planteModel == null){
            return null;
        }
        PlanteDTO planteDTO = new PlanteDTO();
        planteDTO.setId_plante(planteModel.getId_plante());
        planteDTO.setNom(planteModel.getNom());
        planteDTO.setPoint_de_vie(planteModel.getPoint_de_vie());
        planteDTO.setAttaque_par_seconde(planteModel.getAttaque_par_seconde());
        planteDTO.setDegat_attaque(planteModel.getDegat_attaque());
        planteDTO.setCout(planteModel.getCout());
        planteDTO.setSoleil_par_seconde(planteModel.getSoleil_par_seconde());
        planteDTO.setEffet(planteModel.getEffet());
        planteDTO.setChemin_image(planteModel.getChemin_image());
        return planteDTO;
    }

    public List<PlanteDTO> mapListModelToListDto(List<PlanteModel> planteModels){
        List<PlanteDTO> planteDTOS = new ArrayList<>();
        for (PlanteModel planteModel : planteModels){
            planteDTOS.add(this.mapModelToDto(planteModel));
        }
        return (planteDTOS);
    }

    public PlanteModel mapDtoToModel(PlanteDTO planteDTO){
        if (planteDTO == null){
            return null;
        }
        PlanteModel planteModel = new PlanteModel();
        planteModel.setId_plante(planteDTO.getId_plante());
        planteModel.setNom(planteDTO.getNom());
        planteModel.setPoint_de_vie(planteDTO.getPoint_de_vie());
        planteModel.setAttaque_par_seconde(planteDTO.getAttaque_par_seconde());
        planteModel.setDegat_attaque(planteDTO.getDegat_attaque());
        planteModel.setCout(planteDTO.getCout());
        planteModel.setSoleil_par_seconde(planteDTO.getSoleil_par_seconde());
        planteModel.setEffet(planteDTO.getEffet());
        planteModel.setChemin_image(planteDTO.getChemin_image());
        return planteModel;
    }

    public List<PlanteModel> mapListDtoToListModel(List<PlanteDTO> planteDTOS){
        List<PlanteModel> planteModels = new ArrayList<>();
        for (PlanteDTO planteDTO : planteDTOS){
            planteModels.add(this.mapDtoToModel(planteDTO));
        }
        return (planteModels);
    }
}
