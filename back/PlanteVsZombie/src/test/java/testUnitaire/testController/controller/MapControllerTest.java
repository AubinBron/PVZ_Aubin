package testUnitaire.testController.controller;

import com.oxyl.coursepfback.controller.DTO.MapDTO;
import com.oxyl.coursepfback.controller.controller.MapController;
import com.oxyl.coursepfback.controller.mapper.MapDtoMapper;
import com.oxyl.coursepfback.service.model.MapModel;
import com.oxyl.coursepfback.service.service.MapService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MapControllerTest {
    @Mock
    private MapService mapService;

    @InjectMocks
    private MapController mapController;

    @Mock
    private MapDtoMapper mapDtoMapper = new MapDtoMapper();

    @Test
    public void testGetAllMaps() {
        List<MapDTO> mapDTOs = List.of(
                new MapDTO(1, 9, 9, "chemin1"),
                new MapDTO(2, 10, 10, "chemin2"),
                new MapDTO(3, 11, 11, "chemin3")
        );
        List<MapModel> mapModels = List.of(
                new MapModel(1, 9, 9, "chemin1"),
                new MapModel(2, 10, 10, "chemin2"),
                new MapModel(3, 11, 11, "chemin3")
        );

        when(mapDtoMapper.mapListModelToListDto(mapModels)).thenReturn(mapDTOs);
        when(mapService.findAll()).thenReturn(mapModels);

        List<MapDTO> result = mapController.getAllMaps();

        assertEquals(mapDTOs.size(), result.size());
        verify(mapService, times(1)).findAll();
    }

    @Test
    public void testGetMapById() {
        MapDTO mapDTO = new MapDTO(1, 9, 9, "chemin1");
        MapModel mapModel = new MapModel(1, 9, 9, "chemin1");

        when(mapDtoMapper.mapModelToDto(mapModel)).thenReturn(mapDTO);
        when(mapService.findById(1)).thenReturn(mapModel);

        MapDTO result = mapController.getMapById(1);

        assertEquals(mapDTO.getId_map(), result.getId_map());
        verify(mapService, times(1)).findById(1);
    }

    @Test
    public void testAddMap() {
        MapDTO mapDTO = new MapDTO(1, 9, 9, "chemin1");
        MapModel mapModel = mapDtoMapper.mapDtoToModel(mapDTO);

        mapController.addMap(mapDTO);

        verify(mapService, times(1)).add(mapModel);
    }

    @Test
    public void testDeleteMap() {
        int mapId = 1;

        mapController.deleteMap(mapId);

        verify(mapService, times(1)).deleteMap(mapId);
    }

    @Test
    public void testUpdateMap() {
        int mapId = 1;
        MapDTO mapDTO = new MapDTO(1, 9, 9, "chemin1");
        MapModel mapModel = mapDtoMapper.mapDtoToModel(mapDTO);

        mapController.updateMap(mapId, mapDTO);

        verify(mapService, times(1)).updateMap(mapId, mapModel);
    }
}
