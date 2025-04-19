package testUnitaire.testController.mapper;

import com.oxyl.coursepfback.controller.DTO.ZombieDTO;
import com.oxyl.coursepfback.controller.mapper.ZombieDtoMapper;
import com.oxyl.coursepfback.service.model.ZombieModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ZombieDtoMapperTest {

    private final ZombieDtoMapper zombieDtoMapper = new ZombieDtoMapper();

    @Test
    public void DTOToModel(){
        ZombieDTO zombieDTO = new ZombieDTO(1, "Zombie1", 100, 20, 10, 1, "chemin1", 0);

        ZombieModel result = zombieDtoMapper.mapDtoToModel(zombieDTO);

        assertNotNull(result);
        assertEquals(zombieDTO.getId_zombie(), result.getId_zombie());
        assertEquals(zombieDTO.getNom(), result.getNom());
        assertEquals(zombieDTO.getPoint_de_vie(), result.getPoint_de_vie());
        assertEquals(zombieDTO.getAttaque_par_seconde(), result.getAttaque_par_seconde(), 0.0001);
        assertEquals(zombieDTO.getDegat_attaque(), result.getDegat_attaque());
        assertEquals(zombieDTO.getVitesse_de_deplacement(), result.getVitesse_de_deplacement(), 0.0001);
        assertEquals(zombieDTO.getChemin_image(), result.getChemin_image());
        assertEquals(zombieDTO.getId_map(), result.getId_map());
    }

    @Test
    public void modelToDTO(){
        ZombieModel zombieModel = new ZombieModel(1, "Zombie1", 100, 20, 10, 1, "chemin1", 0);

        ZombieDTO result = zombieDtoMapper.mapModelToDto(zombieModel);

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
    public void listDTOToListModel(){
        List<ZombieDTO> zombieEntities = List.of(
                new ZombieDTO(1, "Zombie1", 100, 20, 10, 1, "chemin1", 0),
                new ZombieDTO(2, "Zombie2", 200, 30, 20, 2, "chemin2", 1)
        );
        List<ZombieModel> result = zombieDtoMapper.mapListDtoToListModel(zombieEntities);

        assertNotNull(result);
        assertEquals(zombieEntities.size(), result.size());
        for (ZombieDTO zombieDTO : zombieEntities){
            assertEquals(zombieDTO.getId_zombie(), result.get(zombieEntities.indexOf(zombieDTO)).getId_zombie());
        }
    }

    @Test
    public void listModelToListDTO(){
        List<ZombieModel> zombieModels = List.of(
                new ZombieModel(1, "Zombie1", 100, 20, 10, 1, "chemin1", 0),
                new ZombieModel(2, "Zombie2", 200, 30, 20, 2, "chemin2", 1)
        );
        List<ZombieDTO> result = zombieDtoMapper.mapListModelToListDto(zombieModels);

        assertNotNull(result);
        assertEquals(zombieModels.size(), result.size());
        for (ZombieModel zombieModel : zombieModels){
            assertEquals(zombieModel.getId_zombie(), result.get(zombieModels.indexOf(zombieModel)).getId_zombie());
        }
    }
}
