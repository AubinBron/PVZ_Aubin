package com.oxyl.coursepfback.service.service;

import com.oxyl.coursepfback.persistance.repository.PlanteRepository;
import com.oxyl.coursepfback.service.model.PlanteModel;
import com.oxyl.coursepfback.service.model.ZombieModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanteService implements PlanteInterfaceService {
    private final PlanteRepository planteRepository;

    @Autowired
    public PlanteService(PlanteRepository planteRepository) {
        this.planteRepository = planteRepository;
    }

    public PlanteModel findById(int id) {
        return planteRepository.findById(id);
    }

    public List<PlanteModel> findAll() {
        return planteRepository.findAll();
    }

    public void add(PlanteModel planteModel) {
        planteRepository.addPlante(planteModel);
    }

    public void deletePlante(int id) {
        planteRepository.deletePlante(id);
    }

    public void updatePlante(int id, PlanteModel planteModel) {
        planteRepository.updatePlante(id, planteModel);
    }



}
