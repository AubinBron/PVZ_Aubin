package testUnitaire.testPersistance.mapper;

import com.oxyl.coursepfback.persistance.entity.MapEntity;
import com.oxyl.coursepfback.persistance.mapper.MapEntityMapper;
import com.oxyl.coursepfback.service.model.MapModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MapEntityMapperTest {
    private MapEntityMapper mapEntityMapper = new MapEntityMapper();

    @Test
    public void entityToModel() {
        MapEntity mapEntity = new MapEntity(1, 100, 200, "chemin1");
        MapModel result = mapEntityMapper.mapEntityToModel(mapEntity);

        assertNotNull(result);
        assertEquals(mapEntity.getId_map(), result.getId_map());
        assertEquals(mapEntity.getLigne(), result.getLigne());
        assertEquals(mapEntity.getColonne(), result.getColonne());
        assertEquals(mapEntity.getChemin_image(), result.getChemin_image());

    }

    @Test
    public void modelToEntity() {
        MapModel mapModel = new MapModel(1, 100, 200, "chemin1");
        MapEntity result = mapEntityMapper.mapModelToEntity(mapModel);

        assertNotNull(result);
        assertEquals(mapModel.getId_map(), result.getId_map());
        assertEquals(mapModel.getLigne(), result.getLigne());
        assertEquals(mapModel.getColonne(), result.getColonne());
        assertEquals(mapModel.getChemin_image(), result.getChemin_image());

    }

    @Test
    public void listEntityToListModel() {
        List<MapEntity> mapEntities = List.of(
                new MapEntity(1, 100, 200, "chemin1"),
                new MapEntity(2, 150, 250, "chemin2")
        );
        List<MapModel> result = mapEntityMapper.mapListEntityToListModel(mapEntities);

        assertNotNull(result);
        assertEquals(mapEntities.size(), result.size());
        for (MapEntity mapEntity : mapEntities) {
            assertEquals(mapEntity.getId_map(), result.get(mapEntities.indexOf(mapEntity)).getId_map());
        }
    }

    @Test
    public void listModelToListEntity() {
        List<MapModel> mapModels = List.of(
                new MapModel(1, 100, 200, "chemin1"),
                new MapModel(2, 150, 250, "chemin2")
        );
        List<MapEntity> result = mapEntityMapper.mapListModelToListEntity(mapModels);

        assertNotNull(result);
        assertEquals(mapModels.size(), result.size());
        for (MapModel mapModel : mapModels) {
            assertEquals(mapModel.getId_map(), result.get(mapModels.indexOf(mapModel)).getId_map());
        }
    }
}
