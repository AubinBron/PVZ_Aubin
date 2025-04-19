package testUnitaire.testPersistance.repository;

import com.oxyl.coursepfback.persistance.DAO.MapDAO;
import com.oxyl.coursepfback.persistance.entity.MapEntity;
import com.oxyl.coursepfback.persistance.mapper.MapEntityMapper;
import com.oxyl.coursepfback.persistance.repository.MapRepository;
import com.oxyl.coursepfback.service.model.MapModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MapRepositoryTest {
    @Mock
    private MapDAO mapDAO;

    @InjectMocks
    private MapRepository mapRepository;

    @Mock
    private MapEntityMapper mapEntityMapper = new MapEntityMapper();

    @Test
    public void testFindAll() {
        List<MapModel> mapModels = List.of(
                new MapModel(1, 9, 9, "chemin1"),
                new MapModel(2, 10, 10, "chemin2"),
                new MapModel(3, 11, 11, "chemin3")
        );
        List<MapEntity> mapEntities = List.of(
                new MapEntity(1, 9, 9, "chemin1"),
                new MapEntity(2, 10, 10, "chemin2"),
                new MapEntity(3, 11, 11, "chemin3")
        );

        when(mapEntityMapper.mapListEntityToListModel(mapEntities)).thenReturn(mapModels);
        when(mapDAO.getAllMaps()).thenReturn(mapEntities);

        List<MapModel> result = mapRepository.findAll();

        assertEquals(mapModels.size(), result.size());
        verify(mapDAO, times(1)).getAllMaps();
    }

    @Test
    public void testFindById() {
        int id = 1;
        MapModel mapModel = new MapModel(id, 9, 9, "chemin1");
        MapEntity mapEntity = new MapEntity(id, 9, 9, "chemin1");

        when(mapEntityMapper.mapEntityToModel(mapEntity)).thenReturn(mapModel);
        when(mapDAO.getMapById(id)).thenReturn(mapEntity);

        MapModel result = mapRepository.findById(id);

        assertEquals(mapModel, result);
        verify(mapDAO, times(1)).getMapById(id);
    }

    @Test
    public void testAddMap() {
        MapModel mapModel = new MapModel(1, 9, 9, "chemin1");
        MapEntity mapEntity = mapEntityMapper.mapModelToEntity(mapModel);

        mapRepository.addMap(mapModel);

        verify(mapDAO, times(1)).addMap(mapEntity);
    }

    @Test
    public void testDeleteMap() {
        int id = 1;

        mapRepository.deleteMap(id);

        verify(mapDAO, times(1)).deleteMap(id);
    }

    @Test
    public void testUpdateMap() {
        int id = 1;
        MapModel mapModel = new MapModel(id, 9, 9, "chemin1");
        MapEntity mapEntity = mapEntityMapper.mapModelToEntity(mapModel);

        mapRepository.updateMap(id, mapModel);

        verify(mapDAO, times(1)).updateMap(id, mapEntity);
    }
}
