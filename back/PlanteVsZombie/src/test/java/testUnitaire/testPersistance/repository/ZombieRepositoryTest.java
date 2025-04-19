package testUnitaire.testPersistance.repository;

import com.oxyl.coursepfback.persistance.DAO.ZombieDAO;
import com.oxyl.coursepfback.persistance.entity.ZombieEntity;
import com.oxyl.coursepfback.persistance.mapper.ZombieEntityMapper;
import com.oxyl.coursepfback.persistance.repository.ZombieRepository;
import com.oxyl.coursepfback.service.model.ZombieModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ZombieRepositoryTest {
    @Mock
    private ZombieDAO zombieDAO;

    @InjectMocks
    private ZombieRepository zombieRepository;

    @Mock
    private ZombieEntityMapper zombieEntityMapper = new ZombieEntityMapper();

    @Test
    public void testFindAll() {
        List<ZombieModel> zombieModels = List.of(
                new ZombieModel(1, "Zombie1", 100, 20.0f, 10, 1.0f, "chemin1", 0),
                new ZombieModel(2, "Zombie2", 200, 30.0f, 20, 1.5f, "chemin2", 0),
                new ZombieModel(3, "Zombie3", 300, 40.0f, 30, 2.0f, "chemin3", 0)
        );
        List<ZombieEntity> zombieEntities = List.of(
                new ZombieEntity(1, "Zombie1", 100, 20.0f, 10, 1.0f, "chemin1", 0),
                new ZombieEntity(2, "Zombie2", 200, 30.0f, 20, 1.5f, "chemin2", 0),
                new ZombieEntity(3, "Zombie3", 300, 40.0f, 30, 2.0f, "chemin3", 0)
        );

        when(zombieEntityMapper.mapListEntityToListModel(zombieEntities)).thenReturn(zombieModels);
        when(zombieDAO.getAllZombies()).thenReturn(zombieEntities);

        List<ZombieModel> result = zombieRepository.findAll();

        assertEquals(zombieModels.size(), result.size());
        verify(zombieDAO, times(1)).getAllZombies();
    }

    @Test
    public void testFindById() {
        int id = 1;
        ZombieModel zombieModel = new ZombieModel(id, "Zombie1", 100, 20, 10, 1, "chemin1", 0);
        ZombieEntity zombieEntity = new ZombieEntity(id, "Zombie1", 100, 20, 10, 1, "chemin1", 0);

        when(zombieEntityMapper.mapEntityToModel(zombieEntity)).thenReturn(zombieModel);
        when(zombieDAO.getZombieById(id)).thenReturn(zombieEntity);

        ZombieModel result = zombieRepository.findById(id);

        assertEquals(zombieModel, result);
        verify(zombieDAO, times(1)).getZombieById(id);
    }

    @Test
    public void testAddZombie() {
        ZombieModel zombieModel = new ZombieModel(1, "Zombie1", 100, 20.0f, 10, 1.0f, "chemin1", 0);
        ZombieEntity zombieEntity = zombieEntityMapper.mapModelToEntity(zombieModel);

        zombieRepository.addZombie(zombieModel);

        verify(zombieDAO, times(1)).addZombie(zombieEntity);
    }

    @Test
    public void testUpdateZombie() {
        int id = 1;
        ZombieModel zombieModel = new ZombieModel(id, "Zombie1", 100, 20.0f, 10, 1.0f, "chemin1", 0);
        ZombieEntity zombieEntity = zombieEntityMapper.mapModelToEntity(zombieModel);

        zombieRepository.updateZombie(id, zombieModel);

        verify(zombieDAO, times(1)).updateZombie(id, zombieEntity);
    }

    @Test
    public void testDeleteZombie() {
        int id = 1;

        zombieRepository.deleteZombie(id);

        verify(zombieDAO, times(1)).deleteZombie(id);
    }

    @Test
    public void testDeleteZombieByMapId() {
        int mapId = 1;

        zombieRepository.deleteZombieByMapId(mapId);

        verify(zombieDAO, times(1)).deleteZombiesByMapId(mapId);
    }
}
