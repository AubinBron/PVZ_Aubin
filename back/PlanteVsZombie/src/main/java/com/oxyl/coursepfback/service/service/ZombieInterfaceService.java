package com.oxyl.coursepfback.service.service;

import com.oxyl.coursepfback.service.model.ZombieModel;

import java.util.List;

public interface ZombieInterfaceService {
    public List<ZombieModel> findAll();
    public ZombieModel findById(int id);

    public void add(ZombieModel zombieModel);
    public void deleteZombie(int id);
    public void updateZombie(int id, ZombieModel zombieModel);
}
