package testUnitaire.testService;

import com.oxyl.coursepfback.persistance.repository.MapRepository;
import com.oxyl.coursepfback.persistance.repository.ZombieRepository;
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
public class MapServiceTest {
    @Mock
    private MapRepository mapRepository;
    @Mock
    private ZombieRepository zombieRepository;

    @InjectMocks
    private MapService mapService;

    @Test
    public void testFindById() {
        MapModel map = new MapModel(1, 9, 9, "path1");
        when(mapRepository.findById(1)).thenReturn(map);
        MapModel foundMap = mapService.findById(1);

        assertEquals(map.getId_map(), foundMap.getId_map());
        verify(mapRepository, times(1)).findById(1);
    }

    @Test
    public void testFindAll() {
        List<MapModel> maps = List.of(
                new MapModel(1, 9, 9, "path1"),
                new MapModel(2, 10, 10, "path2"),
                new MapModel(3, 11, 11, "path3")
        );

        when(mapRepository.findAll()).thenReturn(maps);

        List<MapModel> foundMaps = mapService.findAll();

        assertEquals(maps.size(), foundMaps.size());
        verify(mapRepository, times(1)).findAll();
    }

    @Test
    public void testAdd() {
        MapModel map = new MapModel(1, 9, 9, "path1");

        mapService.add(map);
        verify(mapRepository, times(1)).addMap(map);
    }

    @Test
    public void testDeleteMap() {
        int mapId = 1;

        mapService.deleteMap(mapId);
        verify(zombieRepository, times(1)).deleteZombieByMapId(mapId);
        verify(mapRepository, times(1)).deleteMap(mapId);
    }

    @Test
    public void testUpdateMap() {
        int mapId = 1;
        MapModel map = new MapModel(1, 9, 9, "path1");

        mapService.updateMap(mapId, map);
        verify(mapRepository, times(1)).updateMap(mapId, map);
    }
}
