package com.oxyl.coursepfback.persistance.DAO;

import com.oxyl.coursepfback.persistance.entity.PlanteEntity;
import com.oxyl.coursepfback.service.model.PlanteModel;

import java.util.List;

public interface PlanteInterfaceDAO {

    public List<PlanteEntity> getAllPlantes();

    public PlanteEntity getPlanteById(int id);

    public void addPlante(PlanteEntity planteEntity);

    public void deletePlante(int planteId);

    public void updatePlante(int id, PlanteEntity planteEntity);

}

/*
Plantes
GET /plantes - Liste toutes les plantes
GET /plantes/{id} - Récupère une plante par son ID
POST /plantes - Crée une nouvelle plante
PUT /plantes/{id} - Modifie une plante existante
DELETE /plantes/{id} - Supprime une plante
*/
