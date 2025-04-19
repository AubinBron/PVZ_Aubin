package testUnitaire.testService;

import com.oxyl.coursepfback.persistance.repository.PlanteRepository;
import com.oxyl.coursepfback.service.model.PlanteModel;
import com.oxyl.coursepfback.service.service.PlanteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PlanteServiceTest {
    @Mock
    private PlanteRepository planteRepository;
    @InjectMocks
    private PlanteService planteService;

    @Test
    public void testFindAll() {
        List<PlanteModel> plantes = List.of(
                new PlanteModel(1, "Plante1", 100, 20, 50, 100, 0, "effet1", "chemin1"),
                new PlanteModel(2, "Plante2", 200, 30, 60, 200, 0, "effet2", "chemin2"),
                new PlanteModel(3, "Plante3", 300, 40, 70, 300, 0, "effet3", "chemin3")
        );
        when(planteRepository.findAll()).thenReturn(plantes);

        List <PlanteModel> findAllService = planteService.findAll();

        assertEquals(plantes.size(), findAllService.size());
        verify(planteRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        PlanteModel plante = new PlanteModel(1, "Plante1", 100, 20, 50, 100, 0, "effet1", "chemin1");
        when(planteRepository.findById(1)).thenReturn(plante);

        PlanteModel findByIdService = planteService.findById(1);

        assertEquals(plante.getId_plante(), findByIdService.getId_plante());
        verify(planteRepository, times(1)).findById(1);
    }

    @Test
    public void testAdd() {
        PlanteModel plante = new PlanteModel(1, "New Plante", 100, 20, 50, 100, 0, "effet1", "chemin1");

        planteService.add(plante);
        verify(planteRepository, times(1)).addPlante(plante);
    }

    @Test
    public void testDeletePlante() {
        int planteId = 1;

        planteService.deletePlante(planteId);
        verify(planteRepository, times(1)).deletePlante(planteId);
    }

    @Test
    public void testUpdatePlante() {
        PlanteModel plante = new PlanteModel(1, "Updated Plante", 150, 25, 55, 150, 0, "effet1", "chemin1");

        planteService.updatePlante(plante.getId_plante(), plante);
        verify(planteRepository, times(1)).updatePlante(plante.getId_plante(), plante);
    }

}
