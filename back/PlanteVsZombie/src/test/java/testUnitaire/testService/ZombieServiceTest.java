package testUnitaire.testService;

import com.oxyl.coursepfback.persistance.repository.ZombieRepository;
import com.oxyl.coursepfback.service.model.ZombieModel;
import com.oxyl.coursepfback.service.service.ZombieService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ZombieServiceTest {
    @Mock
    private ZombieRepository zombieRepository;

    @InjectMocks
    private ZombieService zombieService;

    @Test
    public void testFindById() {
        ZombieModel zombie = new ZombieModel(1, "Zombie1", 100, 20, 50, 100, "chemin", 1);
        when(zombieRepository.findById(1)).thenReturn(zombie);
        ZombieModel foundZombie = zombieService.findById(1);
        assertEquals(zombie.getId_zombie(), foundZombie.getId_zombie());

        verify(zombieRepository, times(1)).findById(1);
    }

    @Test
    public void testFindAll() {
        List<ZombieModel> zombies = List.of(
                new ZombieModel(1, "Zombie1", 100, 20, 50, 100, "chemin1", 1),
                new ZombieModel(2, "Zombie2", 200, 30, 60, 200, "chemin2", 2),
                new ZombieModel(3, "Zombie3", 300, 40, 70, 300, "chemin3", 3)
        );

        when(zombieRepository.findAll()).thenReturn(zombies);

        List<ZombieModel> foundZombies = zombieService.findAll();

        assertEquals(zombies.size(), foundZombies.size());
        verify(zombieRepository, times(1)).findAll();
    }

    @Test
    public void testAdd() {
        ZombieModel zombie = new ZombieModel(1, "Zombie1", 100, 20, 50, 100, "chemin", 1);

        zombieService.add(zombie);
        verify(zombieRepository, times(1)).addZombie(zombie);
    }

    @Test
    public void testUpdateZombie() {
        ZombieModel zombie = new ZombieModel(1, "Zombie1", 100, 20, 50, 100, "chemin", 1);

        zombieService.updateZombie(1, zombie);
        verify(zombieRepository, times(1)).updateZombie(1, zombie);
    }

    @Test
    public void testDeleteZombie() {
        int zombieId = 1;

        zombieService.deleteZombie(zombieId);
        verify(zombieRepository, times(1)).deleteZombie(zombieId);
    }

}
