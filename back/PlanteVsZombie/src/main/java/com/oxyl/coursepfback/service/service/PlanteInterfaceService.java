package com.oxyl.coursepfback.service.service;

import com.oxyl.coursepfback.service.model.PlanteModel;

import java.util.List;

public interface PlanteInterfaceService {
    public PlanteModel findById(int id);
    public List<PlanteModel> findAll();
    public void add(PlanteModel planteModel);
    public void deletePlante(int id);
    public void updatePlante(int id, PlanteModel planteModel);


}
