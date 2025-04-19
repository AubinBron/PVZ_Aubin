package testUnitaire.testController.controller;

import com.oxyl.coursepfback.controller.DTO.PlanteDTO;
import com.oxyl.coursepfback.controller.controller.PlanteController;
import com.oxyl.coursepfback.controller.mapper.PlanteDtoMapper;
import com.oxyl.coursepfback.service.model.PlanteModel;
import com.oxyl.coursepfback.service.service.PlanteService;
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
public class PlanteControllerTest {
    @Mock
    private PlanteService planteService;

    @InjectMocks
    private PlanteController planteController;

    @Mock
    private PlanteDtoMapper planteDtoMapper = new PlanteDtoMapper();

    @Test
    public void testGetAllPlantes() {
        List<PlanteDTO> planteDTOs = List.of(
                new PlanteDTO(1, "Plante1", 100, 20, 50, 100, 0, "effet1", "chemin1"),
                new PlanteDTO(2, "Plante2", 200, 30, 60, 200, 0, "effet2", "chemin2"),
                new PlanteDTO(3, "Plante3", 300, 40, 70, 300, 0, "effet3", "chemin3")
        );
        List<PlanteModel> planteModels = List.of(
                new PlanteModel(1, "Plante1", 100, 20, 50, 100, 0, "effet1", "chemin1"),
                new PlanteModel(2, "Plante2", 200, 30, 60, 200, 0, "effet2", "chemin2"),
                new PlanteModel(3, "Plante3", 300, 40, 70, 300, 0, "effet3", "chemin3")
        );
        when(planteDtoMapper.mapListModelToListDto(planteModels)).thenReturn(planteDTOs);
        when(planteService.findAll()).thenReturn(planteModels);

        List<PlanteDTO> result = planteController.getAllPlantes();

        assertEquals(planteDTOs.size(), result.size());
        verify(planteService, times(1)).findAll();
    }

    @Test
    public void testGetPlanteById() {
        PlanteDTO planteDTO = new PlanteDTO(1, "Plante1", 100, 20, 50, 100, 0, "effet1", "chemin1");
        PlanteModel planteModel = new PlanteModel(1, "Plante1", 100, 20, 50, 100, 0, "effet1", "chemin1");

        when(planteDtoMapper.mapModelToDto(planteModel)).thenReturn(planteDTO);
        when(planteService.findById(1)).thenReturn(planteModel);

        PlanteDTO result = planteController.getPlanteById(1);

        assertEquals(planteDTO.getId_plante(), result.getId_plante());
        verify(planteService, times(1)).findById(1);
    }

    @Test
    public void testAddPlante() {
        PlanteDTO planteDTO = new PlanteDTO(1, "Plante1", 100, 20, 50, 100, 0, "effet1", "chemin1");
        PlanteModel planteModel = planteDtoMapper.mapDtoToModel(planteDTO);

        planteController.addPlante(planteDTO);
        verify(planteService, times(1)).add(planteModel);
    }

    @Test
    public void testUpdatePlante() {
        PlanteDTO planteDTO = new PlanteDTO(1, "Plante1", 100, 20, 50, 100, 0, "effet1", "chemin1");
        PlanteModel planteModel = planteDtoMapper.mapDtoToModel(planteDTO);

        planteController.updatePlante(1, planteDTO);
        verify(planteService, times(1)).updatePlante(1, planteModel);
    }

    @Test
    public void testDeletePlante() {
        int planteId = 1;

        planteController.deletePlante(planteId);

        verify(planteService, times(1)).deletePlante(planteId);
    }
}
