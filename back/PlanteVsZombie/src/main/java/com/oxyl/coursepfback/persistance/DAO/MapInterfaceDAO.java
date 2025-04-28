package com.oxyl.coursepfback.persistance.DAO;

import com.oxyl.coursepfback.persistance.entity.MapEntity;
import com.oxyl.coursepfback.service.model.MapModel;

import java.util.List;

public interface MapInterfaceDAO {
    public List<MapEntity> getAllMaps();

    public MapEntity getMapById(int id);

    public void addMap(MapEntity mapEntity);

    public void deleteMap(int mapId);

    public void updateMap(int id, MapEntity mapEntity);

    public List<Integer> getAllMapIds();
}

/*
Maps
GET /maps - Liste toutes les maps
GET /maps/{id} - Récupère une map par son ID
POST /maps - Crée une nouvelle map
PUT /maps/{id} - Modifie une map existante
DELETE /maps/{id} - Supprime une map
 */