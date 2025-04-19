package com.oxyl.coursepfback.persistance.DAO;

import com.oxyl.coursepfback.persistance.entity.PlanteEntity;
import com.oxyl.coursepfback.service.model.PlanteModel;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Component
public final class PlanteDAO extends DAO implements PlanteInterfaceDAO  {
    public PlanteDAO() {
        super();
    }

    public PlanteEntity getPlanteById(int id) {
        return jdbcTemplate.queryForObject("SELECT * FROM Plante WHERE id_plante = ?", new Object[]{id}, (rs, rownum)->{
            return new PlanteEntity(rs.getInt("id_plante"), rs.getString("nom"), rs.getInt("point_de_vie"), rs.getFloat("attaque_par_seconde"), rs.getInt("degat_attaque"), rs.getInt("cout"), rs.getFloat("soleil_par_seconde"), rs.getString("effet"), rs.getString("chemin_image"));
        });
    }

    public List<PlanteEntity> getAllPlantes() {
        return jdbcTemplate.query("SELECT * FROM Plante", (rs, rownum)->{
            return new PlanteEntity(rs.getInt("id_plante"), rs.getString("nom"), rs.getInt("point_de_vie"), rs.getFloat("attaque_par_seconde"), rs.getInt("degat_attaque"), rs.getInt("cout"), rs.getFloat("soleil_par_seconde"), rs.getString("effet"), rs.getString("chemin_image"));
        });
    }

    public void addPlante(PlanteEntity plante) {
        jdbcTemplate.update("INSERT INTO Plante (nom, point_de_vie, attaque_par_seconde, degat_attaque, cout, soleil_par_seconde, effet, chemin_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)", plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(), plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(), plante.getEffet(), plante.getChemin_image());
    }

    public void deletePlante(int id) {
        jdbcTemplate.update("DELETE FROM Plante WHERE id_plante = ?", id);
    }

    public void updatePlante(int id, PlanteEntity plante) {
        jdbcTemplate.update("UPDATE Plante SET nom = ?, point_de_vie = ?, attaque_par_seconde = ?, degat_attaque = ?, cout = ?, soleil_par_seconde = ?, effet = ?, chemin_image = ? WHERE id_plante = ?", plante.getNom(), plante.getPoint_de_vie(), plante.getAttaque_par_seconde(), plante.getDegat_attaque(), plante.getCout(), plante.getSoleil_par_seconde(), plante.getEffet(), plante.getChemin_image(), id);
    }
}