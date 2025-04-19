package testUnitaire.testPersistance.repository;

import com.oxyl.coursepfback.persistance.DAO.PlanteDAO;
import com.oxyl.coursepfback.persistance.entity.PlanteEntity;
import com.oxyl.coursepfback.persistance.mapper.PlanteEntityMapper;
import com.oxyl.coursepfback.service.model.PlanteModel;
import com.oxyl.coursepfback.persistance.repository.PlanteRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlanteRepositoryTest {
    @Mock
    private PlanteDAO planteDAO;

    @InjectMocks
    private PlanteRepository planteRepository;

    @Mock
    private PlanteEntityMapper planteEntityMapper = new PlanteEntityMapper();

    @Test
    public void testFindAll() {
        List<PlanteModel> planteModels= List.of(
                new PlanteModel(1, "Plante1", 100, 20, 50, 100, 0, "effet1", "chemin1"),
                new PlanteModel(2, "Plante2", 200, 30, 60, 200, 0, "effet2", "chemin2"),
                new PlanteModel(3, "Plante3", 300, 40, 70, 300, 0, "effet3", "chemin3")
        );
        List<PlanteEntity> planteEntities = List.of(
                new PlanteEntity(1, "Plante1", 100, 20, 50, 100, 0, "effet1", "chemin1"),
                new PlanteEntity(2, "Plante2", 200, 30, 60, 200, 0, "effet2", "chemin2"),
                new PlanteEntity(3, "Plante3", 300, 40, 70, 300, 0, "effet3", "chemin3")
        );

        when(planteEntityMapper.mapListEntityToListModel(planteEntities)).thenReturn(planteModels);
        when(planteDAO.getAllPlantes()).thenReturn(planteEntities);

        List<PlanteModel> result = planteRepository.findAll();

        assertEquals(planteModels.size(), result.size());
        verify(planteDAO, times(1)).getAllPlantes();


    }

    @Test
    public void testFindById() {
        int id = 1;
        PlanteModel planteModel = new PlanteModel(id, "Plante1", 100, 20, 50, 100, 0, "effet1", "chemin1");
        PlanteEntity planteEntity = new PlanteEntity(id, "Plante1", 100, 20, 50, 100, 0, "effet1", "chemin1");

        when(planteEntityMapper.mapEntityToModel(planteEntity)).thenReturn(planteModel);
        when(planteDAO.getPlanteById(id)).thenReturn(planteEntity);

        PlanteModel result = planteRepository.findById(id);

        assertEquals(planteModel, result);
        verify(planteDAO, times(1)).getPlanteById(id);
    }

    @Test
    public void testAddPlante() {
        PlanteModel planteModel = new PlanteModel(1, "Plante1", 100, 20, 50, 100, 0, "effet1", "chemin1");
        PlanteEntity planteEntity = planteEntityMapper.mapModelToEntity(planteModel);

        planteRepository.addPlante(planteModel);

        verify(planteDAO, times(1)).addPlante(planteEntity);
    }

    @Test
    public void testDeletePlante() {
        int id = 1;

        planteRepository.deletePlante(id);

        verify(planteDAO, times(1)).deletePlante(id);
    }

    @Test
    public void testUpdatePlante() {
        int id = 1;
        PlanteModel planteModel = new PlanteModel(id, "Plante1", 100, 20, 50, 100, 0, "effet1", "chemin1");
        PlanteEntity planteEntity = planteEntityMapper.mapModelToEntity(planteModel);

        planteRepository.updatePlante(id, planteModel);

        verify(planteDAO, times(1)).updatePlante(id, planteEntity);
    }
}
