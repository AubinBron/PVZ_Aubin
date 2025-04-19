package com.oxyl.coursepfback.persistance.repository;

import com.oxyl.coursepfback.persistance.DAO.MapDAO;
import com.oxyl.coursepfback.persistance.mapper.MapEntityMapper;
import com.oxyl.coursepfback.service.model.MapModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MapRepository {
    private final MapDAO mapDAO;
    private final MapEntityMapper mapEntityMapper;

    @Autowired
    public MapRepository(MapDAO mapDAO, MapEntityMapper mapEntityMapper) {
        this.mapDAO = mapDAO;
        this.mapEntityMapper = mapEntityMapper;
    }

    //GET
    public MapModel findById(int id) {
        return mapEntityMapper.mapEntityToModel(mapDAO.getMapById(id));
    }

    public List<MapModel> findAll() {
        return mapEntityMapper.mapListEntityToListModel(mapDAO.getAllMaps());
    }

    //CREATE
    public void addMap(MapModel mapModel) {
        mapDAO.addMap(mapEntityMapper.mapModelToEntity(mapModel));
    }

    //DELETE
    public void deleteMap(int id) {
        mapDAO.deleteMap(id);
    }

    //UPDATE
    public void updateMap(int id, MapModel mapModel) {
        mapDAO.updateMap(id, mapEntityMapper.mapModelToEntity(mapModel));
    }

    public List<Integer> getAllMapIds() {
        return mapDAO.getAllMapIds();
    }
}
