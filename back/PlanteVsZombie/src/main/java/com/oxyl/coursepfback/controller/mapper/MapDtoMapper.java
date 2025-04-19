package com.oxyl.coursepfback.controller.mapper;

import com.oxyl.coursepfback.controller.DTO.MapDTO;
import com.oxyl.coursepfback.service.model.MapModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapDtoMapper {

    public MapDTO mapModelToDto(MapModel mapModel){
        if (mapModel == null){
            return null;
        }
        MapDTO mapDTO = new MapDTO();
        mapDTO.setId_map(mapModel.getId_map());
        mapDTO.setColonne(mapModel.getColonne());
        mapDTO.setLigne(mapModel.getLigne());
        mapDTO.setChemin_image(mapModel.getChemin_image());
        return mapDTO;
    }

    public List<MapDTO> mapListModelToListDto(List<MapModel> mapModels){
        List<MapDTO> mapDTOS = new ArrayList<>();
        for (MapModel mapModel : mapModels){
            mapDTOS.add(this.mapModelToDto(mapModel));
        }
        return (mapDTOS);
    }

    public MapModel mapDtoToModel(MapDTO mapDTO){
        if (mapDTO == null){
            return null;
        }
        MapModel mapModel = new MapModel();
        mapModel.setId_map(mapDTO.getId_map());
        mapModel.setColonne(mapDTO.getColonne());
        mapModel.setLigne(mapDTO.getLigne());
        mapModel.setChemin_image(mapDTO.getChemin_image());
        return mapModel;
    }

    public List<MapModel> mapListDtoToListModel(List<MapDTO> mapDTOS){
        List<MapModel> mapModels = new ArrayList<>();
        for (MapDTO mapDTO : mapDTOS){
            mapModels.add(this.mapDtoToModel(mapDTO));
        }
        return (mapModels);
    }


}
