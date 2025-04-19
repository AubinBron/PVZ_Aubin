package testUnitaire.testPersistance.mapper;

import com.oxyl.coursepfback.persistance.entity.PlanteEntity;
import com.oxyl.coursepfback.persistance.mapper.PlanteEntityMapper;
import com.oxyl.coursepfback.service.model.PlanteModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PlanteEntityMapperTest {
    private final PlanteEntityMapper planteEntityMapper = new PlanteEntityMapper();

    @Test
    public void entityToModel() {
        PlanteEntity planteEntity = new PlanteEntity(1, "Plante1", 100, 10, 20, 30, 40, "effet 1", "chemin1");
        PlanteModel result = planteEntityMapper.mapEntityToModel(planteEntity);

        assertNotNull(result);
        assertEquals(planteEntity.getId_plante(), result.getId_plante());
        assertEquals(planteEntity.getNom(), result.getNom());
        assertEquals(planteEntity.getPoint_de_vie(), result.getPoint_de_vie());
        assertEquals(planteEntity.getAttaque_par_seconde(), result.getAttaque_par_seconde(), 0.0001);
        assertEquals(planteEntity.getDegat_attaque(), result.getDegat_attaque());
        assertEquals(planteEntity.getCout(), result.getCout());
        assertEquals(planteEntity.getSoleil_par_seconde(), result.getSoleil_par_seconde(), 0.0001);
        assertEquals(planteEntity.getEffet(), result.getEffet());
        assertEquals(planteEntity.getChemin_image(), result.getChemin_image());
    }

    @Test
    public void modelToEntity() {
        PlanteModel planteModel = new PlanteModel(1, "Plante1", 100, 10, 20, 30, 40, "effet 1", "chemin1");
        PlanteEntity result = planteEntityMapper.mapModelToEntity(planteModel);

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
    public void listEntityToListModel() {
        List<PlanteEntity> planteEntities = List.of(
                new PlanteEntity(1, "Plante1", 100, 10, 20, 30, 40, "effet 1", "chemin1"),
                new PlanteEntity(2, "Plante2", 150, 15, 25, 35, 45, "effet 2", "chemin2")
        );
        List<PlanteModel> result = planteEntityMapper.mapListEntityToListModel(planteEntities);

        assertNotNull(result);
        assertEquals(planteEntities.size(), result.size());
        for (PlanteEntity planteEntity : planteEntities) {
            assertEquals(planteEntity.getId_plante(), result.get(planteEntities.indexOf(planteEntity)).getId_plante());
        }
    }

    @Test
    public void listModelToListEntity() {
        List<PlanteModel> planteModels = List.of(
                new PlanteModel(1, "Plante1", 100, 10, 20, 30, 40, "effet 1", "chemin1"),
                new PlanteModel(2, "Plante2", 150, 15, 25, 35, 45, "effet 2", "chemin2")
        );
        List<PlanteEntity> result = planteEntityMapper.mapListModelToListEntity(planteModels);

        assertNotNull(result);
        assertEquals(planteModels.size(), result.size());
        for (PlanteModel planteModel : planteModels) {
            assertEquals(planteModel.getId_plante(), result.get(planteModels.indexOf(planteModel)).getId_plante());
        }
    }
}
