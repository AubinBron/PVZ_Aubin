package com.oxyl.coursepfback.persistance.mapper;

import com.oxyl.coursepfback.persistance.entity.MapEntity;
import com.oxyl.coursepfback.service.model.MapModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapEntityMapper {

    public MapModel mapEntityToModel(MapEntity mapEntity){
        if (mapEntity==null){
            return null;
        }
        MapModel mapModel = new MapModel();
        mapModel.setId_map(mapEntity.getId_map());
        mapModel.setLigne(mapEntity.getLigne());
        mapModel.setColonne(mapEntity.getColonne());
        mapModel.setChemin_image(mapEntity.getChemin_image());
        return mapModel;
    }

    public List<MapModel> mapListEntityToListModel(List<MapEntity> mapEntities){
        List<MapModel> mapModels = new ArrayList<>();
        for (MapEntity mapEntity : mapEntities){
            mapModels.add(this.mapEntityToModel(mapEntity));
        }
        return mapModels;
    }

    public MapEntity mapModelToEntity(MapModel mapModel){
        if (mapModel==null){
            return null;
        }
        MapEntity mapEntity = new MapEntity();
        mapEntity.setId_map(mapModel.getId_map());
        mapEntity.setLigne(mapModel.getLigne());
        mapEntity.setColonne(mapModel.getColonne());
        mapEntity.setChemin_image(mapModel.getChemin_image());
        return mapEntity;
    }

    public List<MapEntity> mapListModelToListEntity(List<MapModel> mapModels){
        List<MapEntity> mapEntities = new ArrayList<>();
        for (MapModel mapModel : mapModels){
            mapEntities.add(this.mapModelToEntity(mapModel));
        }
        return mapEntities;
    }
}
