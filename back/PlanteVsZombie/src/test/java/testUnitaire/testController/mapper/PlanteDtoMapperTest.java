package testUnitaire.testController.mapper;

import com.oxyl.coursepfback.controller.DTO.PlanteDTO;
import com.oxyl.coursepfback.controller.mapper.PlanteDtoMapper;
import com.oxyl.coursepfback.service.model.PlanteModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PlanteDtoMapperTest {
    private final PlanteDtoMapper planteDtoMapper = new PlanteDtoMapper();

    @Test
    public void DTOToModel() {
        PlanteDTO planteDTO = new PlanteDTO(1, "Plante1", 100, 10, 20, 30, 40, "effet 1", "chemin1");
        PlanteModel result = planteDtoMapper.mapDtoToModel(planteDTO);

        assertNotNull(result);
        assertEquals(planteDTO.getId_plante(), result.getId_plante());
        assertEquals(planteDTO.getNom(), result.getNom());
        assertEquals(planteDTO.getPoint_de_vie(), result.getPoint_de_vie());
        assertEquals(planteDTO.getAttaque_par_seconde(), result.getAttaque_par_seconde(), 0.0001);
        assertEquals(planteDTO.getDegat_attaque(), result.getDegat_attaque());
        assertEquals(planteDTO.getCout(), result.getCout());
        assertEquals(planteDTO.getSoleil_par_seconde(), result.getSoleil_par_seconde(), 0.0001);
        assertEquals(planteDTO.getEffet(), result.getEffet());
        assertEquals(planteDTO.getChemin_image(), result.getChemin_image());
    }

    @Test
    public void modelToDTO() {
        PlanteModel planteModel = new PlanteModel(1, "Plante1", 100, 10, 20, 30, 40, "effet 1", "chemin1");
        PlanteDTO result = planteDtoMapper.mapModelToDto(planteModel);

        assertNotNull(result);
        assertEquals(planteModel.getId_plante(), result.getId_plante());
        assertEquals(planteModel.getNom(), result.getNom());
        assertEquals(planteModel.getPoint_de_vie(), result.getPoint_de_vie());
        assertEquals(planteModel.getAttaque_par_seconde(), result.getAttaque_par_seconde(), 0.0001);
        assertEquals(planteModel.getDegat_attaque(), result.getDegat_attaque());
        assertEquals(planteModel.getCout(), result.getCout());
        assertEquals(planteModel.getSoleil_par_seconde(), result.getSoleil_par_seconde(), 0.0001);
        assertEquals(planteModel.getEffet(), result.getEffet());
        assertEquals(planteModel.getChemin_image(), result.getChemin_image());
    }

    @Test
    public void listDTOToListModel() {
        List<PlanteDTO> planteEntities = List.of(
                new PlanteDTO(1, "Plante1", 100, 10, 20, 30, 40, "effet 1", "chemin1"),
                new PlanteDTO(2, "Plante2", 150, 15, 25, 35, 45, "effet 2", "chemin2")
        );
        List<PlanteModel> result = planteDtoMapper.mapListDtoToListModel(planteEntities);

        assertNotNull(result);
        assertEquals(planteEntities.size(), result.size());
        for (PlanteDTO planteDTO : planteEntities) {
            assertEquals(planteDTO.getId_plante(), result.get(planteEntities.indexOf(planteDTO)).getId_plante());
        }
    }

    @Test
    public void listModelToListDTO() {
        List<PlanteModel> planteModels = List.of(
                new PlanteModel(1, "Plante1", 100, 10, 20, 30, 40, "effet 1", "chemin1"),
                new PlanteModel(2, "Plante2", 150, 15, 25, 35, 45, "effet 2", "chemin2")
        );
        List<PlanteDTO> result = planteDtoMapper.mapListModelToListDto(planteModels);

        assertNotNull(result);
        assertEquals(planteModels.size(), result.size());
        for (PlanteModel planteModel : planteModels) {
            assertEquals(planteModel.getId_plante(), result.get(planteModels.indexOf(planteModel)).getId_plante());
        }
    }
}
