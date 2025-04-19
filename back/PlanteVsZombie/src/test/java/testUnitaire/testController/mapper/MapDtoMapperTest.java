package testUnitaire.testController.mapper;

import com.oxyl.coursepfback.controller.DTO.MapDTO;
import com.oxyl.coursepfback.controller.mapper.MapDtoMapper;
import com.oxyl.coursepfback.service.model.MapModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MapDtoMapperTest {
    private MapDtoMapper mapDtoMapper = new MapDtoMapper();

    @Test
    public void DTOToModel() {
        MapDTO mapDTO = new MapDTO(1, 100, 200, "chemin1");
        MapModel result = mapDtoMapper.mapDtoToModel(mapDTO);

        assertNotNull(result);
        assertEquals(mapDTO.getId_map(), result.getId_map());
        assertEquals(mapDTO.getLigne(), result.getLigne());
        assertEquals(mapDTO.getColonne(), result.getColonne());
        assertEquals(mapDTO.getChemin_image(), result.getChemin_image());

    }

    @Test
    public void modelToDTO() {
        MapModel mapModel = new MapModel(1, 100, 200, "chemin1");
        MapDTO result = mapDtoMapper.mapModelToDto(mapModel);

        assertNotNull(result);
        assertEquals(mapModel.getId_map(), result.getId_map());
        assertEquals(mapModel.getLigne(), result.getLigne());
        assertEquals(mapModel.getColonne(), result.getColonne());
        assertEquals(mapModel.getChemin_image(), result.getChemin_image());

    }

    @Test
    public void listDTOToListModel() {
        List<MapDTO> mapEntities = List.of(
                new MapDTO(1, 100, 200, "chemin1"),
                new MapDTO(2, 150, 250, "chemin2")
        );
        List<MapModel> result = mapDtoMapper.mapListDtoToListModel(mapEntities);

        assertNotNull(result);
        assertEquals(mapEntities.size(), result.size());
        for (MapDTO mapDTO : mapEntities) {
            assertEquals(mapDTO.getId_map(), result.get(mapEntities.indexOf(mapDTO)).getId_map());
        }
    }

    @Test
    public void listModelToListDTO() {
        List<MapModel> mapModels = List.of(
                new MapModel(1, 100, 200, "chemin1"),
                new MapModel(2, 150, 250, "chemin2")
        );
        List<MapDTO> result = mapDtoMapper.mapListModelToListDto(mapModels);

        assertNotNull(result);
        assertEquals(mapModels.size(), result.size());
        for (MapModel mapModel : mapModels) {
            assertEquals(mapModel.getId_map(), result.get(mapModels.indexOf(mapModel)).getId_map());
        }
    }
}
