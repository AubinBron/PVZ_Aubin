package com.oxyl.coursepfback.service.service;

import com.oxyl.coursepfback.service.model.MapModel;

import java.util.List;

public interface MapInterfaceSercive {
    public MapModel findById(int id);

    public List<MapModel> findAll();

    public void add(MapModel mapModel);

    public void deleteMap(int id);

    public void updateMap(int id, MapModel mapModel);

    public List<Integer> getAllMapIds();
}
