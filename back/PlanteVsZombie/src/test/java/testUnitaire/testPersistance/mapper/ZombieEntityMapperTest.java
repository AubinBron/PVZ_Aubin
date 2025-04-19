package testUnitaire.testPersistance.mapper;

import com.oxyl.coursepfback.persistance.entity.ZombieEntity;
import com.oxyl.coursepfback.persistance.mapper.ZombieEntityMapper;
import com.oxyl.coursepfback.service.model.ZombieModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ZombieEntityMapperTest {

    private final ZombieEntityMapper zombieEntityMapper = new ZombieEntityMapper();

    @Test
    public void entityToModel(){
        ZombieEntity zombieEntity = new ZombieEntity(1, "Zombie1", 100, 20, 10, 1, "chemin1", 0);

        ZombieModel result = zombieEntityMapper.mapEntityToModel(zombieEntity);

        assertNotNull(result);
        assertEquals(zombieEntity.getId_zombie(), result.getId_zombie());
        assertEquals(zombieEntity.getNom(), result.getNom());
        assertEquals(zombieEntity.getPoint_de_vie(), result.getPoint_de_vie());
        assertEquals(zombieEntity.getAttaque_par_seconde(), result.getAttaque_par_seconde(), 0.0001);
        assertEquals(zombieEntity.getDegat_attaque(), result.getDegat_attaque());
        assertEquals(zombieEntity.getVitesse_de_deplacement(), result.getVitesse_de_deplacement(), 0.0001);
        assertEquals(zombieEntity.getChemin_image(), result.getChemin_image());
        assertEquals(zombieEntity.getId_map(), result.getId_map());
    }

    @Test
    public void modelToEntity(){
        ZombieModel zombieModel = new ZombieModel(1, "Zombie1", 100, 20, 10, 1, "chemin1", 0);

        ZombieEntity result = zombieEntityMapper.mapModelToEntity(zombieModel);

        assertNotNull(result);
        assertEquals(zombieModel.getId_zombie(), result.getId_zombie());
        assertEquals(zombieModel.getNom(), result.getNom());
        assertEquals(zombieModel.getPoint_de_vie(), result.getPoint_de_vie());
        assertEquals(zombieModel.getAttaque_par_seconde(), result.getAttaque_par_seconde(), 0.0001);
        assertEquals(zombieModel.getDegat_attaque(), result.getDegat_attaque());
        assertEquals(zombieModel.getVitesse_de_deplacement(), result.getVitesse_de_deplacement(), 0.0001);
        assertEquals(zombieModel.getChemin_image(), result.getChemin_image());
        assertEquals(zombieModel.getId_map(), result.getId_map());
    }

    @Test
    public void listEntityToListModel(){
        List<ZombieEntity> zombieEntities = List.of(
                new ZombieEntity(1, "Zombie1", 100, 20, 10, 1, "chemin1", 0),
                new ZombieEntity(2, "Zombie2", 200, 30, 20, 2, "chemin2", 1)
        );
        List<ZombieModel> result = zombieEntityMapper.mapListEntityToListModel(zombieEntities);

        assertNotNull(result);
        assertEquals(zombieEntities.size(), result.size());
        for (ZombieEntity zombieEntity : zombieEntities){
            assertEquals(zombieEntity.getId_zombie(), result.get(zombieEntities.indexOf(zombieEntity)).getId_zombie());
        }
    }

    @Test
    public void listModelToListEntity(){
        List<ZombieModel> zombieModels = List.of(
                new ZombieModel(1, "Zombie1", 100, 20, 10, 1, "chemin1", 0),
                new ZombieModel(2, "Zombie2", 200, 30, 20, 2, "chemin2", 1)
        );
        List<ZombieEntity> result = zombieEntityMapper.mapListModelToListEntity(zombieModels);

        assertNotNull(result);
        assertEquals(zombieModels.size(), result.size());
        for (ZombieModel zombieModel : zombieModels){
            assertEquals(zombieModel.getId_zombie(), result.get(zombieModels.indexOf(zombieModel)).getId_zombie());
        }
    }
}
