package testUnitaire.testController.controller;

import com.oxyl.coursepfback.controller.DTO.ZombieDTO;
import com.oxyl.coursepfback.controller.controller.ZombieController;
import com.oxyl.coursepfback.controller.mapper.ZombieDtoMapper;
import com.oxyl.coursepfback.service.model.ZombieModel;
import com.oxyl.coursepfback.service.service.ZombieService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ZombieControllerTest {
    @Mock
    private ZombieService zombieService;

    @InjectMocks
    private ZombieController zombieController;

    @Mock
    private ZombieDtoMapper zombieDtoMapper = new ZombieDtoMapper();

    @Test
    public void testGetAllZombies() {
        List<ZombieDTO> zombieDTOs = List.of(
                new ZombieDTO(1, "Zombie1", 100, 20, 50, 100, "chemin1", 1),
                new ZombieDTO(2, "Zombie2", 200, 30, 60, 200, "chemin2", 2),
                new ZombieDTO(3, "Zombie3", 300, 40, 70, 300, "chemin3", 3)
        );
        List<ZombieModel> zombieModels = List.of(
                new ZombieModel(1, "Zombie1", 100, 20, 50, 100, "chemin1", 1),
                new ZombieModel(2, "Zombie2", 200, 30, 60, 200, "chemin2", 2),
                new ZombieModel(3, "Zombie3", 300, 40, 70, 300, "chemin3", 3)
        );
        when(zombieDtoMapper.mapListModelToListDto(zombieModels)).thenReturn(zombieDTOs);
        when(zombieService.findAll()).thenReturn(zombieModels);
        List<ZombieDTO> result = zombieController.getAllZombies();

        assertEquals(zombieDTOs.size(), result.size());
        verify(zombieService, times(1)).findAll();
    }

    @Test
    public void testGetZombieById() {
        ZombieDTO zombieDTO = new ZombieDTO(1, "Zombie1", 100, 20, 50, 100, "chemin1", 1);
        ZombieModel zombieModel = new ZombieModel(1, "Zombie1", 100, 20, 50, 100, "chemin1", 1);

        when(zombieDtoMapper.mapModelToDto(zombieModel)).thenReturn(zombieDTO);
        when(zombieService.findById(1)).thenReturn(zombieModel);

        ZombieDTO result = zombieController.getZombieById(1);

        assertEquals(zombieDTO.getId_zombie(), result.getId_zombie());
        verify(zombieService, times(1)).findById(1);
    }

    @Test
    public void testAddZombie() {
        ZombieDTO zombieDTO = new ZombieDTO(1, "Zombie1", 100, 20, 50, 100, "chemin1", 1);
        ZombieModel zombieModel = zombieDtoMapper.mapDtoToModel(zombieDTO);

        zombieController.addZombie(zombieDTO);
        verify(zombieService, times(1)).add(zombieModel);
    }

    @Test
    public void testUpdateZombie() {
        ZombieDTO zombieDTO = new ZombieDTO(1, "Zombie1", 100, 20, 50, 100, "chemin1", 1);
        ZombieModel zombieModel = zombieDtoMapper.mapDtoToModel(zombieDTO);

        zombieController.updateZombie(1, zombieDTO);
        verify(zombieService, times(1)).updateZombie(1, zombieModel);
    }

    @Test
    public void testDeleteZombie() {
        int zombieId = 1;

        zombieController.deleteZombie(zombieId);
        verify(zombieService, times(1)).deleteZombie(zombieId);
    }



}
