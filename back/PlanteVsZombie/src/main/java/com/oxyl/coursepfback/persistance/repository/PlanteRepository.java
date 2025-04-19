package com.oxyl.coursepfback.persistance.repository;

import com.oxyl.coursepfback.persistance.DAO.PlanteDAO;
import com.oxyl.coursepfback.persistance.mapper.PlanteEntityMapper;
import com.oxyl.coursepfback.service.model.PlanteModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PlanteRepository {
    private final PlanteDAO planteDAO;
    private final PlanteEntityMapper planteEntityMapper;

    @Autowired
    public PlanteRepository(PlanteDAO planteDAO, PlanteEntityMapper planteEntityMapper) {
        this.planteDAO = planteDAO;
        this.planteEntityMapper = planteEntityMapper;
    }

    //GET
    public PlanteModel findById(int id) {
        return planteEntityMapper.mapEntityToModel(planteDAO.getPlanteById(id));
    }

    public List<PlanteModel> findAll() {
        return planteEntityMapper.mapListEntityToListModel(planteDAO.getAllPlantes());
    }

    //CREATE
    public void addPlante(PlanteModel planteModel) {
        planteDAO.addPlante(planteEntityMapper.mapModelToEntity(planteModel));
    }

    //DELETE
    public void deletePlante(int id) {
        planteDAO.deletePlante(id);
    }

    //UPDATE
    public void updatePlante(int id, PlanteModel planteModel) {
        planteDAO.updatePlante(id, planteEntityMapper.mapModelToEntity(planteModel));
    }



}
